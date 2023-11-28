package com.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {
    public static void main(String[] args) {



        //Runner tarafta oldugumuz icin bir conffigrasion class olusturmamiz grekiyor

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student02.class);



        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        //DB ile alalkali yapacagimiz tüm islemleri beginTransaction ile tx.commit arasinda yapacagiz.
        Student02 student = session.get(Student02.class,1001);


        System.out.println(student.getAddress());
        //System.out.println(student);


        tx.commit();
        session.close();
        sf.close();//bu sessionFactory dir




    }
}
