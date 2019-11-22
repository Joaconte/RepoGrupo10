package jugador.presupuesto;

import jugador.Ejercito;
import pieza.Pieza;

public class EstadoPresupuestoAgotado implements EstadoPresupuestoDeEjercito{


    @Override
    public Pieza comprarPieza(int ejercito, String nombreUnidad) throws PresupuestoAgotadoException {
    throw new PresupuestoAgotadoException();
    }

    @Override
    public EstadoPresupuestoDeEjercito devolverEstadoDePresuesto(){
        return this ;
    }

}