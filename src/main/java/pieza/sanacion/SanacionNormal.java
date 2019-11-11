package pieza.sanacion;

public class SanacionNormal implements IModoSanacion {
    @Override
    public int restaurarPuntosDeVida(int vida) throws UnidadNoSePuedeCurar {
        return vida;
    }
}
