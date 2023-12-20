package Principal;

import javax.swing.*;
import java.awt.*;

/**Clase encargada de proporcionar un panel donde se ubicaran los asientos y permitirá al usuario realizar la reservación**/

public class PanelReservacion extends JPanel {

    /** Atributos **/

    private static PanelReservacion pRes;
    private JLabel info;
    private PanelAsientos asiento;

    /**
     * Método constructor
     * @param pAs Panel que contiene asientos que serán mostrados en pantalla
     */
    private PanelReservacion(PanelAsientos pAs){

        asiento = pAs;
        this.setBackground(new Color(0,150,180));
        this.setLayout(new BorderLayout());
        this.add(asiento, BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(300, 100));

        info = new JLabel("Para comenzar, seleccione una de las rutas que están en la parte superior de su ventana:");
        info.setFont(new Font("Calibri", Font.BOLD, 22));

        this.add(info,BorderLayout.NORTH);
        this.setBorder(BorderFactory.createEmptyBorder(20, 150,30,150));
        this.setVisible(true);

        PanelInformacion.getInstance();

    }

    /** Métodos **/

    /**
     * Método encargado de actualizar la información visual de los asientos
     * @param pAs    Panel de asientos actualizado
     * @param texto  Información en la zona superior del panel
     */
    public void actualizar(PanelAsientos pAs, String texto){ //Revisar

        this.remove(asiento);
        this.remove(info);

        info = new JLabel(texto);
        this.add(info, BorderLayout.NORTH);
        info.setFont(new Font("Calibri", Font.BOLD, 20));

        this.add(pAs, BorderLayout.CENTER);
        asiento = pAs;

        this.updateUI();
        this.setVisible(true);
    }

    public static PanelReservacion getInstance(PanelAsientos pAs){
        if(pRes == null){
            pRes = new PanelReservacion(pAs);
        }
        return pRes;
    }
}
