package com.hb01.annotations;

import javax.persistence.*;

@Entity // bu vertabaninda bir tabloya karsilik gelecek
@Table(name = "t_student01")
public class Student01 {
    @Id // bu artik primary key oldu
    private int id;

    @Column(name = "student_name", length = 100, nullable = false, unique = false)
    private String name;//javaca konusuyorsak name yaziyoruz ancak sql,ce konusacaksak student_name kullanacagim


    //@Transient // DB'de bir kolon olusmasin istedigimiz bu annonation kullaniyoruz.
    private int grade;


   /* @Lob //large object ile büyük boyutlu veriler DB de tutulabiliyor.
    private byte[] image;*/

// getter ve Setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    //toString() metodu bu klasta zorunlu olusturuluyor


    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
