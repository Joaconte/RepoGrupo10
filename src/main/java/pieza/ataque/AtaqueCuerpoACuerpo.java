package pieza.ataque;

import pieza.Pieza;
import pieza.UnidadEstaMuertaException;

public class AtaqueCuerpoACuerpo implements IModoAtaque {
    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza otraUnidad, int distancia) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        if (distancia < 1 || distancia > 3){throw new DistanciaDeAtaqueInvalidaException();}
        otraUnidad.recibirDanio(miUnidad.getDanioCuerpoCuerpo());
    }

    @Override
    public void setModoAtaque(IModoAtaque modoAtaque) {

    }
}
