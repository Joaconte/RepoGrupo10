package modelo.pieza.ataque;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;

import java.util.List;

public interface IModoAtaqueMasivo extends IModoAtaque {

    void atacarEnMasa(PiezaAtacante miUnidad, Pieza pieza, List<Pieza> piezas) throws DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException;
}
