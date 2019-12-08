package modelo.pieza.ataque;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;

public class AtaqueMedio implements IModoAtaque{

    private int danioDeAtaque;
    private RangoEfecto rangoEfecto;

    public AtaqueMedio(int danioMedio) {
        danioDeAtaque=danioMedio;
        rangoEfecto = new RangoEfecto();
    }

    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza otraUnidad) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        otraUnidad.recibirPenalizacion();
        int distancia = miUnidad.getDistanciaAOtraPieza(otraUnidad);
        if (!rangoEfecto.esRangoMedia(distancia)){throw new DistanciaDeAtaqueInvalidaException();}
        otraUnidad.recibirDanio(danioDeAtaque);
    }


}
