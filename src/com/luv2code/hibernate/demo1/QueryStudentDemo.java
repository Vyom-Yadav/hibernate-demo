package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();

            //query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            //display the students
            theStudents.forEach(System.out::println);

            //query students: lastName = "Yadav"
            theStudents = session.createQuery("from Student s where s.lastName='Yadav'").getResultList();
            theStudents.forEach(System.out::println);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");


        } finally {
            factory.close();
        }


    }

}
