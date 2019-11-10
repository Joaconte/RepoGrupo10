package fiuba.algo3.TP2.exception;

public class UnidadEstaMuertaException extends RuntimeException {
    public UnidadEstaMuertaException(){
        super("Esta pieza ya murió.");
    }
}
