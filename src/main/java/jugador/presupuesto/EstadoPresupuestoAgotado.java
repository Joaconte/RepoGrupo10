package jugador.presupuesto;

import jugador.Ejercito;

public class EstadoPresupuestoAgotado implements EstadoPresupuestoDeEjercito{


    @Override
    public void agregarPiezas(Ejercito ejercito, int costoUnidad) {
    }

    @Override
    public EstadoPresupuestoDeEjercito devolverEstadoDePresuesto(){
        return this ;
    }

}