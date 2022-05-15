package com.backend.UserManagement.entity;

import javax.persistence.*;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
public class Roles {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @OneToMany(mappedBy="role")
    private Set<User> users;

    public Roles(){
    }

    public Roles(String name){
        this.name = name;
    }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public Set<User> getUsers(){
        return users;
    }

    public void setUsers(Set<User> users){
        this.users = users;
    }

    public void addUser(User user){
        this.users.add((user));
    }
}
