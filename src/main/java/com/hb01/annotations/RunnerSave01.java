package com.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {
        Student01 student1 = new Student01();

        student1.setId(1001);
        student1.setName("Fatma Ersöz");
        student1.setGrade(90);
        //hibernate konfigurasyon ve entity siniflarini gösterdik.
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student1);
        tx.commit();
        session.close();
        sf.close();
        ////
    }
}
