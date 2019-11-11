package pieza;

public class UnidadEstaMuertaException extends RuntimeException {
    public UnidadEstaMuertaException(){
        super("Esta pieza ya murió.");
    }
}
