package com.task.manager.dam1.repository.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {

    private Long id;
    private String titulo;
    private String descripcion;
    private Estado estado; // Pendiente, En Progreso, Completada, Cancelada
    private String fechaCreacion;
    private Categoria categoria; // Ejemplo: Trabajo, Personal, Familiar
    private String fechaVencimiento;
    private String observaciones;

    public boolean esFechaValida() {
        try {
            LocalDate creacion = LocalDate.parse(this.fechaCreacion);
            LocalDate limite = LocalDate.parse(this.fechaVencimiento);
            return !limite.isBefore(creacion);
        } catch (Exception e) {
            return false;
        }
    }
}
