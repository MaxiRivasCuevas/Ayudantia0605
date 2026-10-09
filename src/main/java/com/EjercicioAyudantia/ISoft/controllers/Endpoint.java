package com.EjercicioAyudantia.ISoft.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EjercicioAyudantia.ISoft.model.Tarea;
import com.EjercicioAyudantia.ISoft.service.TareaService;


@Controller 
@RequestMapping("/tasks")
public class Endpoint {
    private TareaService tareaService;
    private long idCounter = 1L;
    
    public Endpoint (TareaService tareaService){
        this.tareaService = tareaService;
    }

    @PostMapping
    public ResponseEntity<Tarea> CrearTareaController(@RequestBody String titulo, @RequestBody String prioridad,
            @RequestBody String fechaLimite) {
        return ResponseEntity.ok(tareaService.crearTarea(titulo, prioridad, fechaLimite));
    }
    
    @GetMapping
    public List<Tarea>tareasPriorizadas(
        @RequestParam(required = false) String prioridad,
        @RequestParam(required = false) String titulo,
        @RequestParam(required = false) String fechaLimite) {
            List<Tarea> resultados = tareaService.fitrarTareas(prioridad, titulo, fechaLimite);
        return resultados;
    }
    
}
