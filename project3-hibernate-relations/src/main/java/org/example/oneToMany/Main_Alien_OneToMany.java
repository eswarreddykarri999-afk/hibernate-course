package org.example.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main_Alien_OneToMany {
    public static void main(String[] args) {

        Laptop_Onemany l1 = new Laptop_Onemany();
        l1.setLid(101);
        l1.setBrand("Apple");
        l1.setModel("Macbook");
        l1.setRam(8);

        Laptop_Onemany l2 = new Laptop_Onemany();
        l2.setLid(102);
        l2.setBrand("Lenovo");
        l2.setModel("Thinkpad");
        l2.setRam(16);

        Alien_Onemany a1 = new Alien_Onemany();
        a1.setAid(1);
        a1.setAname("Harsh");
        a1.setTech("Java");
        a1.setLaptops(Arrays.asList(l1, l2));

        l1.setAlien_onemany(a1);
        l2.setAlien_onemany(a1);



        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Alien_Onemany.class)
                .addAnnotatedClass(Laptop_Onemany.class)
                .configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();


        session.persist(l1);
        session.persist(l2);
        session.persist(a1);

        transaction.commit();

        System.out.println(a1);
        session.close();
        sf.close();
    }
}
