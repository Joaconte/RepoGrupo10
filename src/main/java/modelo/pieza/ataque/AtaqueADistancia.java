package modelo.pieza.ataque;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;

import java.util.List;

public class AtaqueADistancia implements IModoAtaque {
    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza otraUnidad, int distancia) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        if (distancia < 6 || distancia > 20){throw new DistanciaDeAtaqueInvalidaException();}
        otraUnidad.recibirDanio(miUnidad.getDanioDistanciaLejana());
    }

    @Override
    public void setModoAtaque(IModoAtaque modoAtaque) {
    }

    @Override
    public void ataqueMasivo(PiezaAtacante miUnidad, Pieza victima, List<Pieza> piezas, int distancia) throws DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException {
        // fijarse de usar stream() como hicieron en otros lados
        double daniaAReplicar = victima.getPuntosVida(); //Cuestiones de enunciado.
        atacar(miUnidad, victima, distancia);
        piezas.remove(0);
        daniaAReplicar = daniaAReplicar - victima.getPuntosVida();
        for (int i=0; i<piezas.size(); i++){
            piezas.get(i).recibirDanio(daniaAReplicar);
        }
    }
}
