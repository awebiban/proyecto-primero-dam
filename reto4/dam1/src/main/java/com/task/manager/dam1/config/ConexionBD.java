package com.task.manager.dam1.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class ConexionBD {

    private static Properties props = new Properties();

    static {
        try {
            // Cargamos el archivo manualmente
            props.load(ConexionBD.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            System.err.println("¡Error! No se encontró el archivo application.properties");
        }
    }

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(
                    props.getProperty("db.url"),
                    props.getProperty("db.user"),
                    props.getProperty("db.password"));
        } catch (SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
            return null;
        }
    }
}
