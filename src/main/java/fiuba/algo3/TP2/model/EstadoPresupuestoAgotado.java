package fiuba.algo3.TP2.model;
import fiuba.algo3.TP2.exception.CostoNoValidoException;

public class EstadoPresupuestoAgotado implements EstadoPresupuestoDeEjercito{


    @Override
    public void agregarPiezas(Ejercito ejercito, int costoUnidad) throws CostoNoValidoException{
    }

    @Override
    public EstadoPresupuestoDeEjercito devolverEstadoDePresuesto(){
        return this ;
    }

}