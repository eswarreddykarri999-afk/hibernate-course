package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Delete {
    public static void main(String[] args) {
        Student2 s1 = new Student2();


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Student2.class)
                .configure()
                .buildSessionFactory();//con.buildSessionFactory();

        Session session = sf.openSession();

        s1 = session.find(Student2.class, 109);

        Transaction transaction = session.beginTransaction();

        session.remove(s1);

        transaction.commit();

        session.close();
        sf.close();

        System.out.println(s1);
    }
}