package modelo.tablero;

public class DesplazamientoInvalidoException extends Exception {

    public DesplazamientoInvalidoException(){
        super("El rango de movimiento es de tan solo una casilla");
    }

}
