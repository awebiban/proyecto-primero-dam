package com.task.manager.dam1.web.controllers;

import java.util.Scanner;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;

import com.task.manager.dam1.repository.dao.TareaDAO;
import com.task.manager.dam1.repository.entities.Categoria;
import com.task.manager.dam1.repository.entities.Estado;
import com.task.manager.dam1.repository.entities.Tarea;

@Controller
public class MenuController {

    Long idUsuario = 1L; // Simulamos un usuario logueado con ID 1

    TareaDAO tareaDAO = new TareaDAO();
    Scanner scanner = new Scanner(System.in);

    Logger log = Logger.getLogger(MenuController.class.getName());

    public void mostrarMenu() {
        int op = 0;

        System.out.println("==================================");
        System.out.println("   BIENVENIDO A TASKMASTER V0.1   ");
        System.out.println("==================================");

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Ver mis tareas");
            System.out.println("2. Añadir nueva tarea");
            System.out.println("3. Cambiar estado de una tarea");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            try {
                op = Integer.parseInt(scanner.nextLine());

                switch (op) {
                    case 1: // Ver tareas
                        log.info("Conectando a BD... Mostrando tareas:");
                        tareaDAO.mostrarTareas(idUsuario);
                        break;
                    case 2: // Crear nueva tarea
                        log.info("Cargando agente de creación:");
                        Tarea nuevaTarea = new Tarea();

                        nuevaTarea = mostrarAgenteCreacionTarea(nuevaTarea, scanner);

                        tareaDAO.crearTarea(idUsuario, nuevaTarea);
                        break;
                    case 3: // Cambiar estado de tarea
                        Long idTarea = null;
                        Estado nuevoEstado = null;

                        tareaDAO.mostrarTareas(idUsuario);
                        System.out.print("Introduce el ID de la tarea: ");
                        idTarea = Long.parseLong(scanner.nextLine());

                        nuevoEstado = mostrarCambioEstado(nuevoEstado);
                        System.out.println(
                                "Actualizando estado de la tarea..." + idTarea + " a " + nuevoEstado.getNombre());

                        tareaDAO.cambiarEstadoTarea(idUsuario, idTarea, nuevoEstado);
                        break;
                    case 4: // Salir
                        log.info("Saliendo de TaskMaster. ¡Hasta pronto!");
                        break;
                    default:
                        log.severe("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (NumberFormatException e) {
                log.severe("Por favor, introduce un número.");
            } catch (Exception e) {
                log.severe("Error inesperado: " + e.getMessage());
            }
        } while (op != 4);
    }

    private Tarea mostrarAgenteCreacionTarea(Tarea t, Scanner s) {

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\n--- AGENTE DE CREACIÓN DE TAREA ---");
        System.out.println("Por favor, introduce los detalles de la nueva tarea.");

        System.out.print("Título: ");
        t.setTitulo(s.nextLine());

        System.out.print("Descripción: ");
        t.setDescripcion(s.nextLine());

        t.setEstado(new Estado(1L, Estado.Nombre.PENDIENTE, "Tarea pendiente de realizar"));

        System.out.println("\nCategorías disponibles:");

        Categoria[] categorias = tareaDAO.obtenerCategorias();
        if (categorias == null || categorias.length == 0) {
            System.out.println("No hay categorías disponibles.");
            t.setCategoria(null);
        } else {
            int index = 0;
            for (int i = 0; i < categorias.length; i++) {
                if (categorias[i] == null) {
                    continue;
                }
                index++;
                System.out.println(index + ". " + categorias[i].getNombre());
            }

            if (index == 0) {
                System.out.println("No hay categorías disponibles.");
                t.setCategoria(null);
            } else {
                while (true) {
                    System.out.print("Selecciona una categoría (número): ");
                    try {
                        int seleccion = Integer.parseInt(s.nextLine());
                        if (seleccion > 0 && seleccion <= index) {
                            int contador = 0;
                            for (int i = 0; i < categorias.length; i++) {
                                if (categorias[i] == null) {
                                    continue;
                                }
                                if (++contador == seleccion) {
                                    t.setCategoria(categorias[i]);
                                    break;
                                }
                            }
                            break;
                        }
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                    } catch (NumberFormatException e) {
                        System.out.println("Introduce un número válido.");
                    }
                }
            }
        }

        System.out.print("Fecha de creación (YYYY-MM-DD): ");
        t.setFechaCreacion(s.nextLine());

        System.out.print("Fecha de vencimiento (YYYY-MM-DD): ");
        t.setFechaVencimiento(s.nextLine());

        System.out.print("Observaciones: ");
        t.setObservaciones(s.nextLine());

        return t;
    }

    public Estado mostrarCambioEstado(Estado nuevoEstado) {
        System.out.print("Introduce el nuevo estado (1: PENDIENTE, 2: EN_PROGRESO, 3: COMPLETADA): ");
        int estadoSeleccionado = Integer.parseInt(scanner.nextLine());
        switch (estadoSeleccionado) {
            case 1:
                nuevoEstado = new Estado(1L, Estado.Nombre.PENDIENTE, "Tarea pendiente de realizar");
                break;
            case 2:
                nuevoEstado = new Estado(2L, Estado.Nombre.EN_PROGRESO, "Tarea en progreso");
                break;
            case 3:
                nuevoEstado = new Estado(3L, Estado.Nombre.COMPLETADA, "Tarea completada");
                break;
            default:
                log.severe("Opción no válida.");
                return null;
        }
        return nuevoEstado;
    }
}
