package fiuba.algo3.TP2.model;

import fiuba.algo3.TP2.exception.CostoNoValidoException;

public class EstadoPresupuestoNoAgotado implements EstadoPresupuestoDeEjercito{

    private int presupuesto;
    private FabricaDePiezas fabricaDePiezas = new FabricaDePiezas();


    public EstadoPresupuestoNoAgotado(int presupuesto){
        this.presupuesto =presupuesto;
    }

    public boolean elPresupuestoAguanta(int costoUnidad){
        return (this.presupuesto >= costoUnidad);
    }
    public void setPresupuesto(int unValor){
        this.presupuesto = unValor;
    }


    @Override
    public void agregarPiezas(Ejercito ejercito, int costoUnidad) throws CostoNoValidoException{
        if (this.elPresupuestoAguanta(costoUnidad)) {
                ejercito.agregarPieza(fabricaDePiezas.getPieza(costoUnidad));
            this.setPresupuesto(this.presupuesto - costoUnidad);
        }
    }

    @Override
    public EstadoPresupuestoDeEjercito devolverEstadoDePresuesto(){
        if (presupuesto == 0){
            return new EstadoPresupuestoAgotado();}
        return this ;
    }



}