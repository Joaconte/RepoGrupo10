package modelo.partida.fase;

import modelo.jugador.EjercitoIncompletoException;
import modelo.jugador.Jugador;
import modelo.pieza.ataque.PiezaAtacante;
import modelo.pieza.Pieza;
import modelo.tablero.Tablero;

public class FaseInicial implements FaseDePartida{

    //Metodo que permite intercambiar fichas en dos posiciones cualesquiera en el sector del jugador.
    @Override
    public void moverUnidadEnTablero(Pieza pieza, int posicionFila, int posicionColumna){
        //Nada
    }

    //Metodo que permite indicar que el jugador termina con las acciones de su turno.
    @Override
    public void verificarFinTurno(Jugador jugadorEnTurno) throws EjercitoIncompletoException {
        jugadorEnTurno.verificarSiEjercitoEstaListo();
    }

    //Metodo para pedir a fase su nombre
    @Override
    public String darNombreDeFase(){
        return "Fase Inicial";
    }

    //Ataques y curacion
    @Override
    public void atacar(PiezaAtacante atacante, Pieza atacada, Tablero tablero) {
    }



}