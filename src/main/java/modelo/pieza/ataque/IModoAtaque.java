package modelo.pieza.ataque;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;


public interface IModoAtaque {

    void atacar(PiezaAtacante miUnidad, Pieza victima) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException;

}
