package com.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;


public class RunnerFetch01 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        /*DB bilgi cekmek icin 3 yol vardir
        * 1. get method.u
        * 2 SQL methodu
        * 3.HQL (hibernate Query Languacge) methodu*/

        // get method'u

        /*  Student01 student1 = session.get(Student01.class,1001);
          Student01 student2 = session.get(Student01.class,1002);
          Student01 student3 = session.get(Student01.class,1003);
          Student01 student4 = session.get(Student01.class,1004);
          System.out.println(student1);
          System.out.println(student2);
          System.out.println(student3);
          System.out.println(student4);*/

        //SQL metodu jdbc tarafina kaymak zorundayiz get metodunu kullanmaktan vaz gecersek

      /*  String sqlQuery1 = "SELECT * FROM t_student01";
         List<Object[]> resultList1=  session.createSQLQuery(sqlQuery1).getResultList();//bunu prent class olarak almamiz gerekiyor
       for (Object[] objects: resultList1){
           System.out.println(Arrays.toString(objects));
       }*/
        //Farkli senaryolar olursa örnegin bir ögrenci getirmek Örnekleme AA
        /*String sqlQuery2 = "SELECT * FROM t_student01 WHERE student_name ='Fatma Ersöz'";
        Object[] uniqueResult1= (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
        System.out.println(Arrays.toString(uniqueResult1));*/
//HQL yöntemi
       /* String hqlQuery1 ="FROM Student01";
      List<Student01> resultList3 =  session.createQuery(hqlQuery1,Student01.class).getResultList();
      for (Student01 student01:resultList3){
          System.out.println(student01);
      }*/
      //Farkli senaryolar olursa örnegin bir ögrenci getirmek hql ile yazarkan tabloyu düsünmeden yapmaliyiz.Örnekleme AA
      /*  String hqlQuery2 = "FROM Student01 WHERE name='Fatma Ersöz'";
      Student01 uniqueResult2 =  session.createQuery(hqlQuery2, Student01.class).uniqueResult();
        System.out.println(uniqueResult2);*/
        //HQL +Alias yazilan query leri sorgusunu kisaltmak icin Alias kullanilir ayni senaryonun alias ile yazilmasi
      /*  String hqlQuery3 = "FROM Student01 std WHERE std.name='Fatma Ersöz'";
        Student01 uniqueResult3 =  session.createQuery(hqlQuery3, Student01.class).uniqueResult();
        System.out.println(uniqueResult3);*/
        //grade=90 olan ögrencileri getirelim-hql
       /* String hqlQuery4 = "SELECT s.id, s.name FROM Student01 s WHERE s.grade=90";
        List<Object[]> uniqueResult4 = session.createQuery(hqlQuery4).getResultList();
        for (Object[] objects: uniqueResult4){
            System.out.println(Arrays.toString(objects));
        }*/
        //id göre azalan sirali listeleyiniz
        String hqlQuery5 = "FROM Student01 s ORDER BY s.id desc";
         List<Student01> resultList1=  session.createQuery(hqlQuery5, Student01.class).getResultList();
         for (Student01 student01: resultList1){
             System.out.println(student01);
         }

        tx.commit();
        session.close();
        sf.close();
    }
}
