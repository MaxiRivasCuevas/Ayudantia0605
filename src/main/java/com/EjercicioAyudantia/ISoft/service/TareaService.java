package com.EjercicioAyudantia.ISoft.service;

import com.EjercicioAyudantia.ISoft.model.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TareaService {
    private List<Tarea>tareas;  

    public TareaService(){
        this.tareas = new ArrayList<Tarea>();
    }
 
    public List<Tarea> getTareas() {
        return tareas;
    }
}
