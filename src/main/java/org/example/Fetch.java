package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Fetch {
    public static void main(String[] args) {

        Student2 s2 = null;
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Student2.class)
                .configure()
                .buildSessionFactory();//con.buildSessionFactory();
        Session session = sf.openSession();

        s2 = session.find(Student2.class, 102);

        session.close();
        sf.close();

        System.out.println(s2);
    }
}