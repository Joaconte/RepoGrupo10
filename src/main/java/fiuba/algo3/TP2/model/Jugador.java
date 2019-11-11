package fiuba.algo3.TP2.model;

import fiuba.algo3.TP2.exception.CostoNoValidoException;

import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;

public class Jugador {

    private EstadoPresupuestoDeEjercito presupuesto;
    private int numeroDeJugador;
    private Sector sector;
    private Ejercito ejercito;
    private int valorEjercito;

    //---------Inicializacion---------//

    public Jugador(int numeroDeJugador, Sector sector){
        this.valorEjercito = 20;
        this.presupuesto = new EstadoPresupuestoNoAgotado(valorEjercito);
        this.numeroDeJugador = numeroDeJugador;
        this.sector = sector;
        this.ejercito = new Ejercito (numeroDeJugador);
    }

    //-----------GETTERS-----------//

    public int getNumeroDeJugador(){
        return numeroDeJugador;
    }
    public Sector getSector(){
        return sector;
    }
    public int getTamanioDelEjercito() {
        return this.ejercito.getTamanio();
    }

    //-----------Metodos Ejercito-------------//

    public void agregarUnidad(int costoUnidad){
        try {
            this.presupuesto.agregarPiezas(this.ejercito, costoUnidad);
        }
        catch (CostoNoValidoException e){}
        this.setEstadoPresupuesto(this.presupuesto);
    }

    public void quitarUnidad(int posicion){
        this.ejercito.removerPieza(posicion);
    }

    //------------Metodo Presupuesto------------//

    public void setEstadoPresupuesto(EstadoPresupuestoDeEjercito presupuesto){
        this.presupuesto = presupuesto.devolverEstadoDePresuesto();
    }

}


    /*    public void quitarUnidad(Ubicacion ubicacion) {
        for (int i = 0; i < ejercito.size(); ++i) {
            if(ejercito.get(i).getUbicacion() == ubicacion){
                ejercito.remove(i);
            }
        }
    }

    private Unidad menuUnidades() {

        byte i = '1';
        Scanner capt = new Scanner(System.in);
        while (i != '0') {

            System.out.println("Ingrese 0 para terminar la compra de unidades");
            System.out.println("Ingrese 1 para seleccionar la unidad Infanteria");
            System.out.println("Ingrese 2 para seleccionar la unidad Jinete");
            System.out.println("Ingrese 3 para seleccionar la unidad Curandero");
            System.out.println("Ingrese 4 para seleccionar la unidad Catapulta");
            i = capt.nextByte();
            Unidad unidad = opcionesUnidades(i);
        }
        return null;
    }
    */
