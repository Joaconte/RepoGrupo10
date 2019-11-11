package fiuba.algo3.TP2.model;

public class EstadoPresupuestoNoAgotado implements EstadoPresupuestoDeEjercito{

    private int presupuesto = 20;
    private FabricaDePiezas fabricaDePiezas = new FabricaDePiezas();

    @Override
    public void agregarPiezas(Ejercito ejercito, int costoUnidad){
        if (this.elPresupuestoAguanta(costoUnidad)) {
            ejercito.agregarPieza(fabricaDePiezas.getPieza(costoUnidad));
            this.presupuesto -= costoUnidad;
        }
    }

    @Override
    public EstadoPresupuestoDeEjercito devolverEstadoDePresuesto(){
        if (presupuesto == 0){
            return new EstadoPresupuestoAgotado();}
        return this ;
    }

    public boolean elPresupuestoAguanta(int costoUnidad){
        return (this.presupuesto >= costoUnidad);
    }

}