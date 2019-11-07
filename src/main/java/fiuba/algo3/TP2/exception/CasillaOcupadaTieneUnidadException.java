package fiuba.algo3.TP2.exception;

public class CasillaOcupadaTieneUnidadException extends Exception {

    public CasillaOcupadaTieneUnidadException(){
        super("Esta casilla ya tiene una unidad");
    }
}