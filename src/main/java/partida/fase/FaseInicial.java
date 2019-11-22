package partida.fase;

import jugador.Jugador;
import jugador.PiezaFueraDeSectorException;
import pieza.ataque.PiezaAtacante;
import pieza.Pieza;
import tablero.Tablero;

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

    //Ataques y curacion
    @Override
    public void atacar(PiezaAtacante atacante, Pieza atacada, Tablero tablero) {
        String texto = "La nada misma";
    }



    //Colocacion y movimiento

    @Override
    public void agregarNuevaUbicacionAFicha(Jugador jugadorEnTurno, Pieza pieza, int posicionX, int posicionY) throws PiezaFueraDeSectorException {
        jugadorEnTurno.agregarUbicacionAPieza(pieza, posicionX, posicionY);
    }


}