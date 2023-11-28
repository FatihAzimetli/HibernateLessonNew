package com.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {
        //öclikle pörses etmek istedigimiz veriler olusturulur yani setlenecek tablo

        Student02 student1 = new Student02();
        student1.setId(1001);
        student1.setName("Yusuf Kaplan");
        student1.setGrade(80);


        // burada bir adress bilgisi setliyecegiz
        Address address1 = new Address();
        address1.setStreet("Apple Street");
        address1.setCity("Istanbul");
        address1.setCountry("Turkey");
        address1.setZipCode("06853");

        student1.setAddress(address1); //ögrenci ile adresini baglama

        Address address2 = new Address();
        address2.setStreet("Orange Street");
        address2.setCity("Istanbul");
        address2.setCountry("Turkey");
        address2.setZipCode("06853");

        Student02 student2 = new Student02();
        student2.setId(1002);
        student2.setName("Sinan Sarikaya");
        student2.setGrade(85);

        student2.setAddress(address2);//ögrenci ile adresini baglama


        //Runner tarafta oldugumuz icin bir conffigrasion class olusturmamiz grekiyor

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student02.class);

        //HB üzerinde DB ile irtibata gecmek icin alttaki kod blogunu yaziyoruz 1. bir session olusturacagiz ve
        //session üzerinden transsectation baslatmamiz gerekiyor.

        SessionFactory sf = con.buildSessionFactory();
        //olusturdgumuz bu sesion üzerinden transsecttitation baslatmamiz gerekiyor sf ile basliyacagiz
          Session session = sf.openSession();
          Transaction tx = session.beginTransaction();
          // en önemlisi session ve session factorileri commit mutlaka kapatmaliyiz
        session.save(student1);
        session.save(student2);
        tx.commit(); //commit DB gidip hemen neticelenmesini saglar bunun cod blogunu üstüne yaziyoruz.
        // yani ögrencileri kaydediyoruz
        session.close();
        sf.close();//bu sessionFactory dir






    }
}
