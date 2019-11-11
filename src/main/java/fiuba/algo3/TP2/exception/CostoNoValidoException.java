package fiuba.algo3.TP2.exception;

public class CostoNoValidoException extends Exception{

    public CostoNoValidoException (){
        super("La unidad con tal costo no existe");
    }
}
