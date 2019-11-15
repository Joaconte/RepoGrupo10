package pieza.tipos;

import pieza.ataque.PiezaAtacante;

public class Infanteria extends PiezaAtacante {
    static final int COSTO = 1;
    static final int VIDA_MAXIMA = 100;
    static final int DANIO_CUERPO = 10;
    static final int DANIO_MEDIO = 0;
    static final int DANIO_DISTANCIA = 0;

    public Infanteria(){
        super.setVida_Maxima(VIDA_MAXIMA);
        super.setVida(VIDA_MAXIMA);
        super.setCosto(COSTO);
        super.enZonaAliada();
        super.puedeCurarse();
        super.setModoAtaqueCuerpoCuerpo();
        super.setDanioCuerpoCuerpo(DANIO_CUERPO);
        super.setDanioMedio(DANIO_MEDIO);
        super.setDanioADistancia(DANIO_DISTANCIA);
    }

}
