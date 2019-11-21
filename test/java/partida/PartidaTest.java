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
import tablero.Tablero;

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
    public void test03PartidaEnFaseInicialNoHaceNadaAlAtacarConCualquierTropa() throws PiezaAliadaNoAtacableException, JugadorNoPuedeException, JineteAsediadoException, JineteNoAsediadoException, PiezaAtacadaEnRangoIncorrectoException {
        Partida miPartida = new Partida();

        Infanteria atacante = new Infanteria();
        atacante.setEquipo(1);
        atacante.setUbicacion(new Ubicacion(1, 1));

        Catapulta atacante2 = new Catapulta();
        atacante2.setEquipo(1);
        atacante2.setUbicacion(new Ubicacion(1, 2));

        Jinete atacante3 = new Jinete();
        atacante3.setEquipo(1);
        atacante3.setUbicacion(new Ubicacion(1, 3));

        Jinete atacado = new Jinete();
        atacado.setEquipo(2);
        atacado.setUbicacion(new Ubicacion(1, 9));


        miPartida.colocarUnaFichaEnElTablero(atacante, 1, 1);
        miPartida.colocarUnaFichaEnElTablero(atacante2, 1, 2);
        miPartida.colocarUnaFichaEnElTablero(atacante3, 1, 3);
        miPartida.colocarUnaFichaEnElTablero(atacado, 1, 9);

        miPartida.setJugadorEnTurno(new Jugador(1));

        double vidaAtacadoAntesDelAtaque = atacado.getPuntosVida();

        miPartida.atacar(atacante, atacado);

        double vidaAtacadoLuegoDelAtaque = atacado.getPuntosVida();
        assertEquals(vidaAtacadoAntesDelAtaque, vidaAtacadoLuegoDelAtaque, 0);

        miPartida.atacar(atacante2, atacado);

        double vidaAtacadoLuegoDelAtaque2 = atacado.getPuntosVida();
        assertEquals(vidaAtacadoAntesDelAtaque, vidaAtacadoLuegoDelAtaque2, 0);

        miPartida.atacar(atacante3, atacado);

        double vidaAtacadoLuegoDelAtaque3 = atacado.getPuntosVida();
        assertEquals(vidaAtacadoAntesDelAtaque, vidaAtacadoLuegoDelAtaque3, 0);
    }


    @Test
    public void test04PartidaEnFaseMediaDejaAInfanteAtacarAEnemigoEnCampoPropioCorrectamente() throws PiezaAliadaNoAtacableException, JugadorNoPuedeException, PiezaAtacadaEnRangoIncorrectoException {
        Partida miPartida = new Partida();

        Infanteria atacante = new Infanteria();
        atacante.setEquipo(1);
        atacante.setUbicacion(new Ubicacion(1, 1));

        Jinete atacado = new Jinete();
        atacado.setEquipo(2);
        atacado.setUbicacion(new Ubicacion(1, 2));

        miPartida.setJugadorEnTurno(new Jugador(1));
        miPartida.colocarUnaFichaEnElTablero(atacante, 1, 1);
        miPartida.colocarUnaFichaEnElTablero(atacado, 1, 2);

        miPartida.cambiarAFaseMedia();

        double vidaAtacadoAntesDelAtaque = atacado.getPuntosVida();
        miPartida.atacar(atacante, atacado);
        double vidaAtacadoLuegoDelAtaque = atacado.getPuntosVida();

        assertEquals(vidaAtacadoAntesDelAtaque - 10, vidaAtacadoLuegoDelAtaque, 5);
    }

    @Test
    public void test05PartidaEnFaseMediaDejaAInfanteAtacarAEnemigoEnCampoDeEnemigoCorrectamente() throws PiezaAliadaNoAtacableException, JugadorNoPuedeException, PiezaAtacadaEnRangoIncorrectoException {
        Partida miPartida = new Partida();

        Infanteria atacante = new Infanteria();
        atacante.setEquipo(1);
        atacante.setUbicacion(new Ubicacion(1, 1));
        Jinete atacado = new Jinete();
        atacado.setEquipo(2);
        atacado.setUbicacion(new Ubicacion(1, 2));

        miPartida.setJugadorEnTurno(new Jugador(2));
        miPartida.colocarUnaFichaEnElTablero(atacante, 1, 1);
        miPartida.colocarUnaFichaEnElTablero(atacado, 1, 2);

        miPartida.cambiarAFaseMedia();

        double vidaAtacadoAntesDelAtaque = atacado.getPuntosVida();
        miPartida.atacar(atacante, atacado);
        double vidaAtacadoLuegoDelAtaque = atacado.getPuntosVida();

        assertEquals(vidaAtacadoAntesDelAtaque - 10, vidaAtacadoLuegoDelAtaque, 0);
    }

    @Test
    public void test06PartidaEnFaseMediaDejaAtacarACatapultaAPiezasEnCampoDeEnemigosCorrectamente() throws PiezaAliadaNoAtacableException, JugadorNoPuedeException, PiezaAtacadaEnRangoIncorrectoException {
        Partida miPartida = new Partida();

        Catapulta atacante = new Catapulta();
        atacante.setEquipo(2);
        atacante.setUbicacion(new Ubicacion(18, 18));


        Jinete atacado = new Jinete();
        atacado.setEquipo(1);
        atacado.setUbicacion(new Ubicacion(1, 2));

        Jinete atacadoDeRebote1 = new Jinete();
        atacadoDeRebote1.setEquipo(1);
        atacadoDeRebote1.setUbicacion(new Ubicacion(2, 2));

        Jinete atacadoDeRebote2 = new Jinete();
        atacadoDeRebote2.setEquipo(2);
        atacadoDeRebote2.setUbicacion(new Ubicacion(3, 3));

        Jinete noAtacado = new Jinete();
        noAtacado.setEquipo(2);
        noAtacado.setUbicacion(new Ubicacion(5, 6));

        miPartida.setJugadorEnTurno(new Jugador(2));

        miPartida.colocarUnaFichaEnElTablero(atacante, 18, 18);
        miPartida.colocarUnaFichaEnElTablero(atacado, 1, 2);
        miPartida.colocarUnaFichaEnElTablero(atacadoDeRebote1, 2, 2);
        miPartida.colocarUnaFichaEnElTablero(atacadoDeRebote2, 3, 3);

        miPartida.colocarUnaFichaEnElTablero(noAtacado, 5, 6);

        miPartida.cambiarAFaseMedia();

        double vidaJinetesAntesDelAtaque = atacado.getPuntosVida();
        miPartida.atacar(atacante, atacado);

        assertEquals(vidaJinetesAntesDelAtaque - 20, atacado.getPuntosVida(), 0);
        assertEquals(vidaJinetesAntesDelAtaque - 20, atacadoDeRebote1.getPuntosVida(), 0);
        assertEquals(vidaJinetesAntesDelAtaque - 20, atacadoDeRebote2.getPuntosVida(), 10);
        assertEquals(vidaJinetesAntesDelAtaque, noAtacado.getPuntosVida(), 0);
    }

    @Test
    public void test07PartidaEnFaseMediaDejaAtacarAJineteAPiezaEnRangoCortoCuandoEstaAsediado() throws PiezaAliadaNoAtacableException, JugadorNoPuedeException, PiezaAtacadaEnRangoIncorrectoException, JineteAsediadoException, JineteNoAsediadoException {
        Partida miPartida = new Partida ();

        Jinete atacante = new Jinete();
        atacante.setEquipo(1);
        atacante.setUbicacion(new Ubicacion(1, 2));

        Jinete atacado = new Jinete();
        atacado.setEquipo(2);
        atacado.setUbicacion(new Ubicacion(2, 2));

        miPartida.setJugadorEnTurno(new Jugador(1));
        miPartida.colocarUnaFichaEnElTablero(atacante, 1, 2);
        miPartida.colocarUnaFichaEnElTablero(atacado, 2, 2);


        miPartida.cambiarAFaseMedia();
        double vidaJinetesAntesDelAtaque = atacado.getPuntosVida();
        miPartida.atacar(atacante, atacado);

        assertEquals(vidaJinetesAntesDelAtaque - 5, atacado.getPuntosVida(), 25);

    }

    @Test (expected = JineteAsediadoException.class)
    public void test08PartidaEnFaseMediaNoDejaAtacarAJineteEnDistanciaMediaPorqueEstaAsediado() throws PiezaAliadaNoAtacableException, JugadorNoPuedeException, PiezaAtacadaEnRangoIncorrectoException, JineteAsediadoException, JineteNoAsediadoException {
        Partida miPartida = new Partida ();

        Jinete atacante = new Jinete();
        atacante.setEquipo(1);
        atacante.setUbicacion(new Ubicacion(1, 2));

        Jinete atacado = new Jinete();
        atacado.setEquipo(2);
        atacado.setUbicacion(new Ubicacion(5, 6));

        Jinete estorbo = new Jinete();
        atacado.setEquipo(2);
        atacado.setUbicacion(new Ubicacion(5, 6));

        miPartida.setJugadorEnTurno(new Jugador(1));
        miPartida.colocarUnaFichaEnElTablero(atacante, 1, 2);
        miPartida.colocarUnaFichaEnElTablero(estorbo, 2, 2);
        miPartida.colocarUnaFichaEnElTablero(estorbo, 5, 6);

        miPartida.cambiarAFaseMedia();
        double vidaJinetesAntesDelAtaque = atacado.getPuntosVida();
        miPartida.atacar(atacante, atacado);


    }

}
