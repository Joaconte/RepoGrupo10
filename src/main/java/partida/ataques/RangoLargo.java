package partida.ataques;

import jugador.Jugador;
import pieza.Pieza;
import pieza.ataque.*;
import pieza.recibirDanio.*;
import pieza.tipos.Catapulta;
import pieza.tipos.Infanteria;
import pieza.tipos.Jinete;

public class RangoLargo implements RangoDeAtaque{


    @Override
    public void atacar(Catapulta atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException {
        atacante.atacar(atacada);
    }

    @Override
    public void atacar(Infanteria atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException {
        throw new PiezaAtacadaEnRangoIncorrectoException();
    }

    @Override
    public void atacar(Jinete atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException,JineteAsediadoException {
        throw new PiezaAtacadaEnRangoIncorrectoException();
    }

}