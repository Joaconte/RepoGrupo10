package pieza.ataque;

import pieza.Pieza;
import pieza.UnidadEstaMuertaException;

import java.util.List;

public class AtaqueCuerpoACuerpo implements IModoAtaque {
    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza otraUnidad, int distancia) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        if (distancia < 1 || distancia > 2){throw new DistanciaDeAtaqueInvalidaException();}
        otraUnidad.recibirDanio(miUnidad.getDanioCuerpoCuerpo());
    }

    @Override
    public void ataqueMasivo(PiezaAtacante miUnidad, Pieza victima, List<Pieza> piezas, int distancia) throws DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException {

    }

    @Override
    public void setModoAtaque(IModoAtaque modoAtaque) {

    }
}
