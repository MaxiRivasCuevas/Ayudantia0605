package com.EjercicioAyudantia.ISoft.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.EjercicioAyudantia.ISoft.service.TareaService;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Endpoints {

    private TareaService TareaService;

    @PostMapping("/tasks")
    public String CrearTareaController(@RequestBody String titulo, @RequestBody String prioridad,
            @RequestBody String fechaLimite) {
        return ResponseEntity.ok(TareaService.CrearTarea(titulo, prioridad, fechaLimite));
    }

    @PatchMapping("/tasks/{id}/complete")
    public String CompletarTareaController(@PathV) {
        return ResponseEntity.ok(TareaService.CompletarTarea(id));
    }

}
