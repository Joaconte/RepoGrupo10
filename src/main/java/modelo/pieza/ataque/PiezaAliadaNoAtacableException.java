package modelo.pieza.ataque;

public class PiezaAliadaNoAtacableException extends Exception {
    public PiezaAliadaNoAtacableException() {
        super("Un aliado no es atacable.");
    }
}
