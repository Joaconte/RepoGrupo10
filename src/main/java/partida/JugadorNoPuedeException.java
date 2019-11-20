package partida;

public class JugadorNoPuedeException extends Exception {
    public JugadorNoPuedeException(){
        super("Jugador no puede realizar accion.");
    }
}
