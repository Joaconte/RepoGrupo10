package fiuba.algo3.TP2.model;

public class Curandero extends UnidadViva {
    static final int COSTO = 2;
    static final int PUNTOS_DE_CURACION = 15;
    private int curacion;

    public Curandero(){
        VIDA_INICIAL = 75;
        costo = COSTO;
        vida = VIDA_INICIAL;
        curacion = PUNTOS_DE_CURACION;
    }


}
