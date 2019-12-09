package modelo.partida;

public class JugadorNoPuedeManipularEsaPiezaException extends Exception {
    public JugadorNoPuedeManipularEsaPiezaException(){
        super("Pieza no es de jugador.");
    }
}
