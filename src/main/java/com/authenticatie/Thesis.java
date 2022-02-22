package com.authenticatie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Thesis {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idthesis;
    private String name;
    private String description;
    private String fieldofstudy;
    private String campus;

    public Integer getIdthesis() {return idthesis;}
    public void setIdthesis(Integer idmasterproeven) {
        this.idthesis = idmasterproeven;
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

    public String getFieldOfStudy() {return fieldofstudy;}
    public void setFieldOfStudy(String fieldofstudy) {this.fieldofstudy = fieldofstudy;}

    public String getCampus() {
        return campus;
    }
    public void setCampus(String campus) {this.campus = campus;}
}