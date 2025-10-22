package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main_Update {
    public static void main(String[] args) {
        //update age of Rani from 25 to 24
        Student s1 = new Student();
        s1.setRollNo(107);
        s1.setsName("Jithu");
        s1.setsAge(28);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.merge(s1);// used to update or create new record.

        transaction.commit();

        session.close();
        sf.close();

        System.out.println(s1);
    }
}
