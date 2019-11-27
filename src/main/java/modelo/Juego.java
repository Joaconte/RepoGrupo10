package modelo;

import modelo.partida.Partida;

public class Juego {

    private Partida partida;

    public Juego(){
        partida = new Partida();
    }

    public void agregarJugadores( String nombreJugadorUno , String nombreJugadorDos ) {

        partida.agregarJugadores( nombreJugadorUno, nombreJugadorDos );
    }

    public void arrancarPartida(){

    }

}
