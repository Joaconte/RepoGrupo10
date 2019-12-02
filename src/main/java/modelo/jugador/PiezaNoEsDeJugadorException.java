package modelo.jugador;

public class PiezaNoEsDeJugadorException extends Exception{

    public PiezaNoEsDeJugadorException(){
        super("Es pieza no es tuya");
    }
}



