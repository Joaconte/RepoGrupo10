package modelo.pieza.tipos;

public class NoSePuedeMoverException extends Exception {
    public NoSePuedeMoverException (){
        super("No se puede cambiar de ubicación");
    }
}
