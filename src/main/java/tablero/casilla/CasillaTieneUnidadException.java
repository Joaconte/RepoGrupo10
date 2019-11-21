package tablero.casilla;

public class CasillaTieneUnidadException extends Exception {

    public CasillaTieneUnidadException(){
        super("Esta casilla ya tiene una unidad");
    }
}