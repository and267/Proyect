package Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservacionTest {
    private Reservacion reservacion;

    @BeforeEach
    void setUp(){

        Autobus autobus = new Autobus(12,12 ,8,8,8,3,4); //Objeto que representa un autobús

        reservacion = new Reservacion(autobus, "Concepción", "Santiago", "11:00", "17:00", 8000,12000 , 18000); //Objeto que representa una reservación
    }

    @Test
    @DisplayName("Test de disponibilidad asientos")
    public void testElegir() throws AsientoOcupadoException {

        reservacion.getAutobus().getAsiento(1).elegir();
        reservacion.getAutobus().getAsiento(2).elegir();
        reservacion.getAutobus().getAsiento(3).elegir();
        reservacion.getAutobus().getAsiento(4).elegir();

        reservacion.getAutobus().getAsiento(5).elegir();
        reservacion.getAutobus().getAsiento(5).cancelar();
        reservacion.getAutobus().getAsiento(7).elegir();
        reservacion.getAutobus().getAsiento(7).cancelar();


        assertEquals(1, reservacion.getAutobus().getAsiento(1).seleccion());
        assertNotEquals(1, reservacion.getAutobus().getAsiento(5).seleccion());
        assertEquals(1, reservacion.getAutobus().getAsiento(4).seleccion());
        assertNotEquals(1, reservacion.getAutobus().getAsiento(7).seleccion());

    }

    @Test
    @DisplayName("Test confirmación de asientos")
    public void testConfirmar() throws AsientoOcupadoException {

        reservacion.getAutobus().getAsiento(10).elegir();
        reservacion.getAutobus().getAsiento(10).confirmar();
        reservacion.getAutobus().getAsiento(11).elegir();
        reservacion.getAutobus().getAsiento(11).confirmar();
        reservacion.getAutobus().getAsiento(12).elegir();
        reservacion.getAutobus().getAsiento(12).confirmar();
        reservacion.getAutobus().getAsiento(13).elegir();
        reservacion.getAutobus().getAsiento(13).confirmar();


        assertEquals(1, reservacion.getAutobus().getAsiento(10).confirmacion());
        assertEquals(1, reservacion.getAutobus().getAsiento(11).confirmacion());
        assertEquals(1, reservacion.getAutobus().getAsiento(12).confirmacion());
        assertEquals(1, reservacion.getAutobus().getAsiento(13).confirmacion());
    }
}