package partida.ataques;

import jugador.Jugador;
import pieza.Pieza;
import pieza.tipos.Catapulta;
import pieza.tipos.Infanteria;
import pieza.tipos.Jinete;

public class RangoMedio implements RangoDeAtaque{


    @Override
    public void atacar(Catapulta atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException {
        throw new PiezaAtacadaEnRangoIncorrectoException();
    }

    @Override
    public void atacar(Infanteria atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException {
        throw new PiezaAtacadaEnRangoIncorrectoException();
    }

    @Override
    public void atacar(Jinete atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException,JineteAsediadoException {
        if (atacante.estaAsediado){ throw new JineteAsediadoException();}
        atacante.setModoAtaqueMedio();
        atacante.atacar(atacada);
    }

}