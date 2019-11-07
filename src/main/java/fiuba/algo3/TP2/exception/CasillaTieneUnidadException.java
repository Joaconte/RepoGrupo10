package fiuba.algo3.TP2.exception;

public class CasillaTieneUnidadException extends Exception {

    public CasillaTieneUnidadException(){
        super("Esta casilla ya tiene una unidad");
    }
}