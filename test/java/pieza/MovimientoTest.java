package pieza;

import org.junit.Test;
import pieza.movimiento.*;
import pieza.movimiento.NoSePuedeMoverException;
import pieza.tipos.*;
import tablero.Tablero;

import static org.junit.Assert.*;

public class MovimientoTest {
    @Test
    public void testJineteSePuedeMoverArriba() throws NoSePuedeMoverException {
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete(1,2,1);
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
}
