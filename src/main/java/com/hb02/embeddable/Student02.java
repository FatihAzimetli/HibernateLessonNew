package com.hb02.embeddable;

import javax.persistence.*;

@Entity
@Table (name = "t_student02")
public class Student02 {
    @Id
    private int id;


    @Column(name= "student_name",length = 100, nullable = false,unique = false)
    private String name;


    private int grade;


@Embedded //opsiyonel yazilmadanda calisir.
    private Address address; // burada bu tek fark olarak eklendi bunu yaptigimiz icin tablonun hedirlari
    /* id, student_name, grade, bunlari yazdiktan sonra private Address address; burayi görecek ve tabloyu dizayn edecek

    * id, student_name, grade, street, city, country, zipCode seklinde tabloyu dizayn edecek.@Embedded yazmasakta olur
      ancak kod okunurlugu icin yazacagiz*/

    // getter ve setter ancak önce embeddable klasi yapinca gelip yapacagiz


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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    //toString

    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", address=" + address +
                '}';
    }
}
