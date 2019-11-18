package pieza.tipos;

import pieza.ataque.PiezaAtacante;

public class Catapulta extends PiezaAtacante {
    static final int COSTO = 5;
    static final int VIDA_MAXIMA = 50;
    static final int DANIO_DISTANCIA = 20;
    static final int DANIO_MEDIO = 0;
    static final int DANIO_CUERPO = 0;

    public Catapulta(){
        super.setVida_Maxima(VIDA_MAXIMA);
        super.setVida(VIDA_MAXIMA);
        super.setCosto(COSTO);
        super.enZonaAliada();
        super.noPuedeCurarse();
        super.setModoAtaqueADistancia();
        super.setDanioCuerpoCuerpo(DANIO_CUERPO);
        super.setDanioMedio(DANIO_MEDIO);
        super.setDanioADistancia(DANIO_DISTANCIA);
    }

}
