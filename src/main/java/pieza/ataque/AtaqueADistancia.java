package pieza.ataque;

import pieza.Pieza;
import pieza.UnidadEstaMuertaException;

public class AtaqueADistancia implements IModoAtaque {
    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza otraUnidad, int distancia) throws UnidadEstaMuertaException {
        otraUnidad.recibirDanio(miUnidad.getDanioDistancia());
    }
}
