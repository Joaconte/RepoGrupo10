package partida.ataques;

import jugador.Jugador;
import pieza.tipos.*;
import pieza.Pieza;

public interface RangoDeAtaque {

    void atacar(Catapulta atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException;
    void atacar(Infanteria atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException;
    void atacar(Jinete atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException,JineteAsediadoException, JineteNoAsediadoException;

}