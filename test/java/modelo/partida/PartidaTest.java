package modelo.partida;

import modelo.jugador.EjercitoIncompletoException;
import modelo.jugador.Jugador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import modelo.jugador.PiezaFueraDeSectorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;

import modelo.tablero.Tablero;
import org.junit.Test;
import org.mockito.Mockito;

public class PartidaTest {


    @Test
    public void test01PartidaInciaSeCreaEnFaseInicial() {
        Partida miPartida = new Partida();
        assertTrue( miPartida.estaEnFaseInicial());
    }

    @Test
    public void test02PartidaSaleDeFaseInicialCorrectamente() throws UbicacionInvalidaException, PresupuestoAgotadoException, CompraInvalidaException, PiezaFueraDeSectorException, EjercitoIncompletoException {
        Partida miPartida = new Partida();
        miPartida.agregarJugadores("pepe", "jose");

        miPartida.colocarPieza("Catapulta",1,1);
        miPartida.colocarPieza("Catapulta",2,1);
        miPartida.colocarPieza("Catapulta",2,2);
        miPartida.colocarPieza("Catapulta",2,3);

        miPartida.pasarTurno();

        miPartida.colocarPieza("Catapulta",12,1);
        miPartida.colocarPieza("Catapulta",12,2);
        miPartida.colocarPieza("Catapulta",11,3);
        miPartida.colocarPieza("Catapulta",11,2);

        miPartida.pasarTurno();

        assertFalse( miPartida.estaEnFaseInicial());
    }

    @Test
    public void test03PartidaAgregaJugadoresCorrectamente(){
        Partida partida = new Partida();
        partida.agregarJugadores("pepe", "jose");

        assertEquals(1, partida.getJugadorUno().getNumeroDeJugador());
        assertEquals(2, partida.getJugadorDos().getNumeroDeJugador());
    }

    @Test
    public void test04PartidaAgregaJugadoresYElQueEstaEnTurnoEsElUno(){
        Partida partida = new Partida();
        partida.agregarJugadores("pepe", "jose");

        assertEquals(1, partida.getJugadorUno().getNumeroDeJugador());
        assertEquals(1, partida.getJugadorEnTurno().getNumeroDeJugador());
    }

    @Test
    public void test05PartidaAgregaJugadorEnTurnoCorrectamente(){
        Partida partida = new Partida();
        Jugador jugador = new Jugador(1,"pepe");
        partida.setJugadorEnTurno(jugador);

        assertEquals(1, partida.getJugadorEnTurno().getNumeroDeJugador());
    }


    @Test
    public void test06JugadorUnoTerminaTurnoEnFaseInicialYDejaDeSerJugadorEnTurno() throws EjercitoIncompletoException, UbicacionInvalidaException, PresupuestoAgotadoException, CompraInvalidaException, PiezaFueraDeSectorException {
        Partida miPartida = new Partida();
        miPartida.agregarJugadores("pepe", "jose");

        Jugador jugador1 = miPartida.getJugadorUno();
        Tablero unTablero = Mockito.mock(Tablero.class);
        Mockito.when(unTablero.casillaEstaOcupada(2,2)).thenReturn(false);

        jugador1.crearNuevaUnidad(unTablero,"Catapulta",2,2);
        jugador1.crearNuevaUnidad(unTablero,"Catapulta",2,2);
        jugador1.crearNuevaUnidad(unTablero,"Catapulta",2,2);
        jugador1.crearNuevaUnidad(unTablero,"Catapulta",2,2);

        miPartida.pasarTurno();

        assertEquals(miPartida.getJugadorEnTurno(),miPartida.getJugadorDos());
    }

    @Test
    public void test07JugadorUnoComienzaComoJugadorEnTurnoEnFaseMedia() throws EjercitoIncompletoException, UbicacionInvalidaException, PresupuestoAgotadoException, CompraInvalidaException, PiezaFueraDeSectorException {
        Partida miPartida = new Partida();
        miPartida.agregarJugadores("pepe", "jose");

        Jugador jugador1 = miPartida.getJugadorUno();
        Jugador jugador2 = miPartida.getJugadorDos();

        Tablero unTablero = Mockito.mock(Tablero.class);
        Mockito.when(unTablero.casillaEstaOcupada(2,2)).thenReturn(false);
        Mockito.when(unTablero.casillaEstaOcupada(12,2)).thenReturn(false);

        jugador1.crearNuevaUnidad(unTablero,"Catapulta",2,2);
        jugador1.crearNuevaUnidad(unTablero,"Catapulta",2,2);
        jugador1.crearNuevaUnidad(unTablero,"Catapulta",2,2);
        jugador1.crearNuevaUnidad(unTablero,"Catapulta",2,2);

        miPartida.pasarTurno();

        jugador2.crearNuevaUnidad(unTablero,"Catapulta",12,2);
        jugador2.crearNuevaUnidad(unTablero,"Catapulta",12,2);
        jugador2.crearNuevaUnidad(unTablero,"Catapulta",12,2);
        jugador2.crearNuevaUnidad(unTablero,"Catapulta",12,2);

        miPartida.pasarTurno();

        assertEquals(miPartida.getJugadorEnTurno(),jugador1);
    }
}
