package fiuba.algo3.TP2.model;

import fiuba.algo3.TP2.exception.UnidadNoSePuedeCurar;

public class SanacionNormal implements IModoSanacion {
    @Override
    public int restaurarPuntosDeVida(int vida) throws UnidadNoSePuedeCurar {
        return vida;
    }
}
