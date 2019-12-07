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

    public boolean estaDestruido(){ return piezas.size()==0; }

    public void actualizarEstadoTropas() {
        ArrayList <Pieza> auxiliar = new ArrayList<>();
        piezas.stream().filter(pieza -> pieza.getPuntosVida()>0).forEach(auxiliar::add);
        piezas.clear();
        piezas.addAll(auxiliar);
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

    private boolean estaEnUnBatallonValido(Pieza infante) throws NoHayBatallonException {
        AtomicBoolean siguenContiguos = new AtomicBoolean(false);
        batallones.stream().filter(batallon -> batallon.contiene(infante)).forEach(batallon -> {if (batallon.siguenContiguos()) {siguenContiguos.set(true);}});
        return siguenContiguos.get(); //porque un soldado PUEDE moverse solo o en battallon
    }

    public void ordenarTropas(ArrayList<Pieza> piezas, ArrayList<Integer> ubicacionesX, ArrayList<Integer> ubicacionesY, int posicionXFinal, int posicionYFinal) throws NoHayBatallonException {
        if ( !this.estaEnUnBatallonValido(piezas.get(0))) throw new NoHayBatallonException(); //porque un soldado PUEDE moverse solo o en battallon
        batallones.stream().filter(batallon -> batallon.contiene(piezas.get(0))).forEach(batallon -> batallon.ordenarFormacion(piezas, ubicacionesX,ubicacionesY,posicionXFinal,posicionYFinal));

    }
}




