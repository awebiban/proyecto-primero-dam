package com.task.manager.dam1.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estado {
    private Long id;

    private Nombre nombre;

    private String descripcion;

    public enum Nombre {
        PENDIENTE, EN_PROGRESO, COMPLETADA, CANCELADA
    }

}
