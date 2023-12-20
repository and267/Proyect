package Logica;

/**Clase Asiento: representa un asiento a reservar**/

public class Asiento {

    /** Atributos **/

    private int numero; //Número que identifica a asiento
    private String servicio; //Clase de asiento
    private int elegir; //Número que indica la selección de un asiento
    private int estado; //Número que indica la disponibilidad de un asiento

    /**
     * Método constructor clase Asiento
     * @param numero  Número asignado al asiento
     * @param servicio Tipo de asiento
     */
    public Asiento(int numero, String servicio){

        this.numero = numero;
        this.servicio = servicio;
        elegir = 0;
        estado = 0;
    }

    /** Métodos **/

    public int getNumero(){ return numero;}
    public String getServicio() { return servicio;}

    /**
     * Método elegir, encargado de la elección del asiento
     * @throws AsientoOcupadoException (en caso de que el asiento esté ocupado)
     */

    public void elegir() throws AsientoOcupadoException {
        if(estado==0){
            elegir = 1;
        }
        else{
            throw new AsientoOcupadoException("El asiento seleccionado se encuentra ocupado");
        }
    }

    public void cancelar(){ elegir = 0;}

    public int seleccion(){ return elegir;}

    void confirmar(){
        this.estado = 1;
        this.elegir = 0;
    }

    public int confirmacion(){ return estado;}


}

