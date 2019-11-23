package pieza.ataque;

import pieza.Pieza;
import pieza.UnidadEstaMuertaException;

import java.util.List;

public class AtaqueVariable implements IModoAtaque {

    private IModoAtaque modoAtaque;

    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza victima, int distancia) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        modoAtaque.atacar(miUnidad,victima,distancia);
    }

    @Override
    public void atacar(PiezaAtacante miUnidad, List<Pieza> piezas, int distancia) throws DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException {
    }

    @Override
    public void setModoAtaque(IModoAtaque modoAtaque){
        this.modoAtaque = modoAtaque;
    }

}
