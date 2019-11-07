package fiuba.algo3.TP2.model;

public class Infanteria extends UnidadViva implements IAtacanteMele {
    static final int COSTO = 1;
    static final int DANIO = 10;

    public Infanteria(){
        VIDA_INICIAL = 100;
        costo = COSTO;
        vida = VIDA_INICIAL;
    }

    @Override
    public void atacar(Unidad oponente) {
        oponente.recibirDanio(DANIO);
    }
}
