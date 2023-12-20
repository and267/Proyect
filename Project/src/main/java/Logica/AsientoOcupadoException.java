package Logica;

/**Clase AsientoOcupadoException: encargada de notificar si se selecciona un asiento que ya estaba ocupado**/
public class AsientoOcupadoException extends Exception{

    public AsientoOcupadoException(String errorMessage){
        super(errorMessage);
    }
}
