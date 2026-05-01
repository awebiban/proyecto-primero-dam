package com.task.manager.dam1.repository.entities;

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

}
