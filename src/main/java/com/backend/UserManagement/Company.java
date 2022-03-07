package com.backend.UserManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Company {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idCompany;
    private String companyName;
    private String contactName;
    private String mail;
    private Integer tel;
    private String address;

    public Integer getIdCompany() {return idCompany;}
    public void setIdCompany(Integer idcompany) {
        this.idCompany = idcompany;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyname) {
        this.companyName = companyname;
    }

    public String getContactName() {return contactName;}
    public void setContactName(String contactname) {
        this.contactName = contactname;
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
}