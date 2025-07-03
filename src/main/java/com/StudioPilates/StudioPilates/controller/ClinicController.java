package com.StudioPilates.StudioPilates.controller;

import com.StudioPilates.StudioPilates.exception.ResourceNotFoundException;
import com.StudioPilates.StudioPilates.model.Clinic;
import com.StudioPilates.StudioPilates.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinics")
public class ClinicController {

    @Autowired
    private ClinicRepository clinicRepository;

    //Create
    @PostMapping
    public Clinic createClinic(@RequestBody Clinic clinic){
        return clinicRepository.save(clinic);
    }

    //Read all
    @GetMapping
    public List<Clinic> getAllClinics(){
        return clinicRepository.findAll();
    }

    //Read by id
    @GetMapping(path = "/{id}")
    public ResponseEntity<Clinic> getClinicById(@PathVariable Long id){
        Clinic clinic = clinicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clinic not found with id " + id));

        return ResponseEntity.ok(clinic);
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Clinic> updateClinic(@PathVariable Long id, @RequestBody Clinic clinicDetails){
        Clinic clinic = clinicRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Clinic not exists with id " + id));

        clinic.setName(clinicDetails.getName());
        clinic.setAddress((clinicDetails.getAddress()));
        clinic.setPhoneNumber(clinicDetails.getPhoneNumber());

        Clinic updateClinic = clinicRepository.save(clinic);

        return ResponseEntity.ok(updateClinic);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Clinic> deleteClinic(@PathVariable Long id){
        Clinic clinic = clinicRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Clinic not exists with id " + id));
        clinicRepository.delete(clinic);

        return ResponseEntity.noContent().build();
    }
}
