package com.StudioPilates.StudioPilates.model;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Entity
public class Anamnesis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "medicineUsage")
    private String medicineUsage;

    @Column(name = "pilatesGoal")
    private String pilatesGoal;

    @Column(name = "AvaliationDate")
    private Date avaliationDate;

    @Column(name = "ClinicalDiagnosis")
    private String clinicalDiagnosis;

    @Column(name = "MainComplaint")
    private String mainComplaint;

    private boolean hypertensionDisease;

    private boolean cardioDisease;

    private boolean diabetesDisease;

    private boolean metabolicDisease;

    private boolean asthmaDisease;

    private boolean bronchitisDisease;

    private boolean smokingDisease;

    private boolean alcoholismDisease;

    private long pressureBlood;

    private long  heartRate;

    @OneToOne
    @JoinColumn(name = "Patient_id", nullable = true)
    private Patient patientId;

    @OneToOne
    @JoinColumn(name = "Instructor_id", nullable = true)
    private Instructor intructorId;

}
