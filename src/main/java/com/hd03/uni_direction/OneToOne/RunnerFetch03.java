package com.hd03.uni_direction.OneToOne;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {



        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //!!! herhangi bir studenty Id ile fetch (: gidip grtirmek) edelim
        Student03 student =  session.get(Student03.class,1001);
        //!!! birtane diary gidip getirelim : Let's do a diary fetch
         Diary diary = session.get(Diary.class,101);
        System.out.println("=============" + student);
        System.out.println("-----------------------------------------");
        System.out.println(diary);
        System.out.println("----------------------------------------");
        System.out.println(diary.getStudent());


        tx.commit();
        session.close();
        sf.close();

    }
}
