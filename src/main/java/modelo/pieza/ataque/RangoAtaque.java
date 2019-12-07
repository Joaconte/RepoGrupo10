package modelo.pieza.ataque;


public class RangoAtaque {


    static final int INICIO_RANGO_CUERPO_CUERPO = 1;
    static final int INICIO_RANGO_MEDIO = 3;
    static final int INICIO_RANGO_A_DISTANCIA = 6;
    static final int INICIO_FUERA_DE_RANGO = 21;

    private int distancia;

    public RangoAtaque(int distancia){
        this.distancia = distancia;
    }

    public boolean esRangoCuerpoCuerpo(){
        return distancia >= INICIO_RANGO_CUERPO_CUERPO && distancia<INICIO_RANGO_MEDIO;
    }

    public boolean esRangoMedia(){
        return distancia >= INICIO_RANGO_MEDIO && distancia<INICIO_RANGO_A_DISTANCIA;
    }

    public boolean esRangoADistancia(){
        return distancia >= INICIO_RANGO_A_DISTANCIA && distancia<INICIO_FUERA_DE_RANGO;
    }

}
