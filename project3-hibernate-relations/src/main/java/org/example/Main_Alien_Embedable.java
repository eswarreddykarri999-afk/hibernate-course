package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main_Alien_Embedable {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setBrand("Apple");
        l1.setModel("Macbook");
        l1.setRam(8);

        Alien a1 = new Alien();
        a1.setAid(1);
        a1.setAname("Harsh");
        a1.setTech("Java");
        a1.setLaptop(l1);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Alien.class)
                .configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(a1);

        transaction.commit();
        //Alien a2 = session.find(Alien.class, 101);// it prints insert query not select query
        System.out.println(a1);
        session.close();
        sf.close();
    }
}
