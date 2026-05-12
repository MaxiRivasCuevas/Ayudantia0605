package com.EjercicioAyudantia.ISoft.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.EjercicioAyudantia.ISoft.model.Tarea;
import com.EjercicioAyudantia.ISoft.service.TareaService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/tasks")
public class TareaController {
    private final TareaService tareaService;
    private Long idCounter = 1L;

    public TareaController (TareaService tareaService){
        this.tareaService = tareaService;
    }

    @GetMapping
    public List<Tarea>tareasPriorizadas(
        @RequestParam(required = false) String prioridad,
        @RequestParam(required = false) String titulo,
        @RequestParam(required = false) String fechaLimite){

        List<Tarea> resultados = tareaService.realizarBusqueda(prioridad, titulo, fechaLimite);
        return resultados;
    }
    
    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea nuevaTarea){

        nuevaTarea.setId(idCounter++);
        nuevaTarea.setCompletada(false);
        tareaService.getTareas().add(nuevaTarea);
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Tarea> editarEstado(@PathVariable Long id){
        Tarea tarea = tareaService.getTareas().stream()
        .filter(t -> t.getId().equals(id)).findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Tarea no encontrada"));

        tarea.setCompletada(true);

        return ResponseEntity.ok(tarea);
    }
    
}
