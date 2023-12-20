package Wrappers;

import Logica.Reservacion;
import Principal.PanelAsientos;
import Principal.PanelInformacion;
import Principal.PanelReservacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**Clase que representa una reservación**/

public class ReservacionW extends JPanel {

    /** Atributos **/
    Reservacion reservacion; //Contiene referencia de reservación
    JButton ruta; //Contiene botón vinculado a una ruta

    /**
     * Método constructor
     * @param reservacion reservación vinculada
     */

    public ReservacionW(Reservacion reservacion){

        this.reservacion = reservacion;
        ruta = new JButton(String.valueOf( reservacion.getOrigen()+ "-"+ reservacion.getDestino()+"\n" +"("+reservacion.getHoraSalida()+"-"+reservacion.getHoraLlegada()+")"));
        ruta.setText(reservacion.getOrigen()+ "-"+ reservacion.getDestino()+"  "+"("+reservacion.getHoraSalida()+"-"+reservacion.getHoraLlegada()+")");
        this.add(ruta);

        this.setPreferredSize(new Dimension(280, 100)); //Tamaño panel
        ruta.setPreferredSize(new Dimension(280, 100)); //Tamaño botón
        ruta.setFont(new Font("Calibri",Font.LAYOUT_NO_START_CONTEXT,16));
        ruta.setForeground(Color.black);
        ruta.setBackground(Color.lightGray);

        ruta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelAsientos pAs = new PanelAsientos(reservacion, reservacion.getAutobus().getFilas(), reservacion.getAutobus().getColumnas());
                PanelReservacion lista = PanelReservacion.getInstance(pAs); //Revisar
                lista.actualizar(pAs , reservacion.getOrigen()+ "-"+ reservacion.getDestino()+"   ("+reservacion.getHoraSalida()+"-"+reservacion.getHoraLlegada()+")");
                PanelInformacion.getInstance().actRes(reservacion);
            }
        });

        this.setVisible(true);
    }
}
