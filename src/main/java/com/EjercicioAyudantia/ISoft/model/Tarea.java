package com.EjercicioAyudantia.ISoft.model;

import lombok.Data;

@Data 
public class Tarea {
    private int id;
    private String titulo; 
    private String prioridad; 
    private String fechaLimite; 
    private boolean completada;

    public Tarea(){
        this.id ++;
    }
}
