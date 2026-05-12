package com.EjercicioAyudantia.ISoft.service;

import com.EjercicioAyudantia.ISoft.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class TareaService {
    private List<Tarea>tareas;  

    public List<Tarea>realizarBusqueda(String prioridad, String titulo, String fecha){
        return tareas.stream()
        .filter(t-> prioridad == null || t.getPrioridad().equalsIgnoreCase(prioridad))
        .filter(t-> titulo == null || t.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
        .filter(t-> fecha == null || t.getFechaLimite().equals(fecha))
        .collect(Collectors.toList());
    }

    public TareaService(){
        this.tareas = new ArrayList<Tarea>();
    }
 
    public List<Tarea> getTareas() {
        return tareas;
    }
}
