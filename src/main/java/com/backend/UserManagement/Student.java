package com.backend.UserManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idStudent;
    private String name;
    private String surname;
    private String mail;
    private Integer tel;
    private String address;
    private String fieldOfStudy;

    public Integer getIdStudent() {return idStudent;}
    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {this.mail = mail;}

    public Integer getTel() {return tel;}
    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getAddress() {return address;}
    public void setAddress(String address) {
        this.address = address;
    }

    public String getFieldOfStudy() {return fieldOfStudy;}
    public void setFieldOfStudy(String fieldOfStudy) {this.fieldOfStudy = fieldOfStudy;}
}