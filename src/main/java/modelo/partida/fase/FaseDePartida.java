package modelo.partida.fase;

import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.jugador.Jugador;
import modelo.jugador.PiezaFueraDeSectorException;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAtacante;
import modelo.pieza.Pieza;
import modelo.tablero.Tablero;

public interface FaseDePartida{

    //Metodos abstractos implementados por las subclases

    void moverUnidadEnTablero(Pieza pieza, int numeroFila, int numeroColumna);

    void terminarMiTurno();

    String darNombreDeFase();

    void atacar(PiezaAtacante atacante, Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException;

}