package modelo.pieza.ataque;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;

import java.util.List;

public interface IModoAtaque {
    void atacar(PiezaAtacante miUnidad, Pieza victima, int distancia) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException;
    void ataqueMasivo(PiezaAtacante miUnidad, Pieza victima, List<Pieza> piezas, int distancia) throws DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException;
    void setModoAtaque(IModoAtaque modoAtaque);
}
