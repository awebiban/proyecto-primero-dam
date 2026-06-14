package test.java.com.task.manager.dam1;

import org.junit.jupiter.api.Test;

import com.task.manager.dam1.repository.entities.Tarea;

public class TareaTest {

    @Test
    public void __testFechaLimiteAnteriorACreacion__DebeFallar__() {

        Tarea tarea = new Tarea();
        tarea.setFechaCreacion("2026-05-10");
        tarea.setFechaVencimiento("2026-05-01");

        boolean esValida = tarea.esFechaValida();

        assertFalse(esValida, "La tarea no debería ser válida si la fecha límite es anterior a la de creación");
    }

    @Test
    public void __testFechasCorrectas__DebePasar__() {
        Tarea tarea = new Tarea();
        tarea.setFechaCreacion("2026-05-01");
        tarea.setFechaVencimiento("2026-05-10");

        assertTrue(tarea.esFechaValida(), "La tarea debería ser válida con fechas cronológicas");
    }
}
