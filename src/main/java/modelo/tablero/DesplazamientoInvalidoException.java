package modelo.tablero;

public class DesplazamientoInvalidoException extends Exception {

    public DesplazamientoInvalidoException(){
        super("La unidad no se puede mover a esa posicion");
    }

}
