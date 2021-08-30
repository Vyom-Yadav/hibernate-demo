package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {

            System.out.println("Creating a new student object...");

            // create the student object
            Student tempStudent = new Student("Daffy", "Duck", "DD@gmail.com");

            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student...");
            System.out.println(tempStudent);
            session.save(tempStudent);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");

            //find out the student's id: primary key
            System.out.println("Generated id: "+tempStudent.getId());

            //now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on id
            System.out.println("Getting student with id: "+tempStudent.getId());
            System.out.println();

            Student myStudent = session.get(Student.class, tempStudent.getId());
            System.out.println("Get Complete: "+ myStudent.toString());

            //commit the transaction
            session.getTransaction().commit();


        } finally {
            factory.close();
        }


    }

}
