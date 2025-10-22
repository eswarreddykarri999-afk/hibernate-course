package org.example.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main_Alien_ManyToMany {
    public static void main(String[] args) {

        Laptop_Manymany l1 = new Laptop_Manymany();
        l1.setLid(101);
        l1.setBrand("Apple");
        l1.setModel("Macbook");
        l1.setRam(8);

        Laptop_Manymany l2 = new Laptop_Manymany();
        l2.setLid(102);
        l2.setBrand("Lenovo");
        l2.setModel("Thinkpad");
        l2.setRam(16);

        Laptop_Manymany l3 = new Laptop_Manymany();
        l3.setLid(103);
        l3.setBrand("DELL");
        l3.setModel("XPS");
        l3.setRam(32);

        Alien_Manymany a1 = new Alien_Manymany();
        a1.setAid(1);
        a1.setAname("Harsh");
        a1.setTech("Java");

        Alien_Manymany a2 = new Alien_Manymany();
        a2.setAid(2);
        a2.setAname("Eswar");
        a2.setTech("Python");

        Alien_Manymany a3 = new Alien_Manymany();
        a1.setAid(3);
        a1.setAname("Kiran");
        a1.setTech("AI");


        a1.setLaptops(Arrays.asList(l1, l2));
        a2.setLaptops(Arrays.asList(l2, l3));
        a3.setLaptops(Arrays.asList(l1));

        l1.setAlien_manymany(Arrays.asList(a1, a3));
        l2.setAlien_manymany(Arrays.asList(a1, a2));
        l3.setAlien_manymany(Arrays.asList(a2));

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Alien_Manymany.class)
                .addAnnotatedClass(Laptop_Manymany.class)
                .configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();


        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);
        session.persist(a3);

        transaction.commit();

        System.out.println(a2);
        session.close();
        sf.close();
    }
}
