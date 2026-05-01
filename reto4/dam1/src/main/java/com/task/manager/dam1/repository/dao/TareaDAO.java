package com.task.manager.dam1.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.task.manager.dam1.config.ConexionBD;
import com.task.manager.dam1.repository.entities.Categoria;
import com.task.manager.dam1.repository.entities.Estado;
import com.task.manager.dam1.repository.entities.Tarea;

public class TareaDAO {
    public void mostrarTareas(Long idUsuario) {
        String sql = "SELECT * FROM tareas inner join estados on estados.id_estado = tareas.id_estado where id_usuario = ?";

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

    public Categoria[] obtenerCategorias() {
        String sql = "SELECT * FROM Categorias";
        Categoria[] categorias = new Categoria[10]; // Tamaño fijo para ejemplo

        try (Connection conn = ConexionBD.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            int index = 0;
            while (rs.next() && index < categorias.length) {
                categorias[index++] = new Categoria(
                        rs.getLong("id_categoria"),
                        Categoria.Nombre.valueOf(rs.getString("nombre").toUpperCase()),
                        rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorias;
    }
}
