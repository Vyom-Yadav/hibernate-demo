package OfficeDB;

import com.luv2code.hibernate.demo.entity.DateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class PerformOperations {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

           /* Employee numOne = new Employee("Vyom", "Yadav", DateUtils.parseDate("28/09/2002"), "Google");
            session.save(numOne);*/



            //session.get(Employee.class, 1).setDateOfBirth(dob);
            Date dob = DateUtils.parseDate("20/07/2001");
            session.createQuery("UPDATE Employee SET dateOfBirth =:dob WHERE id=1")
                    .setParameter("dob", dob)
                    .executeUpdate();
            session.getTransaction().commit();


            System.out.println("Done!");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            factory.close();
        }

    }
}
