package modelo.jugador;

import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.pieza.Pieza;
import modelo.jugador.presupuesto.EstadoPresupuestoDeEjercito;
import modelo.jugador.presupuesto.EstadoPresupuestoNoAgotado;
import modelo.pieza.Ubicacion;
import modelo.pieza.movimiento.NoSePuedeMoverException;
import modelo.tablero.Tablero;

import java.util.ArrayList;
import java.util.Objects;

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
    public int getPresupuesto(){ return presupuesto.getPresupuesto();}

    //-----------Add-Remove-----------//

    public Pieza obtenerNuevaPieza(String unidadNombre, int posX, int posY) throws PresupuestoAgotadoException, CompraInvalidaException {
        Pieza piezaComprada = presupuesto.comprarPieza(numeroDeEjercito, unidadNombre, posX, posY);
        piezas.add(piezaComprada);
        this.presupuesto = presupuesto.devolverEstadoDePresuesto();
        return piezaComprada;
    }

    public boolean piezaEsDeJugador( Ubicacion ubicacionInicial ) {

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

    public void actualizarEstadoTropas(Tablero tableroDePartida) {
        piezas.stream().filter(Objects::nonNull).filter(p->(p.getPuntosVida()==0)).forEach(p->{ tableroDePartida.desocuparCasilla(p.getUbicacion().getPosicionEnX(),p.getUbicacion().getPosicionEnY());});
        ArrayList <Pieza> auxiliar = new ArrayList<>();
        piezas.stream().filter(pieza -> pieza.getPuntosVida()>0).forEach(p->auxiliar.add(p));
        piezas.clear();
        piezas.addAll(auxiliar);
    }
}





