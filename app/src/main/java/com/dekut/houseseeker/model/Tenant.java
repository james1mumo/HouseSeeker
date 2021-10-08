package com.dekut.houseseeker.model;

public class Tenant {
    String tid, firstname, secondname, email, phonenumber;

    public Tenant(){

    }
    public Tenant(String tid, String firstname, String secondname, String email, String phonenumber){
        this.tid = tid;
        this.firstname = firstname;
        this.secondname = secondname;
        this.email = email;
        this.phonenumber = phonenumber;
    }
}
