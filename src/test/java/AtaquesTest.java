import fiuba.algo3.TP2.model.Infanteria;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AtaquesTest {
    @Test
    public void test01InfanteriaAtacaOponenteYLeResta10Puntos() {
        Infanteria soldado = new Infanteria();
        Infanteria oponente = new Infanteria();
        int vidaOponente;
        soldado.setEquipo(1);
        oponente.setEquipo(2);
        vidaOponente = oponente.getPuntosVida();
        soldado.atacar(oponente);
        assertEquals(vidaOponente-10, oponente.getPuntosVida());
    }
}
