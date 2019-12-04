package modelo;

import modelo.jugador.EjercitoIncompletoException;
import modelo.jugador.PiezaFueraDeSectorException;
import modelo.jugador.PiezaNoEsDeJugadorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.partida.JugadorNoPuedeManipularEsaPiezaException;
import modelo.partida.Partida;
import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.pieza.ataque.PiezaAtacante;
import modelo.pieza.movimiento.NoSePuedeMoverException;
import modelo.tablero.DesplazamientoInvalidoException;
import modelo.tablero.Tablero;
import modelo.tablero.casilla.NoHayUnidadEnPosicionException;

public class Juego {

    private Partida partida;

    public Juego(){
        partida = new Partida();
    }

    public void agregarJugadores( String nombreJugadorUno , String nombreJugadorDos ) {
        partida.agregarJugadores( nombreJugadorUno, nombreJugadorDos );
    }

    public Tablero getTablero(){
        return partida.getTableroDePartida();
    }

    public String getNombreJugadorEnTurno(){ return partida.getNombreJugadorEnTurno();}

    public int getPuntosJugadorEnTurno(){ return partida.getPuntosJugadorEnTurno();}

    public Pieza crearPieza(String nombre,int  posX, int posY) throws UbicacionInvalidaException, PresupuestoAgotadoException, CompraInvalidaException, PiezaFueraDeSectorException {
        return partida.crearPieza(nombre, posX, posY);
    }

    public boolean estaEnTurno(int numero){
        return partida.getJugadorEnTurno().getNumeroDeJugador() == numero;
    }

    public void cambiarTurno() throws EjercitoIncompletoException { partida.pasarTurno();}

    public boolean estaEnFaseInicial() { return partida.estaEnFaseInicial();}

    public String getNombreDeJugadorUno() { return partida.getJugadorUno().getNombre();}

    public String getNombreDeJugadorDos() { return partida.getJugadorDos().getNombre();}

    public void arrancarPartida(){

    }

    public void moverUnidad(Ubicacion ubicacionInicial, Ubicacion ubicaionFinal) throws PiezaNoEsDeJugadorException, NoHayUnidadEnPosicionException, DesplazamientoInvalidoException, NoSePuedeMoverException {
        partida.moverUnidad(ubicacionInicial, ubicaionFinal);
    }

    public void atacar (PiezaAtacante piezaAtacante, Pieza pieza) throws PiezaAliadaNoAtacableException, JugadorNoPuedeManipularEsaPiezaException, UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        partida.atacarPieza(piezaAtacante,pieza);
    }

    public void actualizarTablero(){
        partida.actualizarTablero();
    }
}

