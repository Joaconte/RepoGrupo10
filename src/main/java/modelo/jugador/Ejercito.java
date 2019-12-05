package modelo.jugador;

import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.pieza.Pieza;
import modelo.jugador.presupuesto.EstadoPresupuestoDeEjercito;
import modelo.jugador.presupuesto.EstadoPresupuestoNoAgotado;
import modelo.pieza.Ubicacion;
import modelo.pieza.tipos.Batallon;
import modelo.pieza.tipos.NoHayBatallonException;
import modelo.pieza.tipos.NoSirvenParaBatallonException;
import modelo.tablero.Tablero;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class Ejercito{

    private ArrayList<Pieza> piezas = new ArrayList<Pieza>();
    private int numeroDeEjercito;
    private EstadoPresupuestoDeEjercito presupuesto;
    private ArrayList<Batallon> batallones = new ArrayList<Batallon>();


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

    //-----------Estados del Batallon-----------//

    public boolean dominaEstaUbicacion(Ubicacion ubicacionInicial ) {

        for (int i=0; i< piezas.size(); i++){
            Pieza pieza = piezas.get(i);
            int posX = pieza.getUbicacion().getPosicionEnX();
            int posY = pieza.getUbicacion().getPosicionEnY();
            if ((posX == ubicacionInicial.getPosicionEnX()) && (posY == ubicacionInicial.getPosicionEnY()))
            return true;
        }
        return false;
    }

    public boolean estaCompleto() {
        return presupuesto.estaAgotado();
    }

    public boolean estaDestruido(){ return piezas.size()==0; }

    public void removerBajas(Tablero tableroDePartida) {
        piezas.stream().filter(Objects::nonNull).filter(p->(p.getPuntosVida()==0)).forEach(p->{ tableroDePartida.desocuparCasilla(p.getUbicacion().getPosicionEnX(),p.getUbicacion().getPosicionEnY());});
        ArrayList <Pieza> auxiliar = new ArrayList<>();
        piezas.stream().filter(pieza -> pieza.getPuntosVida()>0).forEach(p->auxiliar.add(p));
        piezas.clear();
        piezas.addAll(auxiliar);
    }



    //---------Batallon-----------//

    public void agregarBatallon(ArrayList<Pieza> batallonNuevo) throws NoSirvenParaBatallonException {
        batallonNuevo.forEach(p->disolverViejoBatallon(p.getUbicacion()));
        Batallon nuevoBatallon=new Batallon(batallonNuevo);
        batallones.add(nuevoBatallon);
    }

    public void desplazarBatallon(Tablero tablero, Ubicacion ubicacionInicial, Ubicacion ubicacionFinal) throws UbicacionInvalidaException, NoHayBatallonException {
        validarBatallon (ubicacionInicial);
        if (tablero.casillaEstaOcupada(ubicacionFinal.getPosicionEnX(),ubicacionFinal.getPosicionEnY())) throw new UbicacionInvalidaException();
        batallones.stream().filter(batallon -> batallon.contiene(ubicacionInicial)).forEach(batallon -> batallon.desplazaBatallonEnOrden(tablero,ubicacionInicial,ubicacionFinal));
        batallones.stream().filter(batallon -> batallon.contiene(ubicacionFinal)).filter(batallon -> !batallon.siguenContiguos()).forEach(batallon->batallones.remove(batallon));
    }

    private void disolverViejoBatallon(Ubicacion ubicacion){
         batallones.stream().filter(batallon -> batallon.contiene(ubicacion)).forEach(batallon -> batallones.remove(batallon));
    }

    private void validarBatallon (Ubicacion ubicacion) throws NoHayBatallonException {
        AtomicBoolean siguenContiguos = new AtomicBoolean(false);
        batallones.stream().filter(batallon -> batallon.contiene(ubicacion)).forEach(batallon -> {if (batallon.siguenContiguos()) {siguenContiguos.set(true);}});
        if ( !siguenContiguos.get()) throw new NoHayBatallonException(); //porque un soldado PUEDE moverse solo o en battallon

    }
}





