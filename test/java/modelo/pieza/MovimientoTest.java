package modelo.pieza;

import modelo.pieza.Ubicacion;
import modelo.pieza.movimiento.*;
import modelo.pieza.tipos.*;
import org.junit.Test;
import modelo.pieza.movimiento.NoSePuedeMoverException;
import modelo.tablero.Tablero;

import static org.junit.Assert.*;

public class MovimientoTest {
    /*
    @Test
    public void testJineteEn2x1y_SeMueveArriba_quedaEn2x0y() throws NoSePuedeMoverException {
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete(1,2,1);
        tablero.ocuparCasilla(jinete,2,1);

        jinete.mover(tablero, new Arriba());
        assertEquals(2, jinete.getUbicacion().getPosicionEnX());
        assertEquals(0, jinete.getUbicacion().getPosicionEnY());
    }

    @Test(expected = NoSePuedeMoverException.class)
    public void testCatapultaNoSePuedeMover() throws NoSePuedeMoverException {
        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta(1,2,2);
        catapulta.mover(tablero, new Abajo());
    }

    @Test(expected = NoSePuedeMoverException.class)
    public void testPiezaNoSePuedeMoverACasillaOcupada() throws NoSePuedeMoverException {
        Tablero tablero = new Tablero();
        Infanteria soldado = new Infanteria(1,1,1);
        tablero.ocuparCasilla(soldado,1,1);
        Infanteria soldado2 = new Infanteria(1,1,2);
        soldado2.mover(tablero, new Arriba());
    }

    @Test
    public void testCasillaOcupadaConPiezaMovida() throws NoSePuedeMoverException {
        Tablero tablero = new Tablero();
        assertFalse(tablero.casillaEstaOcupada(1,1));

        Infanteria soldado =  new Infanteria(1,1,2);
        tablero.ocuparCasilla(soldado,1,2);
        assertTrue(tablero.casillaEstaOcupada(1,2));

        soldado.mover(tablero, new Arriba());
        assertTrue(tablero.casillaEstaOcupada(1,1));
        assertFalse(tablero.casillaEstaOcupada(1,2));
    }

    // ----------------- BATALLON ----------------//

    @Test
    public void testBatallonEstaEnLaFila2_SeMueveParaAbajoYQuedanTodosEnLaFila3() throws NoSePuedeMoverException, BatallonDisueltoException {
        Tablero tablero = new Tablero();
        Infanteria soldado1 = new Infanteria(1,1,2);
        tablero.ocuparCasilla(soldado1,1,2);
        Infanteria soldado2 = new Infanteria(1,2,2);
        tablero.ocuparCasilla(soldado2,2,2);
        Infanteria soldado3 = new Infanteria(1,3,2);
        tablero.ocuparCasilla(soldado3,3,2);

        assertEquals(2, soldado1.getUbicacion().getPosicionEnY());
        assertEquals(2, soldado2.getUbicacion().getPosicionEnY());
        assertEquals(2, soldado3.getUbicacion().getPosicionEnY());

        Batallon soldados = new Batallon(soldado1, soldado2, soldado3);
        soldados.mover(tablero, new Abajo());

        assertEquals(3, soldado1.getUbicacion().getPosicionEnY());
        assertEquals(3, soldado2.getUbicacion().getPosicionEnY());
        assertEquals(3, soldado3.getUbicacion().getPosicionEnY());
    }

    @Test
    public void testBatallonEstaEnLaFila2_SeMueveParaArribaQuedandoTodosEnLaFila1() throws NoSePuedeMoverException, BatallonDisueltoException {
        Tablero tablero = new Tablero();
        Infanteria soldado1 = new Infanteria(1,1,2);
        tablero.ocuparCasilla(soldado1,1,2);
        Infanteria soldado2 = new Infanteria(1,2,2);
        tablero.ocuparCasilla(soldado2,2,2);
        Infanteria soldado3 = new Infanteria(1,3,2);
        tablero.ocuparCasilla(soldado3,3,2);

        assertEquals(2, soldado1.getUbicacion().getPosicionEnY());
        assertEquals(2, soldado2.getUbicacion().getPosicionEnY());
        assertEquals(2, soldado3.getUbicacion().getPosicionEnY());

        Batallon soldados = new Batallon(soldado1, soldado2, soldado3);
        soldados.mover(tablero, new Arriba());

        assertEquals(1, soldado1.getUbicacion().getPosicionEnY());
        assertEquals(1, soldado2.getUbicacion().getPosicionEnY());
        assertEquals(1, soldado3.getUbicacion().getPosicionEnY());
    }

    @Test
    public void testBatallonEstaEnLaFila2_SeMuevenParaDerechaYTodosSeDesplazan1ALaDerecha() throws NoSePuedeMoverException, BatallonDisueltoException {
        Tablero tablero = new Tablero();
        Infanteria soldado1 = new Infanteria(1,1,2);
        tablero.ocuparCasilla(soldado1,1,2);
        Infanteria soldado2 = new Infanteria(1,2,2);
        tablero.ocuparCasilla(soldado2,2,2);
        Infanteria soldado3 = new Infanteria(1,3,2);
        tablero.ocuparCasilla(soldado3,3,2);


        Batallon soldados = new Batallon(soldado1, soldado2, soldado3);
        soldados.mover(tablero, new Derecha());

        assertEquals(2, soldado1.getUbicacion().getPosicionEnY());

        assertEquals(2,soldado1.getUbicacion().getPosicionEnX());
        assertEquals(3, soldado2.getUbicacion().getPosicionEnX());
        assertEquals(4, soldado3.getUbicacion().getPosicionEnX());
    }

    @Test
    public void testBatallonEstaEnLaFila2_SeMuevenParaIzquierdaYTodosRestan1EnX() throws NoSePuedeMoverException, BatallonDisueltoException {
        Tablero tablero = new Tablero();
        Infanteria soldado1 = new Infanteria(1,1,2);
        tablero.ocuparCasilla(soldado1,1,2);
        Infanteria soldado2 = new Infanteria(1,2,2);
        tablero.ocuparCasilla(soldado2,2,2);
        Infanteria soldado3 = new Infanteria(1,3,2);
        tablero.ocuparCasilla(soldado3,3,2);


        Batallon soldados = new Batallon(soldado1, soldado2, soldado3);
        soldados.mover(tablero, new Izquierda());

        assertEquals(2, soldado1.getUbicacion().getPosicionEnY());

        assertEquals(0,soldado1.getUbicacion().getPosicionEnX());
        assertEquals(1, soldado2.getUbicacion().getPosicionEnX());
        assertEquals(2, soldado3.getUbicacion().getPosicionEnX());
    }

    @Test
    public void testBatallonEstaEnLaColumna2_SeMueveParaIzquierdaQuedandoTodosEnLaColumna() throws NoSePuedeMoverException, BatallonDisueltoException {
        Tablero tablero = new Tablero();
        Infanteria soldado1 = new Infanteria(1,2,2);
        tablero.ocuparCasilla(soldado1,2,2);
        Infanteria soldado2 = new Infanteria(1,2,3);
        tablero.ocuparCasilla(soldado2,2,3);
        Infanteria soldado3 = new Infanteria(1,2,4);
        tablero.ocuparCasilla(soldado3,2,4);

        assertEquals(2, soldado1.getUbicacion().getPosicionEnX());
        assertEquals(2, soldado2.getUbicacion().getPosicionEnX());
        assertEquals(2, soldado3.getUbicacion().getPosicionEnX());

        Batallon soldados = new Batallon(soldado1, soldado2, soldado3);
        soldados.mover(tablero, new Izquierda());

        assertEquals(1, soldado1.getUbicacion().getPosicionEnX());
        assertEquals(1, soldado2.getUbicacion().getPosicionEnX());
        assertEquals(1, soldado3.getUbicacion().getPosicionEnX());
    }

    @Test
    public void testBatallonEn3x3y_2x2y_4x4y_SeMuevenArribaIzquierda_resta1ACadaPosicion() throws NoSePuedeMoverException, BatallonDisueltoException {
        Tablero tablero = new Tablero();
        Infanteria soldado1 = new Infanteria(1,3,3);
        tablero.ocuparCasilla(soldado1,2,2);
        Infanteria soldado2 = new Infanteria(1,2,2);
        tablero.ocuparCasilla(soldado2,3,3);
        Infanteria soldado3 = new Infanteria(1,4,4);
        tablero.ocuparCasilla(soldado3,4,4);

        Batallon soldados = new Batallon(soldado1, soldado2, soldado3);
        soldados.mover(tablero, new ArribaIzquierda());

        assertEquals(2, soldado1.getUbicacion().getPosicionEnX());
        assertEquals(2, soldado1.getUbicacion().getPosicionEnY());

        assertEquals(1, soldado2.getUbicacion().getPosicionEnX());
        assertEquals(1, soldado2.getUbicacion().getPosicionEnY());

        assertEquals(3, soldado3.getUbicacion().getPosicionEnX());
        assertEquals(3, soldado3.getUbicacion().getPosicionEnY());

    }

    @Test
    public void testBatallonEn2x2y_3x3y_4x4y_SeMuevenAbajoDerecha_suma1ACadaPosicion() throws NoSePuedeMoverException, BatallonDisueltoException {
        Tablero tablero = new Tablero();
        Infanteria soldado1 = new Infanteria(1,2,2);
        tablero.ocuparCasilla(soldado1,2,2);
        Infanteria soldado2 = new Infanteria(1,3,3);
        tablero.ocuparCasilla(soldado2,3,3);
        Infanteria soldado3 = new Infanteria(1,4,4);
        tablero.ocuparCasilla(soldado3,4,4);

        Batallon soldados = new Batallon(soldado1, soldado2, soldado3);
        soldados.mover(tablero, new AbajoDerecha());

        assertEquals(3, soldado1.getUbicacion().getPosicionEnX());
        assertEquals(3, soldado1.getUbicacion().getPosicionEnY());

        assertEquals(4, soldado2.getUbicacion().getPosicionEnX());
        assertEquals(4, soldado2.getUbicacion().getPosicionEnY());

        assertEquals(5, soldado3.getUbicacion().getPosicionEnX());
        assertEquals(5, soldado3.getUbicacion().getPosicionEnY());

    }

    @Test
    public void testBatallonEn2x2y_3x2y_2x3y_SeMuevenAbajoIzquierda_resta1EnX_suma1EnY() throws NoSePuedeMoverException, BatallonDisueltoException {
        Tablero tablero = new Tablero();
        Infanteria soldado1 = new Infanteria(1,2,2);
        tablero.ocuparCasilla(soldado1,2,2);
        Infanteria soldado2 = new Infanteria(1,3,2);
        tablero.ocuparCasilla(soldado2,3,2);
        Infanteria soldado3 = new Infanteria(1,2,3);
        tablero.ocuparCasilla(soldado3,2,3);

        Batallon soldados = new Batallon(soldado1, soldado2, soldado3);
        soldados.mover(tablero, new AbajoIzquierda());

        assertEquals(1, soldado1.getUbicacion().getPosicionEnX());
        assertEquals(3, soldado1.getUbicacion().getPosicionEnY());

        assertEquals(2, soldado2.getUbicacion().getPosicionEnX());
        assertEquals(3, soldado2.getUbicacion().getPosicionEnY());

        assertEquals(1, soldado3.getUbicacion().getPosicionEnX());
        assertEquals(4, soldado3.getUbicacion().getPosicionEnY());

    }

    @Test
    public void testBatallonEn2x2y_3x2y_2x3y_ObstaculoEn3x3y_MovimientoAbajoDerecha_2x2yQuedaIgual() throws NoSePuedeMoverException, BatallonDisueltoException {
        Tablero tablero = new Tablero();
        Infanteria soldado1 = new Infanteria(1,2,2);
        tablero.ocuparCasilla(soldado1,2,2);
        Infanteria soldado2 = new Infanteria(1,3,2);
        tablero.ocuparCasilla(soldado2,3,2);
        Infanteria soldado3 = new Infanteria(1,2,3);
        tablero.ocuparCasilla(soldado3,2,3);

        Catapulta obstaculo = new Catapulta(1,3,3);
        tablero.ocuparCasilla(obstaculo,3,3);

        Batallon soldados = new Batallon(soldado1, soldado2, soldado3);
        soldados.mover(tablero, new AbajoDerecha());

        assertEquals(2, soldado1.getUbicacion().getPosicionEnX());
        assertEquals(2, soldado1.getUbicacion().getPosicionEnY());

        assertEquals(4, soldado2.getUbicacion().getPosicionEnX());
        assertEquals(3, soldado2.getUbicacion().getPosicionEnY());

        assertEquals(3, soldado3.getUbicacion().getPosicionEnX());
        assertEquals(4, soldado3.getUbicacion().getPosicionEnY());
    }

    @Test
    public void testDisolverBatallonEn2x2y_3x2y_2x3y_ObstaculoEn3x3y_MovimientoAbajoDerecha_2x2yNoSeMueve_SeDisuelveBatallon() throws NoSePuedeMoverException, BatallonDisueltoException {
        Tablero tablero = new Tablero();
        Infanteria soldado1 = new Infanteria(1,2,2);
        tablero.ocuparCasilla(soldado1,2,2);
        Infanteria soldado2 = new Infanteria(1,3,2);
        tablero.ocuparCasilla(soldado2,3,2);
        Infanteria soldado3 = new Infanteria(1,2,3);
        tablero.ocuparCasilla(soldado3,2,3);

        Catapulta obstaculo = new Catapulta(1,3,3);
        tablero.ocuparCasilla(obstaculo,3,3);

        Batallon soldados = new Batallon(soldado1, soldado2, soldado3);
        soldados.mover(tablero, new AbajoDerecha());

        assertEquals(2, soldado1.getUbicacion().getPosicionEnX());
        assertEquals(2, soldado1.getUbicacion().getPosicionEnY());

        assertEquals(4, soldado2.getUbicacion().getPosicionEnX());
        assertEquals(3, soldado2.getUbicacion().getPosicionEnY());

        assertEquals(3, soldado3.getUbicacion().getPosicionEnX());
        assertEquals(4, soldado3.getUbicacion().getPosicionEnY());

        assertTrue(soldados.disolverBatallon());
    }
    @Test
    public void testBatallonEn1x1y_2x2y_3x3y_Obstaculo4x4y_MoverAbajoDerecha_mantienenMismasPosiciones() throws BatallonDisueltoException {
         Tablero tablero = new Tablero();

         Infanteria soldado1 = new Infanteria(1,1,1);
         tablero.ocuparCasilla(soldado1,1,1);
         Infanteria soldado2 = new Infanteria(1,2,2);
         tablero.ocuparCasilla(soldado2,2,2);
         Infanteria soldado3 = new Infanteria(1,3,3);
         tablero.ocuparCasilla(soldado3,3,3);

         Curandero obstaculo = new Curandero(1,4,4);
         tablero.ocuparCasilla(obstaculo,4,4);

         Batallon batallon = new Batallon(soldado1,soldado2,soldado3);
         Ubicacion ubi1 = soldado1.getUbicacion();
         Ubicacion ubi2 = soldado2.getUbicacion();
         Ubicacion ubi3 = soldado3.getUbicacion();
         batallon.mover(tablero, new AbajoDerecha());

         assertEquals(ubi1,soldado1.getUbicacion());
         assertEquals(ubi2, soldado2.getUbicacion());
         assertEquals(ubi3, soldado3.getUbicacion());

    }
    */
}
