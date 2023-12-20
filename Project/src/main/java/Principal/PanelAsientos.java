package Principal;

import Logica.Reservacion;
import Wrappers.AsientoButton;


import javax.swing.*;
import java.awt.*;

/** Clase encargada de construir la estructura en la cual estarán dispuestos los asientos al interior del autobús*/

public class PanelAsientos extends JPanel {

    /** Atributos **/

    private int capacidad;

    /**
     * Método constructor que permite la creación y distribución de los asientos en el autobús
     * @param reservacion Corresponde a la reservación de una determinada ruta
     * @param filas Número de filas de asientos
     * @param columnas Número de columnas de asientos
     */
    public PanelAsientos(Reservacion reservacion, int filas, int columnas){


        capacidad = reservacion.getAutobus().getNumAsientosTotal();
        this.setBackground(new Color(0,150,180));


        if(reservacion.getAutobus().getNumAsientosP2()==0) {

            this.setLayout(new GridLayout(filas, columnas,0,0));
            for (int i = 0; i < capacidad; i++) {

                this.add(new AsientoButton(reservacion.getAutobus().getAsiento(i)));
                if (i % 2 == 1) {
                    JPanel fondo = new JPanel();
                    fondo.setBackground(new Color(0, 150, 180));
                    this.add(fondo);
                }
            }
        }

        else{

            this.setLayout(new GridLayout(filas, columnas,0,0));
            int n = reservacion.getAutobus().getNumAsientosP1();
            int cant = reservacion.getAutobus().getNumAsientosP1();

            for (int i = 0; i < cant; i++) {

                this.add(new AsientoButton(reservacion.getAutobus().getAsiento(i)));

                if(i==1){

                    JLabel piso = new JLabel("PISO 1");
                    JPanel panel = new JPanel();
                    panel.setBackground(new Color(0, 150, 180));
                    panel.add(piso);
                    this.add(panel);
                }

                else if (i % 2 == 1) {
                    JPanel fondo = new JPanel();
                    fondo.setBackground(new Color(0, 150, 180));
                    this.add(fondo);
                }

                if((i+1)%4==0){

                    this.add(new AsientoButton(reservacion.getAutobus().getAsiento(n)));
                    this.add(new AsientoButton(reservacion.getAutobus().getAsiento(n+1)));

                    if(n==reservacion.getAutobus().getNumAsientosP1()){

                        JLabel piso = new JLabel("PISO 2");
                        JPanel panel = new JPanel();
                        panel.setBackground(new Color(0, 150, 180));
                        panel.add(piso);
                        this.add(panel);
                    }

                    else{

                        JPanel fondo = new JPanel();
                        fondo.setBackground(new Color(0, 150, 180));
                        this.add(fondo);
                    }

                    this.add(new AsientoButton(reservacion.getAutobus().getAsiento(n+2)));
                    this.add(new AsientoButton(reservacion.getAutobus().getAsiento(n+3)));
                    n=n+4;
                }
            }
        }
    }
}
