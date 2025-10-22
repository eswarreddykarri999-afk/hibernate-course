package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_Read {
    public static void main(String[] args) {

        Student s1 = null;

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        s1 = session.find(Student.class, 102);

        session.close();
        sf.close();

        System.out.println(s1);
    }
}