package com.StudioPilates.StudioPilates.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Patients")
public class Patient extends User{

    @Column(name = "patientStatus")
    private boolean patientStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "patientAddress")
    private String address;

    @Column(name = "patientProffesion")
    private String proffesion;

    @Column(name = "patientNeighborhood")
    private String neighborhood;

    @Temporal(TemporalType.DATE)
    @Column(name="bornDate")
    private Date bornDate;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String phoneNumber, Clinic clinic, boolean patientStatus, Date startDate, String address, String proffesion, String neighborhood, Date bornDate) {
        super(firstName, lastName, phoneNumber, clinic);
        this.patientStatus = patientStatus;
        this.startDate = startDate;
        this.address = address;
        this.proffesion = proffesion;
        this.neighborhood = neighborhood;
        this.bornDate = bornDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(boolean patientStatus) {
        this.patientStatus = patientStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProffesion() {
        return proffesion;
    }

    public void setProffesion(String proffesion) {
        this.proffesion = proffesion;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }
}
