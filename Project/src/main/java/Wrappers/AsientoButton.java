package Wrappers;

import Logica.Asiento;
import Logica.AsientoOcupadoException;
import Principal.PanelInformacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**Clase que representa a un asiento al interior del autobús**/

public class AsientoButton extends JButton {

    /** Atributos **/

    Asiento asiento; //Contiene referencia de objeto de clase Asiento

    /**
     * Método constructor
     * @param asiento Asiento vinculado.
     */

    public AsientoButton(Asiento asiento){

        super(String.valueOf(asiento.getNumero())); //Establece el número del asiento
        this.asiento = asiento; //Establece la referencia del asiento.

        colorAsiento(); //Le da el color al asiento según su clase, si está ocupado o si está seleccionado.


        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(asiento.seleccion()==1){
                    asiento.cancelar();
                }
                else{
                    try {
                        asiento.elegir();
                    } catch (AsientoOcupadoException excep) {
                        excep.printStackTrace();
                        JOptionPane.showMessageDialog(null, "El asiento que ha seleccionado\nse encuentra ocupado.", "Información", JOptionPane.WARNING_MESSAGE);
                    }
                }
                colorAsiento(); //Actualiza los colores de los asientos según corresponda
                PanelInformacion.getInstance().actualInfo(); //Actualiza la información relacionada a la reservación
            }
        });

        this.setVisible(true);
    }

    /** Método encargado del cambio de colores según la condición que presente el asiento */

    void colorAsiento(){

        if(asiento.seleccion()==1){
            this.setBackground(Color.GREEN); //El color verde indica que el asiento está seleccionado
            return;
        }

        if(asiento.confirmacion()==1){
            this.setBackground(Color.RED); //El color rojo indica que el asiento está ocupado
            return;
        }

        if(asiento.getServicio()=="Estandar"){ //El color rosado indica que el asiento es de tipo Estándar

            this.setBackground(Color.pink);
        }

        if(asiento.getServicio()=="Semi-cama"){ //El color gris claro indica que el asiento es de tipo Semi-cama

            this.setBackground(Color.lightGray);
        }

        if(asiento.getServicio()=="Salon Cama"){ //El color naranjo indica que el asiento es de tipo Salón cama

            this.setBackground(Color.orange);
        }

    }
}
