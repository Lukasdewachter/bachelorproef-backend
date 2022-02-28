package com.backend.UserManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Professor {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idProfessor;
    private String name;
    private String surname;
    private String mail;
    private Integer tel;
    private String adress;
    private String fieldOfStudy;
    private String campus;
    private boolean coordinator;

    public Integer getIdProfessor() {return idProfessor;}
    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
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

    public String getAdress() {return adress;}
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getFieldOfStudy() {return fieldOfStudy;}
    public void setFieldOfStudy(String fieldofstudy) {this.fieldOfStudy = fieldofstudy;}

    public String getCampus() {return campus;}
    public void setCampus(String campus) {this.campus = campus;}

    public boolean getCoordinator() {
        return coordinator;
    }
    public void setCoordinator(boolean coordinator) {this.coordinator = coordinator;}
}