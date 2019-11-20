package partida;

import jugador.Jugador;
import partida.ataques.JineteAsediadoException;
import partida.ataques.JineteNoAsediadoException;
import partida.ataques.PiezaAtacadaEnRangoIncorrectoException;
import partida.fase.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import pieza.Ubicacion;
import pieza.tipos.*;

public class PartidaTest {


    @Test
    public void test01PartidaInciaSeCreaEnFaseInicial() {
        Partida miPartida = new Partida ();
        assertEquals("Fase Inicial", miPartida.darNombreDeFase());
    }

    @Test
    public void test02PartidaCambiaSuFaseCorrectamenteACualquierOtraQueSeIndique() {
        Partida miPartida = new Partida ();
        FaseDePartida miNuevaFase = Mockito.mock(FaseDePartida.class);
        Mockito.when(miNuevaFase.darNombreDeFase()).thenReturn("Otra fase cualquiera");
        miPartida.cambiarFaseDePartida(miNuevaFase);
        assertEquals("Otra fase cualquiera", miPartida.darNombreDeFase());
    }

    @Test
    public void test03PartidaEnFaseInicialNoDejaAtacar() throws PiezaAliadaNoAtacableException, JugadorNoPuedeException, JineteAsediadoException, JineteNoAsediadoException, PiezaAtacadaEnRangoIncorrectoException {
        Partida miPartida = new Partida ();

        Infanteria atacante = new Infanteria();
        atacante.setEquipo(1);
        atacante.setUbicacion(new Ubicacion(1,1));
        Jinete atacado = new Jinete();
        atacado.setEquipo(2);
       atacante.setUbicacion(new Ubicacion(1,9));

        Jugador jugadorEnTurno = new Jugador(1);
        miPartida.setJugadorEnTurno(jugadorEnTurno);


        double vidaAtacadoAntesDelAtaque = atacado.getPuntosVida();
        miPartida.atacar(atacante,atacado);
        double vidaAtacadoLuegoDelAtaque = atacado.getPuntosVida();

        assertEquals(vidaAtacadoAntesDelAtaque, vidaAtacadoLuegoDelAtaque, 0);
    }

    @Test
    public void test04PartidaEnFaseMediaSiDejaAtacar() throws PiezaAliadaNoAtacableException, JugadorNoPuedeException, JineteAsediadoException, JineteNoAsediadoException, PiezaAtacadaEnRangoIncorrectoException {
        Partida miPartida = new Partida ();

        Infanteria atacante = new Infanteria();
        atacante.setEquipo(1);
        atacante.setUbicacion(new Ubicacion(1,1));
        Jinete atacado = new Jinete();
        atacado.setEquipo(2);
        atacante.setUbicacion(new Ubicacion(1,2));

        Jugador jugadorEnTurno = new Jugador(1);

        miPartida.setJugadorEnTurno(jugadorEnTurno);
        miPartida.cambiarFaseDePartida(new FaseMedia());

        double vidaAtacadoAntesDelAtaque = atacado.getPuntosVida();
        miPartida.atacar(atacante,atacado);
        double vidaAtacadoLuegoDelAtaque = atacado.getPuntosVida();

        assertEquals(vidaAtacadoAntesDelAtaque-10, vidaAtacadoLuegoDelAtaque, 0);
    }

}
