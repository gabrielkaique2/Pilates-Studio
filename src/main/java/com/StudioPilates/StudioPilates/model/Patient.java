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

    public Patient() {
    }

    public Patient(String firstName, String lastName, String phoneNumber, Clinic clinic, boolean patientStatus, Date startDate, String address) {
        super(firstName, lastName, phoneNumber, clinic);
        this.patientStatus = patientStatus;
        this.startDate = startDate;
        this.address = address;
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
}
