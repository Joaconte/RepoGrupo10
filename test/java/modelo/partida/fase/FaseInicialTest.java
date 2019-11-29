package modelo.partida.fase;


import modelo.jugador.EjercitoIncompletoException;
import modelo.jugador.Jugador;
import modelo.jugador.PiezaFueraDeSectorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.partida.Partida;
import modelo.tablero.Tablero;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;


public class FaseInicialTest {


    @Test
    public void test01FaseInicialDevuelveTrueCuandoLePreguntanSiEsFaseInicial() {
        FaseInicial miFaseInicial = new FaseInicial();
        assertTrue( miFaseInicial.esFaseInicial());
    }

    @Test
    public void test02FaseInicialSeDevuelveASiMismaSiTurnosPasadosEsDistintoADos() {
        FaseInicial miFaseInicial = new FaseInicial();
        assertEquals(miFaseInicial, miFaseInicial.retornarProximaFase());
    }

    @Test
    public void test03FaseInicialDevuelveOtraFaseConDosTurnosPasados() throws UbicacionInvalidaException, PresupuestoAgotadoException, CompraInvalidaException, PiezaFueraDeSectorException, EjercitoIncompletoException {
        FaseInicial miFaseInicial = new FaseInicial();

        Tablero unTablero = Mockito.mock(Tablero.class);
        Mockito.when(unTablero.casillaEstaOcupada(2,2)).thenReturn(false);
        Mockito.when(unTablero.casillaEstaOcupada(12,2)).thenReturn(false);

        Jugador jugadorEnTurno1 = new Jugador(1,"jose");
        Jugador jugadorEnTurno2 = new Jugador(2,"pepe");

        miFaseInicial.colocarPieza(jugadorEnTurno1,unTablero,"Catapulta",2,2);
        miFaseInicial.colocarPieza(jugadorEnTurno1,unTablero,"Catapulta",2,2);
        miFaseInicial.colocarPieza(jugadorEnTurno1,unTablero,"Catapulta",2,2);
        miFaseInicial.colocarPieza(jugadorEnTurno1,unTablero,"Catapulta",2,2);

        miFaseInicial.finalizarTurno(jugadorEnTurno1);

        miFaseInicial.colocarPieza(jugadorEnTurno2,unTablero,"Catapulta",12,2);
        miFaseInicial.colocarPieza(jugadorEnTurno2,unTablero,"Catapulta",12,2);
        miFaseInicial.colocarPieza(jugadorEnTurno2,unTablero,"Catapulta",12,2);
        miFaseInicial.colocarPieza(jugadorEnTurno2,unTablero,"Catapulta",12,2);

        miFaseInicial.finalizarTurno(jugadorEnTurno2);

        assertNotEquals(miFaseInicial, miFaseInicial.retornarProximaFase());
    }

    @Test (expected = EjercitoIncompletoException.class)
    public void test04JugadorUnoNoTerminaDeComprarEjercitoEntoncesFaseInicialNoPuedeSumarNuevoTurnoPasado() throws EjercitoIncompletoException {
        FaseInicial miFaseInicial = new FaseInicial();
        Jugador jugadorEnTurno1 = new Jugador(1,"jose");

        miFaseInicial.finalizarTurno(jugadorEnTurno1);
    }
}