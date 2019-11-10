package fiuba.algo3.TP2.model;

import fiuba.algo3.TP2.exception.UnidadNoSePuedeCurar;

public class SinSanacion implements IModoSanacion {
    /* No puede recibir vida */
    @Override
    public int restaurarPuntosDeVida(int vida) throws UnidadNoSePuedeCurar {
        throw new UnidadNoSePuedeCurar();
    }
}
