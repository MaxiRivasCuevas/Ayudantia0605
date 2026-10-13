package com.EjercicioAyudantia;

import lombok.Data;

@Data
public class TareaRequest {
    private String titulo;
    private String prioridad;
    private String fechaLimite;

    public TareaRequest(String titulo, String prioridad, String fechaLimite) {
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.fechaLimite = fechaLimite;
    }

}
