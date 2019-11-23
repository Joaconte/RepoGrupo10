package jugador.presupuesto;

import jugador.Ejercito;
import pieza.Pieza;

public class EstadoPresupuestoAgotado implements EstadoPresupuestoDeEjercito{


    @Override
    public Pieza comprarPieza(int ejercito, String nombreUnidad, int posX, int posY) throws PresupuestoAgotadoException {
    throw new PresupuestoAgotadoException();
    }

    @Override
    public EstadoPresupuestoDeEjercito devolverEstadoDePresuesto(){
        return this ;
    }

}