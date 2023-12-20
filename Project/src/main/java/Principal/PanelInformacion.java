package Principal;

import Logica.Reservacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/** Clase encargada de mostrar datos acerca del viaje y los valores qye tienen los asientos seleccionados para la posterior confirmación de la reservación. */

public class PanelInformacion extends JPanel {

    /** Atributos **/

    private static PanelInformacion panelinf;
    public Reservacion reservacion;

    /** Método constructor **/

    private PanelInformacion(){

        this.setLayout(new GridLayout(0,1));
        this.setBackground(new Color(0,70,60));
        this.setBorder(BorderFactory.createEmptyBorder(0,50,30,50));

        this.setVisible(true);
    }

    /** Métodos **/

    public static PanelInformacion getInstance(){
        if(panelinf == null){
            panelinf = new PanelInformacion();
        }
        return panelinf;
    }

    public void actRes(Reservacion reservacion){
            this.reservacion = reservacion;
            actualInfo();
    }

    /**
     * Método encargado de actualizar la información vinculada a la reservación que será mostrada en pantalla
     */

    public void actualInfo(){

        this.removeAll();
        this.updateUI();

        JLabel est = new JLabel("Subtotal Estandar ($"+String.valueOf(reservacion.getPrecioEst())+"):     $"+String.valueOf(reservacion.cantAsientos(reservacion.getAutobus(), "Estandar")*reservacion.getPrecioEst()));
        JLabel semic = new JLabel("Subtotal Semi-cama ($"+String.valueOf(reservacion.getPrecioSemiC())+"):     $"+String.valueOf(reservacion.cantAsientos(reservacion.getAutobus(), "Semi-cama")*reservacion.getPrecioSemiC()));
        JLabel sc = new JLabel("Subtotal Salón Cama ($"+String.valueOf(reservacion.getPrecioSC())+") :     $"+String.valueOf(reservacion.cantAsientos(reservacion.getAutobus(), "Salon Cama")*reservacion.getPrecioSC()));
        JLabel total = new JLabel("Precio Total :     $"+String.valueOf(reservacion.cantAsientos(reservacion.getAutobus(), "Salon Cama")*reservacion.getPrecioSC() + reservacion.cantAsientos(reservacion.getAutobus(), "Semi-cama")*reservacion.getPrecioSemiC() + reservacion.cantAsientos(reservacion.getAutobus(), "Estandar")*reservacion.getPrecioEst()));

        est.setFont(new Font("Arial",Font.ITALIC, 20));
        est.setForeground(Color.pink);
        semic.setFont(new Font("Arial",Font.ITALIC, 20));
        semic.setForeground(Color.lightGray);
        sc.setFont(new Font("Arial",Font.ITALIC, 20));
        sc.setForeground(Color.orange);
        total.setFont(new Font("Arial",Font.ITALIC, 20));
        total.setForeground(Color.white);

        JButton confirmar = new JButton("Confirmar Asientos");
        confirmar.setBackground(new Color(10,200,0));
        confirmar.setFont(new Font("Arial", Font.ITALIC,20));

        if(reservacion.getAutobus().getNumAsientosP2()==0) {

            JLabel bus = new JLabel("Bus: 1 Piso");
            bus.setFont(new Font("Arial", Font.ITALIC, 15));
            bus.setForeground(Color.white);
            this.add(bus);
        }

        else{

            JLabel bus = new JLabel("Bus: 2 Pisos");
            bus.setFont(new Font("Arial", Font.ITALIC, 15));
            bus.setForeground(Color.white);
            this.add(bus);

        }



        JLabel cap = new JLabel("Capacidad: " + reservacion.getAutobus().getNumAsientosTotal() + " pasajeros");
        cap.setFont(new Font("Arial",Font.ITALIC,15));
        cap.setForeground(Color.white);

        JLabel or = new JLabel("Origen: " + reservacion.getOrigen());
        or.setFont(new Font("Arial",Font.ITALIC,15));
        or.setForeground(Color.white);

        JLabel des = new JLabel("Destino: " + reservacion.getDestino());
        des.setFont(new Font("Arial",Font.ITALIC,15));
        des.setForeground(Color.white);

        JLabel hsal = new JLabel("Hora Salida: " + reservacion.getHoraSalida() + " hrs" );
        hsal.setFont(new Font("Arial",Font.ITALIC,15));
        hsal.setForeground(Color.white);

        JLabel hlle = new JLabel("Hora Llegada: " + reservacion.getHoraLlegada() + " hrs" );
        hlle.setFont(new Font("Arial",Font.ITALIC,15));
        hlle.setForeground(Color.white);


        this.add(cap);
        this.add(or);
        this.add(des);
        this.add(hsal);
        this.add(hlle);
        this.add(est);
        this.add(semic);
        this.add(sc);
        this.add(total);
        this.add(confirmar);

        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                reservacion.confirmarRes(reservacion.getAutobus());

                UIManager UI=new UIManager();
                UI.put("OptionPane.messageFont", new Font("Display", Font.ITALIC, 15));
                UI.put("OptionPane.messageForeground", Color.decode("#008E07"));
                JOptionPane.showMessageDialog(null, "El sistema ha confirmado la reservación de asientos seleccionados. \n\nImportante: En caso de confirmar reservación sin haber seleccionado ningún asiento, \nel sistema continuará su funcionamiento para una futura reservación.", "Información", JOptionPane.INFORMATION_MESSAGE);

                actualInfo(); //Actualiza resumen compra haciendo que los valores estén en 0.
                PanelAsientos as = new PanelAsientos(reservacion, reservacion.getAutobus().getFilas(), reservacion.getAutobus().getColumnas());
                PanelReservacion.getInstance(as).actualizar(as, String.valueOf(reservacion.getOrigen()+ "-"+ reservacion.getDestino()+"   ("+reservacion.getHoraSalida()+"-"+reservacion.getHoraLlegada()+")"));

            }
        });

        this.updateUI();
        this.setVisible(true);
    }

}
