package fiuba.algo3.TP2.model;

public class Catapulta extends Unidad implements IAtacanteDistanciaLejana{
    static final int COSTO = 5;
    static final int DANIO = 20;

    public Catapulta(){
        VIDA_INICIAL = 50;
        costo = COSTO;
        vida = VIDA_INICIAL;
    }

    @Override
    public void atacarDesdeLejos(Unidad oponente) {
        oponente.recibirDanio(DANIO);
    }
}
