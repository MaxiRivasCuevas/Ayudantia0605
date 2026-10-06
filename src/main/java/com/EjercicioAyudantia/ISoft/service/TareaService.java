package com.EjercicioAyudantia.ISoft.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.EjercicioAyudantia.ISoft.model.Tarea;

@Service
public class TareaService {
    private List<Tarea> tareas = new ArrayList<>();

    public Tarea CrearTarea(String titulo, String prioridad, String fechaLimite) {
        Tarea Tarea = new Tarea();
        Tarea.setTitulo(titulo);
        Tarea.setPrioridad(prioridad);
        Tarea.setFechaLimite(fechaLimite);
        Tarea.setCompletada(false);
        tareas.add(Tarea);
        return Tarea;
    }
}
