package partida;

public class PiezaAliadaNoAtacableException extends Exception {
    public PiezaAliadaNoAtacableException() {
        super("Una pieza Aliada no es atacable. Traidor (?)");
    }
}
