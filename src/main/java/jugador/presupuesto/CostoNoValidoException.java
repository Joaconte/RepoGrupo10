package jugador.presupuesto;

public class CostoNoValidoException extends Exception{

    public CostoNoValidoException (){
        super("La unidad con tal costo no existe");
    }
}
