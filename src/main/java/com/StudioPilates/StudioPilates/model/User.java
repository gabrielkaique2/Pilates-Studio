package com.StudioPilates.StudioPilates.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String userName;

    private String password;

    public User(){
    }

    public User(String name, String email, String phoneNumber, String userName, String password){
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.userName=userName;
        this.password=password;
    }
}
