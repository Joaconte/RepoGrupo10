package modelo.pieza.ataque;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;


public class AtaqueCuerpoACuerpo implements IModoAtaque {
    private int danioDeAtaque;
    private RangoEfecto rangoEfecto;

    public AtaqueCuerpoACuerpo(int danioCuerpo) {
        this.danioDeAtaque=danioCuerpo;
        this.rangoEfecto = new RangoEfecto();
    }

    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza otraUnidad) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        otraUnidad.recibirPenalizacion();
        int distancia = miUnidad.getDistanciaAOtraPieza(otraUnidad);
        if (!rangoEfecto.esRangoCuerpoCuerpo(distancia)){throw new DistanciaDeAtaqueInvalidaException();}
        otraUnidad.recibirDanio(danioDeAtaque);
    }

}
