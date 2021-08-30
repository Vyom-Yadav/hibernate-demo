package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session;

        try {
            int studentId = 1;

            //now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on id
            System.out.println("Getting student with id: "+studentId);

            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Get Complete: "+ myStudent.toString());
            myStudent.setFirstName("Scooby");
            System.out.println("Get Complete: "+ myStudent.toString());

            session.getTransaction().commit();

            //NEW CODE

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Update email for all students");

            session.createQuery("update Student set email='foo@gmail.com'")
                    .executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }


    }

}
