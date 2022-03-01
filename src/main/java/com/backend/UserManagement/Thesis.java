package com.backend.UserManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Thesis {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idThesis;
    private String name;
    private String description;
    private String fieldOfStudy;
    private String campus;

    public Integer getIdThesis() {return idThesis;}
    public void setIdThesis(Integer idThesis) {
        this.idThesis = idThesis;
    }

    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getFieldOfStudy() {return fieldOfStudy;}
    public void setFieldOfStudy(String fieldOfStudy) {this.fieldOfStudy = fieldOfStudy;}

    public String getCampus() {
        return campus;
    }
    public void setCampus(String campus) {this.campus = campus;}
}