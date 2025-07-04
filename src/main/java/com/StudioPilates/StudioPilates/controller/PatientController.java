package com.StudioPilates.StudioPilates.controller;

import com.StudioPilates.StudioPilates.exception.ResourceNotFoundException;
import com.StudioPilates.StudioPilates.model.Patient;
import com.StudioPilates.StudioPilates.repository.PatientRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    //Create
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }

    //Read all
    @GetMapping
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    //Read by id
    @GetMapping(path = "/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Patient not found with id " + id));

        return ResponseEntity.ok(patient);
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(Long id, @RequestBody Patient patientDetails){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Patient not found with id " + id));

        patient.setFirstName(patientDetails.getFirstName());
        patient.setLastName(patientDetails.getLastName());
        patient.setPatientStatus(patientDetails.isPatientStatus());
        patient.setAddress(patientDetails.getAddress());
        patient.setNeighborhood(patientDetails.getNeighborhood());
        patient.setProffesion(patientDetails.getProffesion());
        patient.setBornDate(patientDetails.getBornDate());
        patient.setStartDate(patientDetails.getStartDate());
        patient.setClinic(patientDetails.getClinic());

        Patient updatePatient = patientRepository.save(patient);

        return ResponseEntity.ok(updatePatient);
    }

    //Delete
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable Long id){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Patient not found with id " + id));

        patientRepository.delete(patient);
        return ResponseEntity.noContent().build();
    }

}
