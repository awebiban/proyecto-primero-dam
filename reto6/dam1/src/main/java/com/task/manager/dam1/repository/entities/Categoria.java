package com.task.manager.dam1.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    private Long id;
    private Nombre nombre;
    private String descripcion;

    public enum Nombre {
        TRABAJO, ESTUDIOS, HOGAR, PERSONAL
    }

}
