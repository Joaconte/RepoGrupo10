package modelo.jugador.presupuesto;

public class CompraInvalidaException extends Exception{

    public CompraInvalidaException(){
        super("La unidad con tal costo no existe");
    }
}
