package com.EjercicioAyudantia.ISoft.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EjercicioAyudantia.TareaRequest;
import com.EjercicioAyudantia.ISoft.model.Tarea;
import com.EjercicioAyudantia.ISoft.service.TareaService;

@Controller
@RequestMapping("/tasks")
public class Endpoint {
    private TareaService tareaService;
    private long idCounter = 1L;

    public Endpoint(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @PostMapping
    public ResponseEntity<Tarea> CrearTareaController(@RequestBody TareaRequest body) {
        return ResponseEntity.ok(tareaService
                .crearTarea(body.getTitulo(), body.getPrioridad(), body.getFechaLimite()));
    }

    @GetMapping
    public ResponseEntity<List<Tarea>> tareasPriorizadas(
            @RequestParam(required = false) String prioridad,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String fechaLimite) {
        List<Tarea> resultados = tareaService.fitrarTareas(prioridad, titulo, fechaLimite);
        return ResponseEntity.ok(resultados);
    }

    @PatchMapping("/tasks/{id}/complete")
    public ResponseEntity<Optional<String>> CompleteTask(@PathVariable int id) {
        if (tareaService.CompletarTarea(id)) {
            return ResponseEntity.ok(Optional.of("True"));
        }
        return ResponseEntity.notFound().build();
    }

}
