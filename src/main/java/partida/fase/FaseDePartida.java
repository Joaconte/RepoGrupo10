package partida.fase;

import jugador.Jugador;
import jugador.PiezaFueraDeSectorException;
import pieza.UnidadEstaMuertaException;
import pieza.ataque.DistanciaDeAtaqueInvalidaException;
import pieza.ataque.PiezaAliadaNoAtacableException;
import pieza.ataque.PiezaAtacante;
import pieza.Pieza;
import tablero.Tablero;

public interface FaseDePartida{

    //Metodos abstractos implementados por las subclases

    void moverUnidadEnTablero(Pieza pieza, int numeroFila, int numeroColumna);

    void terminarMiTurno();

    String darNombreDeFase();

    void atacar(PiezaAtacante atacante, Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException;

}