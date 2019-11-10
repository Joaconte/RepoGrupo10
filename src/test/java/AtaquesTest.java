import fiuba.algo3.TP2.model.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AtaquesTest {
    @Test
    public void test01InfanteriaAtacaOponenteYLeResta10Puntos() {
        Infanteria soldado = new Infanteria();
        Infanteria oponente = new Infanteria();
        double vidaOponente;
        soldado.setEquipo(1);
        oponente.setEquipo(2);
        vidaOponente = oponente.getPuntosVida();
        soldado.atacar(oponente);
        assertEquals(vidaOponente-10, oponente.getPuntosVida(),0.05);
    }

    @Test
    public void test02JineteAtacaOponenteCuerpoACuerpoYLeResta5Puntos() {
        Jinete jinete = new Jinete();
        Infanteria oponente = new Infanteria();
        double vidaOponente;
        jinete.setEquipo(1);
        oponente.setEquipo(2);
        vidaOponente = oponente.getPuntosVida();
        jinete.atacar(oponente);
        assertEquals(vidaOponente-5, oponente.getPuntosVida(),0.05);
    }

    @Test
    public void test03JineteAtacaOponenteADistanciaYLeResta15Puntos() {
        Jinete jinete = new Jinete();
        Infanteria oponente = new Infanteria();
        double vidaOponente;
        jinete.setEquipo(1);
        oponente.setEquipo(2);
        vidaOponente = oponente.getPuntosVida();
        jinete.setModoAtaqueADistancia();
        jinete.atacar(oponente);
        assertEquals(vidaOponente-15, oponente.getPuntosVida(),0.05);
    }

    @Test
    public void test04CatapultaAtacaOponenteYLeResta20Puntos() {
        Catapulta catapulta = new Catapulta();
        Infanteria oponente = new Infanteria();
        double vidaOponente;
        catapulta.setEquipo(1);
        oponente.setEquipo(2);
        vidaOponente = oponente.getPuntosVida();
        catapulta.atacar(oponente);
        assertEquals(vidaOponente-20, oponente.getPuntosVida(),0.05);
    }
}
