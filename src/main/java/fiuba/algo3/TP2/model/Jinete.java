package fiuba.algo3.TP2.model;

public class Jinete extends PiezaAtacante{
    static final int COSTO = 3;
    static final int VIDA_MAXIMA = 100;
    static final int DANIO_MELE = 5;
    static final int DANIO_DISTANCIA = 15;

    public Jinete(){
        super.setVida_Maxima(VIDA_MAXIMA);
        super.setVida(VIDA_MAXIMA);
        super.setCosto(COSTO);
        super.enZonaAliada();
        super.puedeCurarse();
        super.setModoAtaqueMele();
        super.setDanioMele(DANIO_MELE);
        super.setDanioADistancia(DANIO_DISTANCIA);
    }
;
}
