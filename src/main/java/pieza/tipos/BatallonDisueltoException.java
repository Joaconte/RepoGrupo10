package pieza.tipos;

public class BatallonDisueltoException extends Exception {
    public BatallonDisueltoException (){
        super("No hay un batallon formado.");
    }
}
