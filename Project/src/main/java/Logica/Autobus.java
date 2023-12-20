package Logica;

import java.util.ArrayList;

/**Clase Autobús: representa al autobús vinculado a la reservación**/
public class Autobus {

    /** Atributos **/

    private int numAsientosP1; //Cantidad de asientos en el piso 1
    private int numAsientosP2; //Cantidad de asientos en el piso 2
    private int numAsientosTotal; //Cantidad total de asientos
    private int numFilas; //Número de filas de asientos
    private int numColumnas; //Número de columnas de asientos
    private ArrayList<Asiento> asientos; //Lista de asientos de autobús


    /**
     * Método constructor clase Autobus
     * @param numAsientosP1 Cantidad de asientos en el piso 1
     * @param numAsientosP2 Cantidad de asientos en el piso 2
     * @param numEstandar Cantidad de asientos clase Estándar
     * @param numSemiCama Cantidad de asientos clase Semi-cama
     * @param numSalonCama Cantidad de asientos clase Salón cama
     * @param numFilas Número de filas de asientos
     * @param numColumnas Número de columnas de asientos
     */

    public Autobus(int numAsientosP1, int numAsientosP2, int numEstandar, int numSemiCama, int numSalonCama, int numFilas, int numColumnas) {

        this.numAsientosP1 = numAsientosP1;
        this.numAsientosP2 = numAsientosP2;
        this.numAsientosTotal = numAsientosP1 + numAsientosP2;
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;

        asientos = new ArrayList<Asiento>();

        for(int i = 1; i < numSalonCama+1; i++){
            asientos.add(new Asiento(i, "Salon Cama"));

        }
        for(int i = numSalonCama+1; i < numSalonCama+numSemiCama+1; i++){
            asientos.add(new Asiento(i, "Semi-cama"));

        }
        for(int i = numSemiCama+numSalonCama+1; i < numAsientosTotal+1; i++){
            asientos.add(new Asiento(i, "Estandar"));

        }
    }

    /** Métodos **/

    public Asiento getAsiento(int num) { return asientos.get(num);}
    public int getNumAsientosP1() { return numAsientosP1;}
    public int getNumAsientosP2() { return numAsientosP2;}
    public int getNumAsientosTotal() { return numAsientosTotal;}
    public int getFilas() { return numFilas;}
    public int getColumnas() { return numColumnas;}


}
