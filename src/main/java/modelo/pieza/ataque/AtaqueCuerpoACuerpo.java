package modelo.pieza.ataque;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;


public class AtaqueCuerpoACuerpo implements IModoAtaque {
    private int danioDeAtaque;
    public AtaqueCuerpoACuerpo(int danioCuerpo) {
        this.danioDeAtaque=danioCuerpo;
    }

    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza otraUnidad) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        otraUnidad.recibirPenalizacion();
        int distancia = miUnidad.getDistanciaAOtraPieza(otraUnidad);
        RangoAtaque rangoAtaque = new RangoAtaque(distancia);
        if (!rangoAtaque.esRangoCuerpoCuerpo()){throw new DistanciaDeAtaqueInvalidaException();}
        otraUnidad.recibirDanio(danioDeAtaque);
    }

}
