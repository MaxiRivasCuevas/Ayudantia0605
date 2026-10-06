package com.EjercicioAyudantia.ISoft.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.EjercicioAyudantia.ISoft.model.Tarea;

public class TareaService {
    private List<Tarea> tareas;

    public TareaService(){
        this.tareas = new ArrayList<Tarea>();
    }

    public List<Tarea> fitrarTareas(String prioridad, String titulo, String fechaLimite){
        return tareas.stream()
        .filter(p -> p==null || p.getPrioridad().equalsIgnoreCase(prioridad))
        .filter(p -> p == null || p.getTitulo().equalsIgnoreCase(fechaLimite))
        .filter(p -> p == null || p.getFechaLimite().equalsIgnoreCase(fechaLimite))
        .collect(Collectors.toList());
    }

    public List<Tarea> getTareas() {
        return tareas;
    }
}
