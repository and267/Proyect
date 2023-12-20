package Logica;

/**Clase Reservacion: representa la reservación de asientos realizada por un usuario**/

public class Reservacion{

    /** Atributos **/

    private Autobus autobus; //Autobús que recorrerá la ruta
    private String origen; //Ciudad donde inicia el viaje
    private String destino; //Ciudad donde termina el viaje
    private String horaSalida; //Hora de salida del autobús
    private String horaLlegada; //Hora de llegada del autobús
    private int precioEst; //Precio de asiento Estándar
    private int precioSemiC; //Precio de asiento Semi-cama
    private int precioSC; //Precio de asiento Salón cama
    private int precio; // Precio total de la reservación

    /**
     * Método constructor clase Reservacion
     * @param autobus        Autobús vinculado a la reservación
     * @param origen         Ciudad donde inicia el viaje
     * @param destino        Ciudad donde termina el viaje
     * @param horaSalida     Hora de salida de autobús
     * @param horaLlegada    Hora de llegada de autobús
     * @param precioEst      Precio de asiento estándar
     * @param precioSemiC    Precio de asiento Semi-cama
     * @param precioSC       Precio de asiento Salon Cama
     */
    public Reservacion(Autobus autobus, String origen, String destino, String horaSalida, String horaLlegada, int precioEst, int precioSemiC, int precioSC){

        this.autobus = autobus;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.precioEst = precioEst;
        this.precioSemiC = precioSemiC;
        this.precioSC = precioSC;
    }

    /** Métodos **/

    /**
     * Método que tiene como función la confirmación de asientos seleccionados
     * @param autobus Autobús vinculado a la ruta
     * @return El precio total de los asientos seleccionados
     */

    public void confirmarRes(Autobus autobus) {

        int numAsientos = autobus.getNumAsientosTotal();
        for(int i=0; i<numAsientos; i++){
            if(autobus.getAsiento(i).seleccion()==1){
                autobus.getAsiento(i).confirmar();
            }
        }

        precio = 0;

    }

    public Autobus getAutobus() {return autobus;}
    public String getOrigen() {return origen;}
    public String getDestino() {return destino;}
    public String getHoraSalida() {return horaSalida;}
    public String getHoraLlegada() {return horaLlegada;}
    public int getPrecioEst() {return precioEst;}
    public int getPrecioSemiC() {return precioSemiC;}
    public int getPrecioSC() {return precioSC;}

    /**
     * Método que entrega la cantidad de asientos de un determinado tipo que posee un autobús.
     * @param autobus   Autobús al que se le contarán los asientos.
     * @param servicio  Tipo de asiento que se desea contar.
     * @return Cantidad de asientos del tipo consultado.
     */
    public int cantAsientos(Autobus autobus, String servicio){
        int cant = 0;
        int numAsientos = autobus.getNumAsientosTotal();
        for(int i = 0; i < numAsientos; i++){
            if(autobus.getAsiento(i).getServicio() == servicio && autobus.getAsiento(i).seleccion()==1){
                cant++;
            }
        }
        return cant;
    }


}
