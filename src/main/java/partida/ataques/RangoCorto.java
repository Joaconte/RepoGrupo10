package partida.ataques;

import pieza.Pieza;
import pieza.tipos.Catapulta;
import pieza.tipos.Infanteria;
import pieza.tipos.Jinete;

public class RangoCorto implements RangoDeAtaque{


    @Override
    public void atacar(Catapulta atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException {
        throw new PiezaAtacadaEnRangoIncorrectoException();
    }

    @Override
    public void atacar(Infanteria atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException {
        atacante.setModoAtaqueCuerpoCuerpo();
        atacante.atacar(atacada);
    }

    @Override
    public void atacar(Jinete atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException,JineteNoAsediadoException {
        if (!atacante.esAsediado()){ throw new JineteNoAsediadoException();}
        atacante.setModoAtaqueCuerpoCuerpo();
        atacante.atacar(atacada);
        atacante.setearEstados();
    }


}