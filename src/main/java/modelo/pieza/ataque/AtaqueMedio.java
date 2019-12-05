package modelo.pieza.ataque;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;

import java.util.List;

public class AtaqueMedio implements IModoAtaque{

    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza otraUnidad) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        otraUnidad.recibirPenalizacion();
        int distancia = miUnidad.getDistanciaAOtraPieza(otraUnidad);
        // modelar distancia como entidad para cubrir cada distancia
        if (distancia < 3 || distancia > 5){throw new DistanciaDeAtaqueInvalidaException();}
        otraUnidad.recibirDanio(miUnidad.getDanioMedio());
    }


}
