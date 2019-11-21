package tablero.casilla;

public class CasillaNoTieneUnidadException extends Exception {

    public CasillaNoTieneUnidadException(){
        super("Esta casilla no tiene ninguna unidad");
    }
}

