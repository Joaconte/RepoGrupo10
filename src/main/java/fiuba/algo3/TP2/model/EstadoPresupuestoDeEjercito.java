package fiuba.algo3.TP2.model;

import fiuba.algo3.TP2.exception.CostoNoValidoException;

public interface EstadoPresupuestoDeEjercito {

    //Metodos abstractos implementados por las subclases

    public void agregarPiezas(Ejercito ejercito, int costoUnidad) throws CostoNoValidoException;
    public EstadoPresupuestoDeEjercito devolverEstadoDePresuesto();

}