package com.hd03.uni_direction;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {

        Student03 student1 = new Student03();
        student1.setId(1001);
        student1.setName("Yusuf Kaplan");
        student1.setGrade(80);

        Student03 student2 = new Student03();
        student2.setId(1002);
        student2.setName("Sinan Sarikaya");
        student2.setGrade(85);

        Student03 student3 = new Student03();
        student3.setId(1003);
        student3.setName("Sezer Genc");
        student3.setGrade(85);

        // 3 nesne olusturduk ve iliskileri kurabilmek icin 2 adet günlük nesnesi olusturuyoruz
        Diary diary1 = new Diary();
        diary1.setId(101);
        diary1.setName("Yusuf beyin Günlügü");
        diary1.setStudent(student1);//setleme

        Diary diary2 = new Diary();
        diary2.setId(102);
        diary2.setName("Sinan beyin Günlügü");
        diary2.setStudent(student2);//setleme

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);
        // standart session factory olusturacagiz ve tetikleyecegiz
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();//sf= sesionFactory anlamina gelen kisaltma
        Transaction tx = session.beginTransaction(); // unutmamak icin hemen commit ve clos medotlarini yaziyoruz
        //Olusturulan nesleleri kaydediyoruz
        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);

        tx.commit();
        session.close();
        sf.close();






    }
}
