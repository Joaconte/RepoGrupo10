package fiuba.algo3.TP2.model;

public class Jinete extends UnidadViva implements IAtacanteMele,IAtacanteDistanciaMedia{
    static final int COSTO = 3;
    static final int DANIO = 15;

    public Jinete(){
        VIDA_INICIAL = 100;
        costo = COSTO;
        vida = VIDA_INICIAL;
    }

    @Override
    public void atacar(Unidad oponente) {
        oponente.recibirDanio(5);
    }

    @Override
    public void atacarADistanciaMedia(Unidad oponente) {
        oponente.recibirDanio(DANIO);
    }
}
