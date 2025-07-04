package com.StudioPilates.StudioPilates.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Entity
@Table(name = "Clinics")
public class Clinic {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL)
    private List<Instructor> instructorsList;

    @JsonIgnore
    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL)
    private List<Patient> patientsList;

    public Clinic(){
    }

    public Clinic(String name, String address, String phoneNumber){
        this.name = name;
        this. address = address;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
