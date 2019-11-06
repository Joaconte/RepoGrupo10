package model;

import java.util.ArrayList;
import java.util.List;

public class Partida {

    private List<Jugador> jugadores = new ArrayList<Jugador>();
    private Tablero tablero;


    public void agregarUnidadesAJugador(Jugador jugador){

        Unidad unidad = jugador.agregarYDevolverUnidad();
        while( unidad != null ){

            tablero.agregarUnidad(unidad);
        }

    }
}
