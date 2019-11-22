package partida.fase;

import jugador.Jugador;
import jugador.PiezaFueraDeSectorException;
import pieza.tipos.JineteNoAsediadoException;
import pieza.Pieza;
import pieza.tipos.Catapulta;
import pieza.tipos.Infanteria;
import pieza.tipos.Jinete;
import tablero.Tablero;

public interface FaseDePartida{

    //Metodos abstractos implementados por las subclases

    void moverUnidadEnTablero(Pieza pieza, int numeroFila, int numeroColumna);

    void terminarMiTurno();

    String darNombreDeFase();

    void atacar(Pieza atacante, Pieza atacada, Tablero tablero);

    void agregarNuevaUbicacionAFicha(Jugador jugadorEnTurno, Pieza pieza, int posicionX, int posicionY) throws PiezaFueraDeSectorException;

}