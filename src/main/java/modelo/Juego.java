package modelo;

import modelo.partida.Partida;
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



    public void arrancarPartida(){

    }

}
