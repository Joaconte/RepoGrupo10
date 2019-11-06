package exception;

public class PuntosInsuficientesException extends Exception{

    public PuntosInsuficientesException(){
        super("No te alcanzan los puntos esta unidad");
    }
}
