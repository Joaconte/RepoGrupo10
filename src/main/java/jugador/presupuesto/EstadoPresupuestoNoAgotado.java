package jugador.presupuesto;

import jugador.Ejercito;
import jugador.FabricaDePiezas;

public class EstadoPresupuestoNoAgotado implements EstadoPresupuestoDeEjercito{

    private int presupuesto;
    private FabricaDePiezas fabricaDePiezas = new FabricaDePiezas();

    /*----Inicializador-----*/
    public EstadoPresupuestoNoAgotado(int presupuesto){
        this.presupuesto =presupuesto;
    }

    /*----Metodos internos-----*/
    private boolean costoEsValido(int costoUnidad){
        return ((this.presupuesto >= costoUnidad) && costoUnidad > 0);
    }
    private void setPresupuesto(int unValor){
        this.presupuesto = unValor;
    }


    @Override
    public void agregarPiezas(Ejercito ejercito, int costoUnidad) {
        if (this.costoEsValido(costoUnidad)) {
            fabricaDePiezas.agregarPieza(ejercito,costoUnidad);
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