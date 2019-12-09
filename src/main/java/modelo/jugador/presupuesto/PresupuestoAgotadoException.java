package modelo.jugador.presupuesto;

public class PresupuestoAgotadoException extends Exception {
    public PresupuestoAgotadoException (){
        super("No tienes presupuesto suficiente.");
    }
}

