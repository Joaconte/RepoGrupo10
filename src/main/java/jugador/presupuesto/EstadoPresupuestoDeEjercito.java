package jugador.presupuesto;

import pieza.Pieza;

public interface EstadoPresupuestoDeEjercito {

    //Metodos abstractos implementados por las subclases

    Pieza comprarPieza(int ejercito, String nombreUnidad) throws PresupuestoAgotadoException, CompraInvalidaException;
    EstadoPresupuestoDeEjercito devolverEstadoDePresuesto();

}