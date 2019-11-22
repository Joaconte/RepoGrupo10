package pieza;

import org.junit.Test;
import pieza.tipos.Catapulta;
import pieza.tipos.Infanteria;
import pieza.tipos.Jinete;


import static org.junit.Assert.assertEquals;

// se puede mover a cada clase respectiva
public class AtaquesTest {
    @Test
    public void test01InfanteriaAtacaOponenteYLeResta10Puntos() {
        Infanteria soldado = new Infanteria();
        Infanteria oponente = new Infanteria();
        double vidaOponente;
        soldado.setEquipo(1); // mismo equipo. Hace daño a aliados?
        oponente.setEquipo(1);
        vidaOponente = oponente.getPuntosVida();
        soldado.ejecutarUnModoDeAtaque(oponente);
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
        jinete.setModoAtaqueCuerpoCuerpo();
        jinete.ejecutarUnModoDeAtaque(oponente);
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
        jinete.setModoAtaqueMedio();
        jinete.ejecutarUnModoDeAtaque(oponente);
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
        catapulta.ejecutarUnModoDeAtaque(oponente);
        assertEquals(vidaOponente-20, oponente.getPuntosVida(),0.05);
    }
}
