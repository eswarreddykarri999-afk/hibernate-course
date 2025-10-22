package org.example.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main_Alien_OneToOne {
    public static void main(String[] args) {

        Laptop_One l1 = new Laptop_One();
        l1.setLid(101);
        l1.setBrand("Apple");
        l1.setModel("Macbook");
        l1.setRam(8);

        Alien_One a1 = new Alien_One();
        a1.setAid(1);
        a1.setAname("Harsh");
        a1.setTech("Java");
        a1.setLaptop(l1);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Alien_One.class)
                .addAnnotatedClass(Laptop_One.class)
                .configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(a1);
        session.persist(l1);

        transaction.commit();

        System.out.println(a1);
        session.close();
        sf.close();
    }
}
