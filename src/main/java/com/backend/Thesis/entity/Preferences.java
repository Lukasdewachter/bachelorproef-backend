package com.backend.Thesis.entity;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Preferences {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private long idStudent;

    @Column
    private long firstChoice;

    @Column
    private long secondChoice;

    @Column
    private long thirdChoice;

    @Column
    private Boolean submitted;

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public long getIdStudent() {return idStudent;}
    public void setIdStudent(long idStudent) { this.idStudent = idStudent;}

    public long getFirstChoice() {return firstChoice;}
    public void setFirstChoice(long firstChoice) {this.firstChoice = firstChoice;}

    public long getSecondChoice() {return secondChoice;}
    public void setSecondChoice(long secondChoice) {this.secondChoice = secondChoice;}

    public long getThirdChoice() {return thirdChoice;}
    public void setThirdChoice(long thirdChoice) {this.thirdChoice = thirdChoice;}

    public Boolean getSubmitted() {return submitted;}
    public void setSubmitted(Boolean submitted) {this.submitted = submitted;}
}
