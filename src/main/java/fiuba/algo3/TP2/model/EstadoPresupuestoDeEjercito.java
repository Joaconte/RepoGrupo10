package fiuba.algo3.TP2.model;


public interface EstadoPresupuestoDeEjercito {

    //Metodos abstractos implementados por las subclases

    public void agregarPiezas(Ejercito ejercito, int costoUnidad);
    public EstadoPresupuestoDeEjercito devolverEstadoDePresuesto();

}