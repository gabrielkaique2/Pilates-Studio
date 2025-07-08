package com.StudioPilates.StudioPilates.controller;

import com.StudioPilates.StudioPilates.exception.ResourceNotFoundException;
import com.StudioPilates.StudioPilates.model.Anamnesis;
import com.StudioPilates.StudioPilates.repository.AnamnesisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anamnesis")
public class AnamnesisController {

    @Autowired
    private AnamnesisRepository anamnesisRepository;

    //Create
    @PostMapping
    public Anamnesis createAnamnesis(@RequestBody Anamnesis anamnesis){
        return anamnesisRepository.save(anamnesis);
    }

    //Read
    @GetMapping
    public List<Anamnesis> getAllAnamnesis(){
        return  anamnesisRepository.findAll();
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Anamnesis> updateAnamnesis(@PathVariable Long id, @RequestBody Anamnesis anamnesisDetail){
        Anamnesis anamnesis = anamnesisRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Anamnesis not found with id "+id));

        anamnesis.setAvaliationDate(anamnesisDetail.getAvaliationDate());
        anamnesis.setAlcoholismDisease(anamnesisDetail.isAlcoholismDisease());
        anamnesis.setAsthmaDisease(anamnesisDetail.isAsthmaDisease());
        anamnesis.setBronchitisDisease(anamnesisDetail.isBronchitisDisease());
        anamnesis.setCardioDisease(anamnesisDetail.isCardioDisease());
        anamnesis.setClinicalDiagnosis(anamnesisDetail.getClinicalDiagnosis());
        anamnesis.setPilatesGoal(anamnesisDetail.getPilatesGoal());
        anamnesis.setMedicineUsage(anamnesisDetail.getMedicineUsage());
        anamnesis.setMainComplaint(anamnesisDetail.getMainComplaint());
        anamnesis.setHypertensionDisease(anamnesisDetail.isHypertensionDisease());
        anamnesis.setDiabetesDisease(anamnesisDetail.isDiabetesDisease());
        anamnesis.setMetabolicDisease(anamnesisDetail.isMetabolicDisease());
        anamnesis.setSmokingDisease(anamnesisDetail.isSmokingDisease());
        anamnesis.setPressureBlood(anamnesisDetail.getPressureBlood());
        anamnesis.setHeartRate(anamnesisDetail.getHeartRate());
        anamnesis.setPatientId(anamnesisDetail.getPatientId());
        anamnesis.setIntructorId(anamnesisDetail.getIntructorId());

        Anamnesis updateAnamnesis = anamnesisRepository.save(anamnesis);

        return ResponseEntity.ok(updateAnamnesis);
    }
    //Delete

    @DeleteMapping("/{id}")
    public ResponseEntity<Anamnesis> deleteAnamnesis(@PathVariable Long id){
        Anamnesis anamnesis = anamnesisRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Anamnesis not exists with id " + id));
        anamnesisRepository.delete(anamnesis);
        return ResponseEntity.noContent().build();
    }
}
