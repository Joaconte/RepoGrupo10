package partida.ataques;

import jugador.Jugador;
import pieza.tipos.*;
import pieza.Pieza;

public interface RangoDeAtaque {

    void atacar(Catapulta atacante, Pieza atacada, Jugador jugadorEnTurno) throws PiezaAtacadaEnRangoIncorrectoException;
    void atacar(Infanteria atacante, Pieza atacada, Jugador jugadorEnTurno) throws PiezaAtacadaEnRangoIncorrectoException;
    void atacar(Jinete atacante, Pieza atacada, Jugador jugadorEnTurno) throws PiezaAtacadaEnRangoIncorrectoException;
    void setDanio(Pieza atacante, Pieza atacada, Jugador jugadorEnTurno);
}