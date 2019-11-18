package pieza.ataque;

import pieza.Pieza;

public class AtaqueMedio implements IModoAtaque {

    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza otraUnidad) {
        otraUnidad.recibirDanio(miUnidad.getDanioMedio());
    }
}

