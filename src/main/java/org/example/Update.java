package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Update {
    public static void main(String[] args) {
        Student2 s1 = new Student2();
        s1.setRollNo(109);
        s1.setsName("Amit");
        s1.setsAge(29);//for harsh, it was 27, updated to 23.

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Student2.class)
                .configure()
                .buildSessionFactory();//con.buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.merge(s1);
        //merge is used to update or save new record

        transaction.commit();
        session.close();
        sf.close();

        System.out.println(s1);
    }
}