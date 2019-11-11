package jugador.presupuesto;

import jugador.Ejercito;

public class EstadoPresupuestoAgotado implements EstadoPresupuestoDeEjercito{


    @Override
    public void agregarPiezas(Ejercito ejercito, int costoUnidad) throws CostoNoValidoException {
    }

    @Override
    public EstadoPresupuestoDeEjercito devolverEstadoDePresuesto(){
        return this ;
    }

}