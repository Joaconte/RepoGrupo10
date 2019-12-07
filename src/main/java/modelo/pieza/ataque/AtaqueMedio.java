package modelo.pieza.ataque;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;

public class AtaqueMedio implements IModoAtaque{

    private int danioDeAtaque;
    public AtaqueMedio(int danioMedio) {
        danioDeAtaque=danioMedio;
    }

    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza otraUnidad) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        otraUnidad.recibirPenalizacion();
        int distancia = miUnidad.getDistanciaAOtraPieza(otraUnidad);
        RangoAtaque rangoAtaque = new RangoAtaque(distancia);
        if (!rangoAtaque.esRangoMedia()){throw new DistanciaDeAtaqueInvalidaException();}
        otraUnidad.recibirDanio(danioDeAtaque);
    }


}
