package fiuba.algo3.TP2;

public class Jugador {
    static final int PUNTOS_INICIALES = 20;
    private int puntos;

    public Jugador(){
        puntos = PUNTOS_INICIALES;
    }

    public int getPuntos() {
        return puntos;
    }

    public void descontarPuntos(int i) {
        puntos-=i;
    }
}
