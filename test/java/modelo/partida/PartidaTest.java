package modelo.partida;

import modelo.jugador.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;

import modelo.partida.fase.JugadorYaRealizoLaAccionException;
import modelo.pieza.Ubicacion;
import modelo.pieza.movimiento.NoSePuedeMoverException;
import modelo.tablero.DesplazamientoInvalidoException;
import modelo.tablero.Tablero;
import modelo.tablero.casilla.NoHayUnidadEnPosicionException;
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

        miPartida.crearPieza("Catapulta",1,1);
        miPartida.crearPieza("Catapulta",2,1);
        miPartida.crearPieza("Catapulta",2,2);
        miPartida.crearPieza("Catapulta",2,3);

        miPartida.pasarTurno();

        miPartida.crearPieza("Catapulta",12,13);
        miPartida.crearPieza("Catapulta",12,12);
        miPartida.crearPieza("Catapulta",11,13);
        miPartida.crearPieza("Catapulta",11,12);

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
        Mockito.when(unTablero.casillaEstaOcupada(12,12)).thenReturn(false);

        jugador1.crearNuevaUnidad(unTablero,"Catapulta",2,2);
        jugador1.crearNuevaUnidad(unTablero,"Catapulta",2,2);
        jugador1.crearNuevaUnidad(unTablero,"Catapulta",2,2);
        jugador1.crearNuevaUnidad(unTablero,"Catapulta",2,2);

        miPartida.pasarTurno();

        jugador2.crearNuevaUnidad(unTablero,"Catapulta",12,12);
        jugador2.crearNuevaUnidad(unTablero,"Catapulta",12,12);
        jugador2.crearNuevaUnidad(unTablero,"Catapulta",12,12);
        jugador2.crearNuevaUnidad(unTablero,"Catapulta",12,12);

        miPartida.pasarTurno();

        assertEquals(miPartida.getJugadorEnTurno(),jugador1);
    }

}
