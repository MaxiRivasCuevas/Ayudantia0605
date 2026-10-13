package com.EjercicioAyudantia.ISoft.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.EjercicioAyudantia.ISoft.model.Tarea;

@Service
public class TareaService {
    private List<Tarea> tareas;

    public TareaService() {
        this.tareas = new ArrayList<Tarea>();
    }

    public Tarea crearTarea(String titulo, String prioridad, String fechaLimite) {
        Tarea Tarea = new Tarea();
        Tarea.setTitulo(titulo);
        Tarea.setPrioridad(prioridad);
        Tarea.setFechaLimite(fechaLimite);
        Tarea.setCompletada(false);
        tareas.add(Tarea);
        return Tarea;
    }

    public List<Tarea> fitrarTareas(String prioridad, String titulo, String fechaLimite) {
        return tareas.stream()
                .filter(p -> p != null)
                .filter(p -> prioridad == null
                        || (p.getPrioridad() != null && p.getPrioridad().equalsIgnoreCase(prioridad)))
                .filter(p -> titulo == null || (p.getTitulo() != null && p.getTitulo().equalsIgnoreCase(titulo)))
                .filter(p -> fechaLimite == null
                        || (p.getFechaLimite() != null && p.getFechaLimite().equalsIgnoreCase(fechaLimite)))
                .toList();
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public boolean CompletarTarea(int id) {
        if (id <= 0 || id > tareas.size()) {
            return false;
        }
        Tarea tarea = tareas.get(id - 1);
        tarea.setCompletada(true);
        return true;
    }
}
