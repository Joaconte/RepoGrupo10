package modelo.pieza;

public class UnidadEstaMuertaException extends Exception {
    public UnidadEstaMuertaException(){
        super("Esta pieza ya murió.");
    }
}
