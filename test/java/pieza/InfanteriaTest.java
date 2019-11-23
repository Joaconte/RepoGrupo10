package pieza;

import org.junit.Test;
import pieza.ataque.DistanciaDeAtaqueInvalidaException;
import pieza.ataque.PiezaAliadaNoAtacableException;
import pieza.tipos.Infanteria;
import tablero.Tablero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.mockito.Mockito;
import org.mockito.Mock;

public class InfanteriaTest {

    @Test
    public void test00InfanteriaDelEjercito2DevuelveElNumeroDeEjercitoCorrectamente() {
        Infanteria soldado = new Infanteria(2,19,19);
        assertEquals(2, soldado.getEquipo());
    }

    @Test
    public void test01InfanteriaTieneCosto1() {
        Infanteria soldado = new Infanteria(1,2,2);
        assertEquals(1, soldado.getCosto());
    }

    @Test
    public void test02InfanteriaTiene100DeVidaAlIniciar() {
        Infanteria soldado = new Infanteria(1,2,2);
        assertEquals(100, soldado.getPuntosVida(),0);
    }

    @Test
    public void test03InfanteriaRecibe10DeDanio_vida90() throws UnidadEstaMuertaException {
        Infanteria soldado = new Infanteria(1,2,2);
        double vida = soldado.getPuntosVida();
        soldado.recibirDanio(10);
        assertEquals(vida-10, soldado.getPuntosVida(),0);
    }

    @Test
    public void test04InfanteriaRecibe100DeDanio_vida0() throws UnidadEstaMuertaException {
        Infanteria soldado = new Infanteria(1,3,3);
        soldado.recibirDanio(100);
        assertEquals(100-100, soldado.getPuntosVida(),0.05);
    }

    @Test(expected = UnidadEstaMuertaException.class)
    public void test05InfanteriaRecibe101DeDanio_ExceptionUnidadMuerta() throws UnidadEstaMuertaException {
        Infanteria soldado = new Infanteria(2,20,20);
        soldado.recibirDanio(100);
        soldado.recibirDanio(1);
    }

    @Test
    public void test06InfanteriaDeDiferentesEquiposSonEnemigos() {
        Infanteria soldado = new Infanteria(1,2,2);
        Infanteria otroSoldado = new Infanteria(2,12,12);
        assertTrue(soldado.esEnemigo(otroSoldado));
    }

    @Test (expected = PiezaAliadaNoAtacableException.class)
    public void test07InfanteriaDeMismosEquiposNoSeAtacan() throws PiezaAliadaNoAtacableException, DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException {

        Infanteria atacante = new Infanteria(1,2,2);
        Infanteria aliadoAtacado = new Infanteria(1,3,2);

        //--------------Ataque en concreto----------------//
        atacante.atacar(aliadoAtacado, Mockito.mock(Tablero.class));
    }

    @Test
    public void test08InfanteriaDeDistintosEquiposSeAtacanCorrectamente() throws PiezaAliadaNoAtacableException, DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException {


        Infanteria atacante = new Infanteria(1,10,10);
        Infanteria enemigoAtacado = new Infanteria(2,11,11);
        double vidaAntesDelAtaque = enemigoAtacado.getPuntosVida();

        //--------------Ataque en concreto----------------//
        atacante.atacar(enemigoAtacado, Mockito.mock(Tablero.class));
        assertEquals(vidaAntesDelAtaque-10, enemigoAtacado.getPuntosVida(),00);

    }


    @Test (expected= DistanciaDeAtaqueInvalidaException.class)
    public void test09InfanteriaDeDistintosEquiposNoSeAtacanEnDistanciaSuperiorA2Casillas() throws PiezaAliadaNoAtacableException, DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException {

        Infanteria soldado = new Infanteria(1,10,10);
        Infanteria enemigoSoldado = new Infanteria(2,13,13);

        //--------------Ataque en concreto----------------
        soldado.atacar(enemigoSoldado, Mockito.mock(Tablero.class));

    }



}

