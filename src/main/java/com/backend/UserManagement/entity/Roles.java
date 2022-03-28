package com.backend.UserManagement.entity;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Roles {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    public Roles(){
    }

    public Roles(String name){
        this.name = name;
    }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
}
