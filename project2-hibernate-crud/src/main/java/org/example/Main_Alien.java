package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main_Alien {
    public static void main(String[] args) {
        Alien a1 = new Alien();
        a1.setAid(1);
        a1.setAname("Harsh");
        a1.setTech("Java");

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Alien.class)
                .configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(a1);

        transaction.commit();
        session.close();
        sf.close();
    }
}
