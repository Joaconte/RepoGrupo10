package modelo.pieza.tipos;

public class NoHayBatallonException extends Exception {
    public NoHayBatallonException (){
        super("No Existe el batallon");
    }
}
