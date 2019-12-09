package modelo.tablero;

public class DesplazamientoInvalidoException extends Exception {

    public DesplazamientoInvalidoException(){
        super("Solo una casilla por vez");
    }

}
