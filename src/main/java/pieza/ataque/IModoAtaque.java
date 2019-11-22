package pieza.ataque;

import pieza.Pieza;
import pieza.UnidadEstaMuertaException;

public interface IModoAtaque {
    void atacar(PiezaAtacante miUnidad, Pieza victima, int distancia) throws UnidadEstaMuertaException;
}
