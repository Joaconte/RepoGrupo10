package modelo.pieza.recibirDanio;

public class DanioZonaEnemiga implements ICalculadorDeDanio {
    private double plusDanio = 1.05;
    @Override
    public double danio(double danioBase) {
        return (danioBase*plusDanio);
    }
}
