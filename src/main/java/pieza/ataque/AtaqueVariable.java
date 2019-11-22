package pieza.ataque;

import pieza.Pieza;
import pieza.UnidadEstaMuertaException;

public class AtaqueVariable implements IModoAtaque {

    private IModoAtaque modoAtaque;

    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza victima, int distancia) throws UnidadEstaMuertaException {
        modoAtaque.atacar(miUnidad,victima,distancia);
    }

    public void setModoAtaque(IModoAtaque modoAtaque){
        this.modoAtaque = modoAtaque;
    }

}
