package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main_Delete {
    public static void main(String[] args) {
        Student s;

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        s = session.find(Student.class, 107);

        Transaction transaction = session.beginTransaction();
        session.remove(s);
        transaction.commit();

        session.close();
        sf.close();


    }
}
