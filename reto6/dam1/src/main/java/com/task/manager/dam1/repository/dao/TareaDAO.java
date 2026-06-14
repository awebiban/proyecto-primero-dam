package com.task.manager.dam1.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.task.manager.dam1.config.ConexionBD;
import com.task.manager.dam1.repository.entities.Categoria;
import com.task.manager.dam1.repository.entities.Estado;
import com.task.manager.dam1.repository.entities.Tarea;

/**
 * * @author Iván (1DAW)
 * 
 * @version 1.0
 */
public class TareaDAO {
    public void mostrarTareas(Long idUsuario) {
        String sql = "SELECT t.id_tarea, t.titulo, e.nombre FROM tareas t INNER JOIN estados e ON e.id_estado = t.id_estado WHERE t.id_usuario = ?";

        try (Connection conn = ConexionBD.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            if (conn == null)
                return;

            while (rs.next()) {
                System.out.println("Tarea: " + rs.getLong("id_tarea") + " - " + rs.getString("titulo") + " ---" + " ["
                        + rs.getString("nombre") + "]");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param idUsuario  El identificador único del usuario que crea la tarea.
     * @param nuevaTarea El objeto Tarea que contiene todos los datos a insertar
     *                   (título, descripción, fechas, estado y categoría).
     * @throws SQLException si la consulta SQL falla.
     */
    public void crearTarea(Long idUsuario, Tarea nuevaTarea) {
        String sql = "INSERT INTO Tareas (id_usuario, titulo, descripcion, fecha_creacion, fecha_limite, id_estado, id_categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, idUsuario);
            stmt.setString(2, nuevaTarea.getTitulo());
            stmt.setString(3, nuevaTarea.getDescripcion());
            stmt.setString(4, nuevaTarea.getFechaCreacion());
            stmt.setString(5, nuevaTarea.getFechaVencimiento());
            stmt.setLong(6, nuevaTarea.getEstado().getId());
            stmt.setLong(7, nuevaTarea.getCategoria().getId());

            stmt.executeUpdate();

            if (conn == null)
                return;

            System.out.println("Tarea '" + nuevaTarea.getTitulo() + "' creada con éxito.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param idUsuario   El identificador único del usuario que crea la tarea.
     * @param idTarea     El identificador único de la tarea que se va a actualizar.
     * @param nuevoEstado El objeto Estado que representa el nuevo estado de la
     *                    tarea.
     * @throws SQLException si la consulta SQL falla.
     */
    public void cambiarEstadoTarea(Long idUsuario, Long idTarea, Estado nuevoEstado) {
        String sql = "UPDATE Tareas SET id_estado = ? where id_usuario = ? and id_tarea = ?";

        try (Connection conn = ConexionBD.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, nuevoEstado.getId());
            stmt.setLong(2, idUsuario);
            stmt.setLong(3, idTarea);

            stmt.executeUpdate();

            if (conn == null)
                return;

            System.out.println("Estado de tarea actualizado a '" + nuevoEstado.getNombre() + "'.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene todas las categorías disponibles.
     * 
     * @return Una lista de objetos Categoria.
     * @throws SQLException si la consulta SQL falla.
     */
    public List<Categoria> obtenerCategorias() {
        String sql = "SELECT * FROM Categorias";
        List<Categoria> categorias = new ArrayList<>(); // Con un arrayList tenemos un mejor control de la memoria

        try (Connection conn = ConexionBD.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) { // Optimizacion: ResultSet en el bloque try

            while (rs.next()) {
                categorias.add(new Categoria(
                        rs.getLong("id_categoria"),
                        Categoria.Nombre.valueOf(rs.getString("nombre").toUpperCase()),
                        rs.getString("descripcion")));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener categorías: " + e.getMessage());
        }
        return categorias;
    }
}
