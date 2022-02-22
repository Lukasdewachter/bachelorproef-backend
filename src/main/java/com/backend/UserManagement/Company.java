package com.authenticatie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Company {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idcompany;
    private String companyname;
    private String contactname;
    private String mail;
    private Integer tel;
    private String adress;

    public Integer getId() {return idcompany;}
    public void setId(Integer idcompany) {
        this.idcompany = idcompany;
    }

    public String getSurname() {
        return companyname;
    }
    public void setSurname(String companyname) {
        this.companyname = companyname;
    }

    public String getName() {return contactname;}
    public void setName(String contactname) {
        this.contactname = contactname;
    }

    public String getmail() {
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
}