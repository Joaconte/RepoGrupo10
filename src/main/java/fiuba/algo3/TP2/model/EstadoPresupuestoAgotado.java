package fiuba.algo3.TP2.model;

public class EstadoPresupuestoAgotado implements EstadoPresupuestoDeEjercito{


    @Override
    public void agregarPiezas(Ejercito ejercito, int costoUnidad){
    }

    @Override
    public EstadoPresupuestoDeEjercito devolverEstadoDePresuesto(){
        return this ;
    }

}