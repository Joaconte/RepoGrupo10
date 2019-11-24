package partida;

import jugador.Jugador;
import partida.fase.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import pieza.ataque.PiezaAliadaNoAtacableException;

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
        Jugador jugador1 = new Jugador(1);
        Jugador jugador2 = new Jugador(2);
        partida.setJugadorUno(jugador1);
        partida.setJugadorDos(jugador2);

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

}
