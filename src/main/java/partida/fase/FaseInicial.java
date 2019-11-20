package partida.fase;

import jugador.Jugador;
import partida.ataques.JineteAsediadoException;
import partida.ataques.JineteNoAsediadoException;
import partida.ataques.PiezaAtacadaEnRangoIncorrectoException;
import pieza.Pieza;
import pieza.tipos.Catapulta;
import pieza.tipos.Infanteria;
import pieza.tipos.Jinete;

public class FaseInicial implements FaseDePartida{

    //Metodo que permite intercambiar fichas en dos posiciones cualesquiera en el sector del jugador.
    @Override
    public void moverUnidadEnTablero(Pieza pieza, int posicionFila, int posicionColumna){
        //Construir
    }

    //Metodo que permite indicar que el jugador termina con las acciones de su turno.
    @Override
    public void terminarMiTurno(){
        //Construir?
    };

    //Metodo para pedir a fase su nombre
    @Override
    public String darNombreDeFase(){
        return "Fase Inicial";
    }


    @Override
    public void atacar(Infanteria atacante, Pieza atacada, Jugador jugadorEnTurno) throws PiezaAtacadaEnRangoIncorrectoException {
        //La nada misma
    }

    @Override
    public void atacar(Catapulta atacante, Pieza atacada, Jugador jugadorEnTurno) throws PiezaAtacadaEnRangoIncorrectoException {
        //La nada misma
    }

    @Override
    public void atacar(Jinete atacante, Pieza atacada, Jugador jugadorEnTurno) throws PiezaAtacadaEnRangoIncorrectoException, JineteAsediadoException, JineteNoAsediadoException {
        //La nada misma
    }

    public void colocarPieza (){

    }
}