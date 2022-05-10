package com.backend.Thesis.entity;

import com.backend.UserManagement.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
public class Thesis {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private String shortDescription;

    private String longDescription;
    private String fieldOfStudy;
    private String campus;
    private String promotor;
    private int numberOfPers;
    private Boolean approved;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "bookmarks")
    @JsonIgnore
    private Set<User> bookmarks = new HashSet<>();

    public long getId() {return id;}
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription(){return longDescription;}
    public void setLongDescription(String longDescription){ this.longDescription = longDescription;}

    public String getFieldOfStudy() {return fieldOfStudy;}
    public void setFieldOfStudy(String fieldOfStudy) {this.fieldOfStudy = fieldOfStudy;}

    public String getCampus() {
        return campus;
    }
    public void setCampus(String campus) {this.campus = campus;}

    public String getPromotor(){ return promotor; }
    public void setPromotor(String promotor) { this.promotor = promotor;}

    public int getnumberOfPers(){ return numberOfPers;}
    public void setnumberOfPers(int numberOfPers) { this.numberOfPers = numberOfPers;}

    public Boolean getApproved(){ return approved;}
    public void setApproved(Boolean approved) {this.approved = approved;}

    public Set<User> getBookmarks(){
        return bookmarks;
    }

    public void setBookmarks(Set<User> bookmarkUser){
        this.bookmarks = bookmarkUser;
    }
}