package fiuba.algo3.TP2.model;

public class AtaqueADistancia implements IModoAtaque {
    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza otraUnidad) {
        otraUnidad.recibirDanio(miUnidad.getDanioDistancia());

    }
}
