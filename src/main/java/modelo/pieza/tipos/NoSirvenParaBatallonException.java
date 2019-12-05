package modelo.pieza.tipos;

public class NoSirvenParaBatallonException extends Exception {
    public NoSirvenParaBatallonException (){
        super("No cumplen las condiciones para formar un batallon.");
    }
}
