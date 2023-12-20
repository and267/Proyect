package Principal;

import Logica.Autobus;
import Logica.Reservacion;
import Wrappers.ReservacionW;

import javax.swing.*;

public class Rutas extends JPanel {

    /**Método constructor que permite inicializar autobuses con sus respectivas rutas**/
    public Rutas(){

        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        /** Lista de autobuses disponibles **/
        Autobus a1 = new Autobus(52,0,52,0,0,13,4);
        Autobus a2 = new Autobus(28,28,0,28,28,7,8);
        Autobus a3 = new Autobus(52,0,32,20,0,13,4);
        Autobus a4 = new Autobus(48,0,0,0,48,12,4);
        Autobus a5 = new Autobus(32,32,32,16,16,8,8);
        Autobus a6 = new Autobus(48,0,0,32,16,12,4);
        Autobus a7 = new Autobus(40,0,20,20,0,10,4);
        Autobus a8 = new Autobus(28,28,0,28,28,7,8);
        Autobus a9 = new Autobus(20,20,32,12,20,5,8);
        Autobus a10 = new Autobus(48,0,48,0,0,12,4);


        /** Lista de rutas disponibles **/

        this.add(new ReservacionW(new Reservacion(a9, "Concepción", "Santiago","09:00","15:00", 10000, 15000, 20000)));
        this.add(new ReservacionW(new Reservacion(a6, "Concepción", "La Serena","10:00", "23:00", 0, 30000, 40000)));
        this.add(new ReservacionW(new Reservacion(a8, "Santiago", "Antofagasta","10:00","03:00", 0, 24000, 30000)));
        this.add(new ReservacionW(new Reservacion(a3, "Santiago", "Copiapó","11:00","22:00",  9000, 16000, 0)));
        this.add(new ReservacionW(new Reservacion(a4, "Santiago", "Valdivia","12:00","23:00", 0, 0, 32000)));
        this.add(new ReservacionW(new Reservacion(a2, "Valparaiso", "Concepción","14:00","20:30", 0, 13000, 20000)));
        this.add(new ReservacionW(new Reservacion(a1, "Rancagua", "Santiago","17:00","18:00", 2000, 0, 0)));
        this.add(new ReservacionW(new Reservacion(a7, "Rancagua", "Talca","17:00","19:30", 4000, 7000, 0)));
        this.add(new ReservacionW(new Reservacion(a10, "Antofagasta", "Iquique","17:00","23:00", 10000, 0, 0)));
        this.add(new ReservacionW(new Reservacion(a5, "Valdivia", "Santiago","18:00","03:00", 13000, 22000, 30000)));

        setVisible(true);

    }
}
