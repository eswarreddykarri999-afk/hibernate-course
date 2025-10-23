package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

//        Laptop l1 = session.find(Laptop.class, 102);
//        System.out.println(l1);

        //To print based on quey
//        Query query = session.createQuery("from Laptop where ram=32", Laptop.class);
        //Query query = session.createQuery("from Laptop where brand like 'Lenovo'", Laptop.class);

//        String brand = "Lenovo";
//        Query query = session.createQuery("from Laptop where brand like ?1", Laptop.class);
//        query.setParameter(1, brand);
//        List<Laptop> laptopList = query.getResultList();

//        String brand = "Lenovo";
//        Query query = session.createQuery("select model from Laptop where brand like ?1", String.class);
//        query.setParameter(1, brand);
//        List<String> laptopList = query.getResultList();

        String brand = "Lenovo";
        Query query = session.createQuery("select brand, model from Laptop where brand like ?1", Object[].class);
        query.setParameter(1, brand);
        List<Object[]> laptopList = query.getResultList();

        for (Object[] data : laptopList) {
            System.out.println(data[0] + " " + data[1]);
        }

        //System.out.println(laptopList);

        session.close();
        sf.close();
    }
}