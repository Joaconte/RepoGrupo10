package partida.ataques;

public class PiezaAtacadaEnRangoIncorrectoException extends Exception {
    public PiezaAtacadaEnRangoIncorrectoException(){
        super("La pieza no puede atacar en ese rango");
    }
}
