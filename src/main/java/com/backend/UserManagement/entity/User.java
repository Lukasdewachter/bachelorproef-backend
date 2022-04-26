package com.backend.UserManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String companyName;
    @Column
    private String firstName;
    @Column
    private String lastName;


    @Column
    private String mail;
    @Column
    private String tel;
    @Column
    private String address;

    @Column
    private String fieldOfStudy;
    @Column
    private String campus;
    @Column
    private int coordinator;

    @Column
    @JsonIgnore
    private String password;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID") })
    private Roles role;

    public User(){
    }

    // Admin & Student
    public User(String firstName, String lastName, String mail, String tel, String address, String fieldOfStudy, String campus, String password){
        super();

        this.firstName = firstName;
        this.lastName = lastName;

        this.mail = mail;
        this.tel = tel;
        this.address = address;

        this.fieldOfStudy = fieldOfStudy;
        this.campus = campus;

        this.password = password;
    }

    // Company
    public User(String companyName, String firstName, String lastName, String mail, String tel, String address, String password){
        super();

        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;

        this.mail = mail;
        this.tel = tel;
        this.address = address;

        this.password = password;
    }

    // Professor
    public User(String firstName, String lastName, String mail, String tel, String address, String fieldOfStudy, String campus, int coordinator, String password){
        super();

        this.firstName = firstName;
        this.lastName = lastName;

        this.mail = mail;
        this.tel = tel;
        this.address = address;

        this.fieldOfStudy = fieldOfStudy;
        this.campus = campus;
        this.coordinator = coordinator;

        this.password = password;
    }

    public User(User user) {
        this.id = user.getId();

        this.companyName = user.getCompanyName();
        this.firstName = user.getFirstName();
        this.lastName = user.getSurname();

        this.mail = user.getMail();
        this.tel = user.getTel();
        this.address = user.getAddress();

        this.fieldOfStudy = user.getFieldOfStudy();
        this.campus = user.getCampus();
        this. coordinator = user.getCoordinator();

        this.password = user.getPassword();

    }

    public long getId() {return id;}
    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return lastName;
    }
    public void setSurname(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {this.mail = mail;}

    public String getTel() {return tel;}
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {return address;}
    public void setAddress(String address) {
        this.address = address;
    }

    public String getFieldOfStudy() {return fieldOfStudy;}
    public void setFieldOfStudy(String fieldOfStudy) {this.fieldOfStudy = fieldOfStudy;}

    public String getCampus() {return campus;}
    public void setCampus(String campus) {this.campus = campus;}

    public int getCoordinator() {
        return coordinator;
    }
    public void setCoordinator(int coordinator) {this.coordinator = coordinator;}

    public String getPassword(){ return password; }
    public void setPassword(String password){this.password = password;}

    public Roles getRole(){ return role;}
    public void setRole(Roles role){ this.role = role;}
}
