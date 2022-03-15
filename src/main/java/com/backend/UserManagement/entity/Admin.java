package com.backend.UserManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity // This tells Hibernate to make a table out of this class
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAdmin;
    private String name;
    private String surname;
    private String mail;

    @JsonIgnore
    private String password;

    public Admin() {
    }

    public Admin(Admin admin) {
        this.idAdmin = admin.getIdAdmin();
        this.name = admin.getName();
        this.surname = admin.getSurname();
        this.mail = admin.getMail();
        this.password = admin.getPassword();
    }


    public Admin(Integer idAdmin, String name, String surname, String mail, String password){
        this.idAdmin = idAdmin;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
    }

    public Integer getIdAdmin(){return idAdmin;}
    public void setIdAdmin(Integer idAdmin){this.idAdmin = idAdmin;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getSurname(){return surname;}
    public void setSurname(String surname){this.surname = surname;}

    public String getMail(){return mail;}{}
    public void setMail(String mail){this.mail = mail;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}
}