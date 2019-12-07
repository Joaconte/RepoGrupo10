package modelo.jugador;

import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.pieza.Pieza;
import modelo.jugador.presupuesto.EstadoPresupuestoDeEjercito;
import modelo.jugador.presupuesto.EstadoPresupuestoNoAgotado;
import modelo.pieza.tipos.Batallon;
import modelo.pieza.tipos.Infanteria;
import modelo.pieza.tipos.NoHayBatallonException;
import modelo.pieza.tipos.NoSirvenParaBatallonException;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Ejercito{

    private ArrayList<Pieza> piezas = new ArrayList<>();
    private int numeroDeEjercito;
    private EstadoPresupuestoDeEjercito presupuesto;
    private ArrayList<Batallon> batallones = new ArrayList<>();


    //---------Inicializacion---------//

    public Ejercito(int numeroDeJugador) {
        this.numeroDeEjercito =  numeroDeJugador;
        this.presupuesto = new EstadoPresupuestoNoAgotado(20);
    }

    //-----------GETTERS Y SETTERS-----------//


    public int getNumeroDeEjercito(){ return numeroDeEjercito; }
    public int getTamanio(){ return ( piezas.size()); }
    public int getPresupuesto(){ return presupuesto.getPresupuesto();}

    //-----------Add-Remove-----------//

    public Pieza obtenerNuevaPieza(String unidadNombre, int posX, int posY) throws PresupuestoAgotadoException, CompraInvalidaException {
        Pieza piezaComprada = presupuesto.comprarPieza(numeroDeEjercito, unidadNombre, posX, posY);
        piezas.add(piezaComprada);
        this.presupuesto = presupuesto.devolverEstadoDePresuesto();
        return piezaComprada;
    }

    //-----------Estados del Ejercito-----------//


    public boolean estaCompleto() {
        return presupuesto.estaAgotado();
    }


    public boolean  estaDestruido() {
        ArrayList <Pieza> auxiliar = new ArrayList<>();
        piezas.stream().filter(pieza -> !pieza.estaViva()).forEach(auxiliar::add);
        return auxiliar.size()==piezas.size();
    }


    //---------Batallon-----------//

    public void agregarBatallon(ArrayList<Pieza> batallonNuevo) throws NoSirvenParaBatallonException {
        Batallon nuevoBatallon=new Batallon(batallonNuevo);
        disolverSusViejosBatallones(batallonNuevo);
        batallones.add(nuevoBatallon);
    }

    private void disolverSusViejosBatallones(ArrayList<Pieza> batallonNuevo){
       ArrayList<Batallon> listaAuxiliar = new ArrayList<>();
       batallones.stream().filter(batallon -> batallon.contiene(batallonNuevo.get(0))|| batallon.contiene(batallonNuevo.get(1))||batallon.contiene(batallonNuevo.get(2)))
               .forEach(listaAuxiliar::add);
       listaAuxiliar.forEach(p-> batallones.remove(p));
    }

    private void actualizarBatallones (){ //Pieza puede moverse sola tambien. Se disuelve no solo despues del movimiento del batallon.
        ArrayList<Batallon> listaAuxiliar = new ArrayList<>();
        batallones.stream().filter(p->!p.siguenContiguos()).forEach(listaAuxiliar::add);
        listaAuxiliar.stream().filter(batallon -> batallones.contains(batallon)).forEach(batallon -> batallones.remove(batallon));
    }

    public void ordenarTropas(ArrayList<Pieza> piezas, ArrayList<Integer> ubicacionesX, ArrayList<Integer> ubicacionesY, int posicionXFinal, int posicionYFinal) throws NoHayBatallonException {
        actualizarBatallones();
        batallones.stream().filter(batallon -> batallon.contiene(piezas.get(0))).forEach(batallon -> batallon.ordenarFormacion(piezas, ubicacionesX,ubicacionesY,posicionXFinal,posicionYFinal));
        if(piezas.size()!=3){ throw new NoHayBatallonException();}
    }
}




