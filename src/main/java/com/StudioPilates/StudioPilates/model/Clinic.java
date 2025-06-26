package com.StudioPilates.StudioPilates.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

@Entity
@Table(name = "Clinics")
public class Clinic {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    public Clinic(){
    }

    public Clinic(String name, String address){
        this.name = name;
        this. address = address;
    }

}
