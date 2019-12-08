package modelo.pieza.ataque;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;

public class AtaqueADistancia implements IModoAtaque {

    private int danioDeAtaque;
    private RangoEfecto rangoEfecto;

    public AtaqueADistancia(int danioDistancia) {
        danioDeAtaque=danioDistancia;
        rangoEfecto=new RangoEfecto();
    }

    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza otraUnidad) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        otraUnidad.recibirPenalizacion();
        int distancia = miUnidad.getDistanciaAOtraPieza(otraUnidad);
        if (!rangoEfecto.esRangoADistancia(distancia)){throw new DistanciaDeAtaqueInvalidaException();}
        otraUnidad.recibirDanio(danioDeAtaque);
    }

}
