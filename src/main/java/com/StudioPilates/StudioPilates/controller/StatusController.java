package com.StudioPilates.StudioPilates.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class StatusController {
    @GetMapping("/")
    public Map<String, Object> getStatus(){
        return Map.of(
                "status", "OK - Serviço Rodando",
                "servicos_disponiveis", "Usuarios, Pacientes, Anamneses, Estudos",
                "timestamp", LocalDateTime.now()
        );
    }
}
