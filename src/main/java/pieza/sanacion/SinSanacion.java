package pieza.sanacion;

public class SinSanacion implements IModoSanacion {
    /* No puede recibir vida */
    @Override
    public int restaurarPuntosDeVida(int vida) throws UnidadNoSePuedeCurar {
        throw new UnidadNoSePuedeCurar();
    }
}
