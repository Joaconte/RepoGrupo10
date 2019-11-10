package fiuba.algo3.TP2.model;

public class Infanteria extends PiezaAtacante {
    static final int COSTO = 1;
    static final int VIDA_MAXIMA = 100;
    static final int DANIO_MELE = 10;
    static final int DANIO_DISTANCIA = 0;

    public Infanteria(){
        super.setVida_Maxima(VIDA_MAXIMA);
        super.setVida(VIDA_MAXIMA);
        super.setCosto(COSTO);
        super.enZonaAliada();
        super.puedeCurarse();
        super.setModoAtaqueMele();
        super.setDanioMele(DANIO_MELE);
        super.setDanioADistancia(DANIO_DISTANCIA);
    }

}
