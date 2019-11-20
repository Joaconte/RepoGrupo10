package pieza.movimiento;

public class NoSePuedeMoverException extends Exception {
    public NoSePuedeMoverException (){
        super("No se puede cambiar de ubicación");
    }
}
