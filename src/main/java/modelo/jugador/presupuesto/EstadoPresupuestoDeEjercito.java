package modelo.jugador.presupuesto;

import modelo.pieza.Pieza;

public interface EstadoPresupuestoDeEjercito {

    //Metodos abstractos implementados por las subclases


    Pieza comprarPieza(int ejercito, String nombreUnidad, int posX, int posY) throws PresupuestoAgotadoException, CompraInvalidaException;
    EstadoPresupuestoDeEjercito devolverEstadoDePresuesto();

    public int getPresupuesto();

    boolean estaAgotado();
}