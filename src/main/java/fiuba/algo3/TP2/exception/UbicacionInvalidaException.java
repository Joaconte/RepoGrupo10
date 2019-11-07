package fiuba.algo3.TP2.exception;

public class UbicacionInvalidaException extends Exception{

    public UbicacionInvalidaException(){
        super("Esa ubicacion ya esta ocupada");
    }
}

