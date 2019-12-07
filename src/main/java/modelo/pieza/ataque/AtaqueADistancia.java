package modelo.pieza.ataque;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;

public class AtaqueADistancia implements IModoAtaque {

    private int danioDeAtaque;
    public AtaqueADistancia(int danioDistancia) {
        danioDeAtaque=danioDistancia;
    }

    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza otraUnidad) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        otraUnidad.recibirPenalizacion();
        int distancia = miUnidad.getDistanciaAOtraPieza(otraUnidad);

        RangoAtaque rangoAtaque = new RangoAtaque(distancia);

        if (!rangoAtaque.esRangoADistancia()){throw new DistanciaDeAtaqueInvalidaException();}
        otraUnidad.recibirDanio(danioDeAtaque);
    }

}
