package modelo.partida;

import modelo.jugador.EjercitoIncompletoException;
import modelo.jugador.Jugador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import modelo.partida.fase.FaseDePartida;
import modelo.partida.fase.FaseMedia;
import org.junit.Test;
import org.mockito.Mockito;

public class PartidaTest {


    @Test
    public void test01PartidaInciaSeCreaEnFaseInicial() {
        Partida miPartida = new Partida();
        assertEquals("Fase Inicial", miPartida.darNombreDeFase());
    }

    @Test
    public void test02PartidaCambiaSuFaseCorrectamenteACualquierOtraQueSeIndique() {
        Partida miPartida = new Partida();
        FaseDePartida miNuevaFase = Mockito.mock(FaseDePartida.class);
        Mockito.when(miNuevaFase.darNombreDeFase()).thenReturn("Otra fase cualquiera");
        miPartida.cambiarFaseDePartida(miNuevaFase);
        assertEquals("Otra fase cualquiera", miPartida.darNombreDeFase());
    }

    @Test
    public void test03PartidaAgregaJugadoresCorrectamente(){
        Partida partida = new Partida();
        partida.setJugadorUno( "pepe" );
        partida.setJugadorDos( "jose" );

        assertEquals(1, partida.getJugadorUno().getNumeroDeJugador());
        assertEquals(2, partida.getJugadorDos().getNumeroDeJugador());
    }

    @Test
    public void test04PartidaAgregaJugadorEnTurnoCorrectamente(){
        Partida partida = new Partida();
        Jugador jugador = new Jugador(1);
        partida.setJugadorEnTurno(jugador);

        assertEquals(1, partida.getJugadorEnTurno().getNumeroDeJugador());
    }

    @Test
    public void test05JugadorUnoTerminaTurnoEnFaseMediaYSeVerificaQueSeaElJugador2ElNuevoJugadorEnTurno() throws EjercitoIncompletoException {
        Partida miPartida = new Partida();
        FaseMedia miNuevaFase = Mockito.mock(FaseMedia.class);
        miPartida.cambiarFaseDePartida(miNuevaFase);
        miPartida.setJugadorUno("Pedro");
        miPartida.setJugadorDos("Vilma");

        Jugador jugador1 = miPartida.getJugadorUno();
        miPartida.setJugadorEnTurno(jugador1);
        Jugador jugador2 = miPartida.getJugadorDos();
        miPartida.pasarTurno();
        assertEquals(miPartida.getJugadorEnTurno(),jugador2);
    }

    @Test
    public void test06JugadorUnoTerminaTurnoEnFaseMediaYSeVerificaQueNoSeaElJugador1ElNuevoJugadorEnTurno() throws EjercitoIncompletoException {
        Partida miPartida = new Partida();
        FaseMedia miNuevaFase = Mockito.mock(FaseMedia.class);
        miPartida.cambiarFaseDePartida(miNuevaFase);
        miPartida.setJugadorUno("Pedro");
        miPartida.setJugadorDos("Vilma");

        Jugador jugador1 = miPartida.getJugadorUno();
        miPartida.setJugadorEnTurno(jugador1);

        miPartida.pasarTurno();

        assertNotSame(miPartida.getJugadorEnTurno(),jugador1);
    }
}
