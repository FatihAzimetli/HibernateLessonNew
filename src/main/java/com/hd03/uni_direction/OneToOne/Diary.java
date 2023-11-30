package com.hd03.uni_direction.OneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary {
    @Id
    private int id;

    private String name;

    //iliskiyi burdan takip edecegimiz icin Student03 isminde bir degisken olusturacagiz
    @OneToOne
    @JoinColumn(name = "std_id")
    private Student03 student;//JoinColumn yazmasak bile HB default özelligi ile student_id yazacakti,
    // HB kendince defaul isimler üretmemesi icin @joinColumn mutlaka yazmaliyiz

    // getter ve setter

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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }
    //toString

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
