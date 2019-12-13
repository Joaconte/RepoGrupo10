package modelo.partida;

public class JugadorNoPuedeManipularEsaPiezaException extends Exception {
    public JugadorNoPuedeManipularEsaPiezaException(){
        super("Jugador no puede usar esa pieza.");
    }
}
