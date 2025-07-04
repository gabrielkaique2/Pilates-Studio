package com.StudioPilates.StudioPilates.controller;

import com.StudioPilates.StudioPilates.exception.ResourceNotFoundException;
import com.StudioPilates.StudioPilates.model.Instructor;
import com.StudioPilates.StudioPilates.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;

    //Create
    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor){
        return instructorRepository.save(instructor);
    }

    //Read All
    @GetMapping
    public List<Instructor> getAllInstructor(){
        return instructorRepository.findAll();
    }

    //Read By id
    @GetMapping(path = "/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Long id){
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Instructor not found with id " + id));

        return ResponseEntity.ok(instructor);
    }

    //Update
    @PutMapping(path = "/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id, @RequestBody Instructor instructorDetails){
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Instructor not found with id " + id));

        instructor.setFirstName(instructorDetails.getFirstName());
        instructor.setLastName(instructorDetails.getLastName());
        instructor.setPassword(instructorDetails.getPassword());
        instructor.setPhoneNumber(instructorDetails.getPhoneNumber());
        instructor.setClinic(instructorDetails.getClinic());

        Instructor updateInstructor = instructorRepository.save(instructor);

        return ResponseEntity.ok(updateInstructor);
    }
    //Delete
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Instructor> deleteInstructor(@PathVariable Long id){
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Instructor not found with id " + id));

        instructorRepository.delete(instructor);
        return ResponseEntity.noContent().build();
    }

}
