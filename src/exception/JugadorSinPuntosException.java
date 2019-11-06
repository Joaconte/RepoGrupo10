package exception;

public class JugadorSinPuntosException extends Exception{

    public JugadorSinPuntosException(){
        super("No tenes puntos");
    }
}