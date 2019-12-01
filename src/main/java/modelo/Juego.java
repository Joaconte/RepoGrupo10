package modelo;

import modelo.jugador.PiezaFueraDeSectorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.partida.Partida;
import modelo.pieza.Pieza;
import modelo.tablero.Tablero;

public class Juego {

    private Partida partida;

    public Juego(){
        partida = new Partida();
    }

    public void agregarJugadores( String nombreJugadorUno , String nombreJugadorDos ) {

        partida.agregarJugadores( nombreJugadorUno, nombreJugadorDos );
    }

    public Partida getPartida(){ return partida; }

    public Tablero getTablero(){
        return partida.getTableroDePartida();
    }

    public String getNombreJugadorEnTurno(){ return partida.getNombreJugadorEnTurno();}

    public int getPuntosJugadorEnTurno(){ return partida.getPuntosJugadorEnTurno();}

    public Pieza crearPieza(String nombre,int  posX, int posY) throws UbicacionInvalidaException, PresupuestoAgotadoException, CompraInvalidaException, PiezaFueraDeSectorException {
        return partida.crearPieza(nombre, posX, posY);
    }

    public void arrancarPartida(){

    }

}
