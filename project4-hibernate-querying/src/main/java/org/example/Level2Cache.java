package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Level2Cache {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Laptop l1 = session.find(Laptop.class, 102);
        System.out.println(l1);
//        Laptop l2 = session.find(Laptop.class, 102);
//        System.out.println(l2);//It prints query oonly one time
        session.close();

        Session session1 = sf.openSession();
        Laptop l2 = session1.find(Laptop.class, 102);
        System.out.println(l2);// It prints query second time
        // so add dependencies and add @cacheable
        session1.close();
        sf.close();
    }
}
