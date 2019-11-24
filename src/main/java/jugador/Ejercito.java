package jugador;

import jugador.presupuesto.*;
import pieza.Pieza;
import java.util.ArrayList;

public class Ejercito{

    private ArrayList<Pieza> piezas = new ArrayList<Pieza>();
    private int numeroDeEjercito;
    private EstadoPresupuestoDeEjercito presupuesto;


    //---------Inicializacion---------//

    public Ejercito(int numeroDeJugador) {
        this.numeroDeEjercito =  numeroDeJugador;
        this.presupuesto = new EstadoPresupuestoNoAgotado(20);
    }

    //-----------GETTERS Y SETTERS-----------//


    public int getNumeroDeEjercito(){ return numeroDeEjercito; }
    public int getTamanio(){ return ( piezas.size()); }
    public ArrayList<Pieza> getPiezas(){ return piezas; }

    public void setEstadoPresupuesto(EstadoPresupuestoDeEjercito presupuesto){
        this.presupuesto = presupuesto.devolverEstadoDePresuesto();
    }

    //-----------Add-Remove-----------//

    public Pieza obtenerNuevaPieza(String unidadNombre, int posX, int posY) throws PresupuestoAgotadoException, CompraInvalidaException {
        Pieza piezaComprada = presupuesto.comprarPieza(numeroDeEjercito, unidadNombre, posX, posY);
        piezas.add(piezaComprada);
        this.setEstadoPresupuesto(this.presupuesto);
        return piezaComprada;
    }


}




