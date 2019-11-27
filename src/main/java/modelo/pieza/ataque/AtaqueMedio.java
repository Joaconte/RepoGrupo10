package modelo.pieza.ataque;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;

import java.util.List;

public class AtaqueMedio implements IModoAtaque{

    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza otraUnidad, int distancia) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        if (distancia < 3 || distancia > 5){throw new DistanciaDeAtaqueInvalidaException();}
        otraUnidad.recibirDanio(miUnidad.getDanioMedio());
    }

    @Override
    public void ataqueMasivo(PiezaAtacante miUnidad, Pieza victima, List<Pieza> piezas, int distancia) throws DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException {

    }

    @Override
    public void setModoAtaque(IModoAtaque modoAtaque) {

    }
}
