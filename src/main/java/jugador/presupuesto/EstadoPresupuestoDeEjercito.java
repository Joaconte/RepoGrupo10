package jugador.presupuesto;

import jugador.Ejercito;

public interface EstadoPresupuestoDeEjercito {

    //Metodos abstractos implementados por las subclases

    public void agregarPiezas(Ejercito ejercito, int costoUnidad);
    public EstadoPresupuestoDeEjercito devolverEstadoDePresuesto();

}