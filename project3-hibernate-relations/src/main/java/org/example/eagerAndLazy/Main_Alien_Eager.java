package org.example.eagerAndLazy;

import org.example.manyToMany.Alien_Manymany;
import org.example.manyToMany.Laptop_Manymany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main_Alien_Eager {
    public static void main(String[] args) {

        Laptop_Eager l1 = new Laptop_Eager();
        l1.setLid(101);
        l1.setBrand("Apple");
        l1.setModel("Macbook");
        l1.setRam(8);

        Laptop_Eager l2 = new Laptop_Eager();
        l2.setLid(102);
        l2.setBrand("Lenovo");
        l2.setModel("Thinkpad");
        l2.setRam(16);

        Laptop_Eager l3 = new Laptop_Eager();
        l3.setLid(103);
        l3.setBrand("DELL");
        l3.setModel("XPS");
        l3.setRam(32);

        Alien_Eager a1 = new Alien_Eager();
        a1.setAid(1);
        a1.setAname("Harsh");
        a1.setTech("Java");

        Alien_Eager a2 = new Alien_Eager();
        a2.setAid(2);
        a2.setAname("Eswar");
        a2.setTech("Python");

        a1.setLaptops(Arrays.asList(l1, l2));
        a2.setLaptops(Arrays.asList(l3));

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Alien_Eager.class)
                .addAnnotatedClass(Laptop_Eager.class)
                .configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);
        session.persist(a1);

        transaction.commit();
//        Alien_Eager a5 = session.find(Alien_Eager.class, 1);
//
//        System.out.println(a5);

        session.close();

        Session session1 = sf.openSession();

        Alien_Eager a5 = session1.find(Alien_Eager.class, 1);

        //System.out.println(a5);
        session1.close();

        sf.close();
    }
}
