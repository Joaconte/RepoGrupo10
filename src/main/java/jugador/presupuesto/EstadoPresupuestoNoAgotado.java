package jugador.presupuesto;

import jugador.FabricaDePiezas;
import pieza.Pieza;

public class EstadoPresupuestoNoAgotado implements EstadoPresupuestoDeEjercito{

    private int presupuesto;
    private FabricaDePiezas fabricaDePiezas = new FabricaDePiezas();

    /*----Inicializador-----*/

    public EstadoPresupuestoNoAgotado(int presupuesto){
        this.presupuesto =presupuesto;
    }

    /*----Metodos internos-----*/

    private void setPresupuesto(int unValor){
        this.presupuesto = unValor;
    }


    @Override
    public Pieza comprarPieza(int ejercito, String nombreUnidad, int posX, int posY) throws CompraInvalidaException {
        Pieza pieza = fabricaDePiezas.crearPieza(ejercito,nombreUnidad,posX,posY);
        if (presupuesto-pieza.getCosto()<0){throw new CompraInvalidaException();}
        this.setPresupuesto(this.presupuesto - pieza.getCosto());
        return pieza;
    }

    @Override
    public EstadoPresupuestoDeEjercito devolverEstadoDePresuesto(){
        if (presupuesto == 0){
            return new EstadoPresupuestoAgotado();}
        return this ;
    }
}