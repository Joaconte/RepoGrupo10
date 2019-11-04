package fiuba.algo3.TP2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class JugadorTest {


    @Test
    public void test01JugadorRecienCreadoTiene20PuntosParaGastar() {
        Jugador jugador = new Jugador();
        assertEquals(20, jugador.getPuntos());
    }

    @Test
    public void test02LeResto10PuntosAlJugador() {
        Jugador jugador = new Jugador();
        jugador.descontarPuntos(10);
        assertEquals(20-10, jugador.getPuntos());
    }

}
