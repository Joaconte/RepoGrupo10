package pieza.ataque;

import pieza.Pieza;
import pieza.UnidadEstaMuertaException;

public class AtaqueMedio implements IModoAtaque{

    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza otraUnidad, int distancia) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        if (distancia < 3 || distancia > 5){throw new DistanciaDeAtaqueInvalidaException();}
        otraUnidad.recibirDanio(miUnidad.getDanioMedio());
    }

    @Override
    public void setModoAtaque(IModoAtaque modoAtaque) {

    }
}
