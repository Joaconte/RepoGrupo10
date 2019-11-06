package fiuba.algo3.TP2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class InfanteriaTest {
    @Test
    public void test01InfanteriaTieneCosto1() {
        Infanteria soldado = new Infanteria();
        assertEquals(1, soldado.getCosto());
    }

    @Test
    public void test02InfanteriaTiene100DeVidaAlIniciar() {
        Infanteria soldado = new Infanteria();
        assertEquals(100, soldado.getPuntosVida());
    }

    @Test
    public void test03InfanteriaRecibe10DeDanio_vida90() {
        Infanteria soldado = new Infanteria();
        soldado.recibirDanio(10);
        assertEquals(100-10, soldado.getPuntosVida());
    }

    @Test
    public void test04InfanteriaRecibe100DeDanio_vida0() {
        Infanteria soldado = new Infanteria();
        soldado.recibirDanio(100);
        assertEquals(100-100, soldado.getPuntosVida());
    }

    @Test(expected = UnidadEstaMuertaException.class)
    public void test05InfanteriaRecibe101DeDanio_ExceptionUnidadMuerta() {
        Infanteria soldado = new Infanteria();
        soldado.recibirDanio(100);
        soldado.recibirDanio(1);
    }

}
