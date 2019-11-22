package pieza.ataque;

import pieza.Pieza;
import pieza.UnidadEstaMuertaException;

public class AtaqueADistancia implements IModoAtaque {
    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza otraUnidad, int distancia) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        if (distancia < 6 || distancia > 20){throw new DistanciaDeAtaqueInvalidaException();}
        otraUnidad.recibirDanio(miUnidad.getDanioDistancia());
    }

    @Override
    public void setModoAtaque(IModoAtaque modoAtaque) {

    }
}
