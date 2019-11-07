package fiuba.algo3.TP2.model;

public class Infanteria extends UnidadViva implements IAtacante{
    static final int COSTO = 1;

    public Infanteria(){
        VIDA_INICIAL = 100;
        costo = COSTO;
        vida = VIDA_INICIAL;
    }

    @Override
    public void atacar(Unidad oponente) {
        oponente.recibirDanio(10);
    }
}
