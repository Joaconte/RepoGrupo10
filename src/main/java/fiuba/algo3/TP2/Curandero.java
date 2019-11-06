package fiuba.algo3.TP2;

public class Curandero extends Unidad {
    static final int COSTO = 2;
    static final int VIDA_INICIAL = 75;
    static final int PUNTOS_DE_CURACION = 15;
    private int curacion;

    public Curandero(){
        costo = COSTO;
        vida = VIDA_INICIAL;
        curacion = PUNTOS_DE_CURACION;
    }


}
