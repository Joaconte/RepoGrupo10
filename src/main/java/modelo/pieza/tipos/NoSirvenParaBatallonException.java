package modelo.pieza.tipos;

public class NoSirvenParaBatallonException extends Exception {
    public NoSirvenParaBatallonException (){
        super("Incompatibles para un batallon.");
    }
}
