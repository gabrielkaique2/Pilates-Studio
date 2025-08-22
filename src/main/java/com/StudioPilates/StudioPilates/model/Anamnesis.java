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

    @Temporal(TemporalType.DATE)
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

    public Anamnesis(){

    }

    public Anamnesis(long id, String medicineUsage, String pilatesGoal, Date avaliationDate, String clinicalDiagnosis, String mainComplaint, boolean hypertensionDisease, boolean cardioDisease, boolean diabetesDisease, boolean metabolicDisease, boolean asthmaDisease, boolean bronchitisDisease, boolean smokingDisease, boolean alcoholismDisease, long pressureBlood, long heartRate, Patient patientId, Instructor intructorId) {
        this.id = id;
        this.medicineUsage = medicineUsage;
        this.pilatesGoal = pilatesGoal;
        this.avaliationDate = avaliationDate;
        this.clinicalDiagnosis = clinicalDiagnosis;
        this.mainComplaint = mainComplaint;
        this.hypertensionDisease = hypertensionDisease;
        this.cardioDisease = cardioDisease;
        this.diabetesDisease = diabetesDisease;
        this.metabolicDisease = metabolicDisease;
        this.asthmaDisease = asthmaDisease;
        this.bronchitisDisease = bronchitisDisease;
        this.smokingDisease = smokingDisease;
        this.alcoholismDisease = alcoholismDisease;
        this.pressureBlood = pressureBlood;
        this.heartRate = heartRate;
        this.patientId = patientId;
        this.intructorId = intructorId;
    }

    //Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMedicineUsage() {
        return medicineUsage;
    }

    public void setMedicineUsage(String medicineUsage) {
        this.medicineUsage = medicineUsage;
    }

    public String getPilatesGoal() {
        return pilatesGoal;
    }

    public void setPilatesGoal(String pilatesGoal) {
        this.pilatesGoal = pilatesGoal;
    }

    public Date getAvaliationDate() {
        return avaliationDate;
    }

    public void setAvaliationDate(Date avaliationDate) {
        this.avaliationDate = avaliationDate;
    }

    public String getMainComplaint() {
        return mainComplaint;
    }

    public void setMainComplaint(String mainComplaint) {
        this.mainComplaint = mainComplaint;
    }

    public String getClinicalDiagnosis() {
        return clinicalDiagnosis;
    }

    public void setClinicalDiagnosis(String clinicalDiagnosis) {
        this.clinicalDiagnosis = clinicalDiagnosis;
    }

    public boolean isHypertensionDisease() {
        return hypertensionDisease;
    }

    public void setHypertensionDisease(boolean hypertensionDisease) {
        this.hypertensionDisease = hypertensionDisease;
    }

    public boolean isCardioDisease() {
        return cardioDisease;
    }

    public void setCardioDisease(boolean cardioDisease) {
        this.cardioDisease = cardioDisease;
    }

    public boolean isDiabetesDisease() {
        return diabetesDisease;
    }

    public void setDiabetesDisease(boolean diabetesDisease) {
        this.diabetesDisease = diabetesDisease;
    }

    public boolean isMetabolicDisease() {
        return metabolicDisease;
    }

    public void setMetabolicDisease(boolean metabolicDisease) {
        this.metabolicDisease = metabolicDisease;
    }

    public boolean isAsthmaDisease() {
        return asthmaDisease;
    }

    public void setAsthmaDisease(boolean asthmaDisease) {
        this.asthmaDisease = asthmaDisease;
    }

    public boolean isBronchitisDisease() {
        return bronchitisDisease;
    }

    public void setBronchitisDisease(boolean bronchitisDisease) {
        this.bronchitisDisease = bronchitisDisease;
    }

    public boolean isSmokingDisease() {
        return smokingDisease;
    }

    public void setSmokingDisease(boolean smokingDisease) {
        this.smokingDisease = smokingDisease;
    }

    public boolean isAlcoholismDisease() {
        return alcoholismDisease;
    }

    public void setAlcoholismDisease(boolean alcoholismDisease) {
        this.alcoholismDisease = alcoholismDisease;
    }

    public long getPressureBlood() {
        return pressureBlood;
    }

    public void setPressureBlood(long pressureBlood) {
        this.pressureBlood = pressureBlood;
    }

    public long getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(long heartRate) {
        this.heartRate = heartRate;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public Instructor getIntructorId() {
        return intructorId;
    }

    public void setIntructorId(Instructor intructorId) {
        this.intructorId = intructorId;
    }
}
