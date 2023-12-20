package Principal;

import Logica.Autobus;
import Logica.Reservacion;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    Ventana(){

        this.setLayout(new BorderLayout()); //Establece diseño en la distribución de paneles en la ventana.

        Autobus autobus = new Autobus(0,0 ,0,0,0,0,0); //Objeto que representa un autobús
        Reservacion reservacion = new Reservacion(autobus, "", "", "", "", 0,0 , 0); //Objeto que representa una reservación
        PanelAsientos asiento = new PanelAsientos(reservacion, 10, 4); //Panel que simula asientos
        PanelReservacion menuAsientos = PanelReservacion.getInstance(asiento); //Panel que agrega asientos e inserta otras características
        Rutas ruta = new Rutas(); //Objeto ListaViajes paneles de rutas de buses dentro de GUI
        JScrollPane scrollPanel = new JScrollPane(ruta, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); //Ordena los paneles de las rutas disponibles y facilita la elección dentro de GUI.
        PanelInformacion info = PanelInformacion.getInstance(); //Objeto de clase PanelInformación el cual mostrara datos del autobús, valores, entre otros.


        this.add(scrollPanel, BorderLayout.NORTH); //Ubica en la posición norte del BorderLayout a las rutas
        this.add(menuAsientos, BorderLayout.CENTER); //Ubica a menuAsientos en el centro de la pantalla
        this.add(info, BorderLayout.EAST); //Ubica a panel PanelInformación en la posición este


        this.setTitle("Sistema Reservación de Asientos"); //Establece el título del programa
        this.setSize(1350,750); //Establece el tamaño de la ventana
        this.setVisible(true); //Le da visibilidad a la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Programa se cierra al cerrar la ventana
    }
}
