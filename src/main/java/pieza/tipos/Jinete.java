package pieza.tipos;

import pieza.ataque.PiezaAtacante;

public class Jinete extends PiezaAtacante {
    static final int COSTO = 3;
    static final int VIDA_MAXIMA = 100;
    static final int DANIO_CUERPO = 5;
    static final int DANIO_MEDIO = 15;
    static final int DANIO_DISTANCIA = 0;

    public Jinete() {
        super.setVida_Maxima(VIDA_MAXIMA);
        super.setVida(VIDA_MAXIMA);
        super.setCosto(COSTO);
        super.enZonaAliada();
        super.puedeCurarse();
        super.setModoAtaqueCuerpoCuerpo();
        super.setModoAtaqueMedio();
        super.setDanioCuerpoCuerpo(DANIO_CUERPO);
        super.setDanioMedio(DANIO_MEDIO);
        super.setDanioADistancia(DANIO_DISTANCIA);
    }
}
