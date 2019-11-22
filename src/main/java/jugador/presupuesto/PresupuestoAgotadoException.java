package jugador.presupuesto;

public class PresupuestoAgotadoException extends Exception {
    public PresupuestoAgotadoException (){
        super("No tenes presupuesto, como en la vida real.");
    }
}

