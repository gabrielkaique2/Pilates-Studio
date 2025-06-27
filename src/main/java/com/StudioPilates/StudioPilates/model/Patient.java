package com.StudioPilates.StudioPilates.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Patients")
public class Patient extends User{

    @Column(name = "patientStatus")
    private boolean patoentStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = "startDate")
    private Date startDate;

}
