package modelo.partida;

public class JugadorNoPuedeException extends Exception {
    public JugadorNoPuedeException(){
        super("Jugador no puede manipular esta pieza.");
    }
}
