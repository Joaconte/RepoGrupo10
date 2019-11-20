package partida.fase;

import jugador.Jugador;
import partida.ataques.JineteAsediadoException;
import partida.ataques.JineteNoAsediadoException;
import partida.ataques.PiezaAtacadaEnRangoIncorrectoException;
import pieza.Pieza;
import pieza.tipos.Catapulta;
import pieza.tipos.Infanteria;
import pieza.tipos.Jinete;

public interface FaseDePartida{

    //Metodos abstractos implementados por las subclases

    public void moverUnidadEnTablero(Pieza pieza, int numeroFila, int numeroColumna);
    public void terminarMiTurno();
    public String darNombreDeFase();
    void atacar(Infanteria atacante, Pieza atacada, Jugador jugadorEnTurno) throws PiezaAtacadaEnRangoIncorrectoException;
    void atacar(Catapulta atacante, Pieza atacada, Jugador jugadorEnTurno) throws PiezaAtacadaEnRangoIncorrectoException;
    void atacar(Jinete atacante, Pieza atacada, Jugador jugadorEnTurno) throws PiezaAtacadaEnRangoIncorrectoException, JineteAsediadoException, JineteNoAsediadoException;

    }