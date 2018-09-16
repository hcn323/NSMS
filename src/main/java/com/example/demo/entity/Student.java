package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class Student {

    @Id
    private String studentId;//学号
    private String name;
    private String password;
    private String sex;
    private String institute;
    private String id;//身份证号
    private Blob photo;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="pay_fee",joinColumns = {@JoinColumn(name="student_id",referencedColumnName = "studentId")},
    inverseJoinColumns = {@JoinColumn(name="fee_id",referencedColumnName = "id")})
    private Collection<Fee> fees=new ArrayList<Fee>();

    //private Collection<Fee> fees;


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collection<Fee> getFees() {
        return fees;
    }

    public void setFees(Collection<Fee> fees) {
        this.fees = fees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }
}
