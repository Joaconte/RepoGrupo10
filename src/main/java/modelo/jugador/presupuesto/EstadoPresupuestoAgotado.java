package modelo.jugador.presupuesto;

import modelo.pieza.Pieza;

public class EstadoPresupuestoAgotado implements EstadoPresupuestoDeEjercito{

    int PRESUPUESTO = 0;

    public int getPresupuesto(){ return PRESUPUESTO;}

    @Override
    public Pieza comprarPieza(int ejercito, String nombreUnidad, int posX, int posY) throws PresupuestoAgotadoException {
    throw new PresupuestoAgotadoException();
    }

    @Override
    public EstadoPresupuestoDeEjercito devolverEstadoDePresuesto(){
        return this ;
    }

    @Override
    public boolean estaAgotado() {
        return true;
    }

}