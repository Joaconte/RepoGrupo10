package fiuba.algo3.TP2.model;

import fiuba.algo3.TP2.exception.UnidadNoSePuedeCurar;

public interface IModoSanacion {
    public int restaurarPuntosDeVida(int vida) throws UnidadNoSePuedeCurar;
}
