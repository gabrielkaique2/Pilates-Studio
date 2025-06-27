package com.StudioPilates.StudioPilates.repository;

import com.StudioPilates.StudioPilates.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
