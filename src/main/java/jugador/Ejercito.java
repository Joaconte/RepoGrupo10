package jugador;

import jugador.presupuesto.*;
import pieza.Pieza;
import pieza.Ubicacion;

import java.util.ArrayList;

public class Ejercito{

    private ArrayList<Pieza> piezas = new ArrayList<Pieza>();
    private int numeroDeEjercito;
    private EstadoPresupuestoDeEjercito presupuesto;

    public Ejercito (){
        this.presupuesto = new EstadoPresupuestoNoAgotado(20);
    }

    //---------Inicializacion---------//

    public Ejercito(int numeroDeJugador) {
        this.numeroDeEjercito =  numeroDeJugador;
    }

    //-----------GETTERS Y SETTERS-----------//


    public int getNumeroDeEjercito(){ return numeroDeEjercito; }
    public int getTamanio(){ return ( piezas.size()); }
    public ArrayList<Pieza> getPiezas(){ return piezas; }

    public void setEstadoPresupuesto(EstadoPresupuestoDeEjercito presupuesto){
        this.presupuesto = presupuesto.devolverEstadoDePresuesto();
    }

    //-----------Add-Remove-----------//

    public void comprarPieza (String unidadNombre) {
        piezas.add(presupuesto.agregarPiezas(numeroDeEjercito, unidadNombre);
        this.setEstadoPresupuesto(this.presupuesto);
    }



}

/*
    public boolean ubicacionEsValida(Ubicacion ubicacion) throws UbicacionInvalidaException {

        for (int i = 0; i < ejercito.size(); ++i) {
            if(ejercito.get(i).getUbicacion() == ubicacion){
                throw new UbicacionInvalidaException();
            }
        }
        return true;
    }

    public boolean ubicacionValida(int x, int y) {

        Ubicacion ubicacion = new Ubicacion(x,y);
        boolean booleano = false;
        try {
            booleano = ubicacionEsValida(ubicacion);
        } catch (UbicacionInvalidaException e) {
            System.out.println(e);
            booleano = false;
        }
        return booleano;
    }
}


     */




