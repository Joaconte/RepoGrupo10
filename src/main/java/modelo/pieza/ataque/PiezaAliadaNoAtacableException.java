package modelo.pieza.ataque;

public class PiezaAliadaNoAtacableException extends Exception {
    public PiezaAliadaNoAtacableException() {
        super("Una pieza Aliada no es atacable. Traidor (?)");
    }
}
