package partida.ataques;

import jugador.Jugador;
import pieza.Pieza;
import pieza.ataque.*;
import pieza.recibirDanio.*;
import pieza.tipos.Catapulta;
import pieza.tipos.Infanteria;
import pieza.tipos.Jinete;

public class RangoMedio implements RangoDeAtaque{


    @Override
    public void atacar(Catapulta atacante, Pieza atacada, Jugador jugadorEnTurno) throws PiezaAtacadaEnRangoIncorrectoException {
        throw new PiezaAtacadaEnRangoIncorrectoException();
    }

    @Override
    public void atacar(Infanteria atacante, Pieza atacada, Jugador jugadorEnTurno) throws PiezaAtacadaEnRangoIncorrectoException {
        throw new PiezaAtacadaEnRangoIncorrectoException();
    }

    @Override
    public void atacar(Jinete atacante, Pieza atacada, Jugador jugadorEnTurno) throws PiezaAtacadaEnRangoIncorrectoException {

    }

    @Override
    public void setDanio(Pieza atacante, Pieza atacada, Jugador jugadorEnTurno) {

    }
}