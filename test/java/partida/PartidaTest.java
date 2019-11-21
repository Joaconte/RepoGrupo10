package partida;

import jugador.Jugador;
import jugador.PiezaFueraDeSectorException;
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
import tablero.CasillaTieneUnidadException;

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
    public void test03PartidaEnFaseInicialNoHaceNadaAlAtacarConCualquierTropa() throws PiezaAliadaNoAtacableException, JugadorNoPuedeException, JineteAsediadoException, JineteNoAsediadoException, PiezaAtacadaEnRangoIncorrectoException, CasillaTieneUnidadException, PiezaFueraDeSectorException {
        Partida miPartida = new Partida();

        //-------Ubicacion de fichas--------------
        miPartida.setJugadorEnTurno(new Jugador(1));

        Infanteria atacante = new Infanteria();
        atacante.setEquipo(1);
        atacante.setUbicacion(new Ubicacion(10, 10));

        Catapulta atacante2 = new Catapulta();
        atacante2.setEquipo(1);
        atacante2.setUbicacion(new Ubicacion(1, 2));

        Jinete atacante3 = new Jinete();
        atacante3.setEquipo(1);
        atacante3.setUbicacion(new Ubicacion(7, 7));

        miPartida.agregarNuevaUbicacionAFicha(atacante, 10, 10);
        miPartida.agregarNuevaUbicacionAFicha(atacante2, 1, 2);
        miPartida.agregarNuevaUbicacionAFicha(atacante3, 7, 7);

        miPartida.setJugadorEnTurno(new Jugador(2));

        Jinete atacado = new Jinete();
        atacado.setEquipo(2);
        atacado.setUbicacion(new Ubicacion(11, 11));

        miPartida.agregarNuevaUbicacionAFicha(atacado, 11, 11);

        //-------Ataques--------------

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
    public void test04PartidaEnFaseMediaDejaAInfanteAtacarAEnemigoEnCampoPropioCorrectamente() throws PiezaAliadaNoAtacableException, JugadorNoPuedeException, PiezaAtacadaEnRangoIncorrectoException, CasillaTieneUnidadException, PiezaFueraDeSectorException {
        Partida miPartida = new Partida();

        //-------Ubicacion de fichas--------------
        Infanteria atacante = new Infanteria();
        atacante.setEquipo(1);
        atacante.setUbicacion(new Ubicacion(1, 1));

        Jinete atacado = new Jinete();
        atacado.setEquipo(2);
        atacado.setUbicacion(new Ubicacion(1, 2));

        miPartida.setJugadorEnTurno(new Jugador(1));
        miPartida.agregarNuevaUbicacionAFicha(atacante, 1, 1);

        miPartida.cambiarFaseDePartida(new FaseMedia());

        miPartida.setJugadorEnTurno(new Jugador(2));
        miPartida.agregarNuevaUbicacionAFicha(atacado, 1, 2);


        //-------Ataques--------------
        ;
        miPartida.setJugadorEnTurno(new Jugador(1));
        double vidaAtacadoAntesDelAtaque = atacado.getPuntosVida();
        miPartida.atacar(atacante, atacado);
        double vidaAtacadoLuegoDelAtaque = atacado.getPuntosVida();

        assertEquals(vidaAtacadoAntesDelAtaque - 10, vidaAtacadoLuegoDelAtaque, 0.5);
    }

    @Test
    public void test05PartidaEnFaseMediaDejaAInfanteAtacarAEnemigoEnCampoDeEnemigoCorrectamente() throws PiezaAliadaNoAtacableException, JugadorNoPuedeException, PiezaAtacadaEnRangoIncorrectoException, CasillaTieneUnidadException, PiezaFueraDeSectorException {
        Partida miPartida = new Partida();

        //-------Ubicacion de fichas--------------

        Infanteria atacante = new Infanteria();
        atacante.setEquipo(2);
        atacante.setUbicacion(new Ubicacion(11, 11));

        Jinete atacado = new Jinete();
        atacado.setEquipo(1);
        atacado.setUbicacion(new Ubicacion(10, 10));

        miPartida.setJugadorEnTurno(new Jugador(1));
        miPartida.agregarNuevaUbicacionAFicha(atacado, 10, 10);
        miPartida.setJugadorEnTurno(new Jugador(2));
        miPartida.agregarNuevaUbicacionAFicha(atacante, 11, 11);


        //-------Ataque--------------
        miPartida.cambiarFaseDePartida(new FaseMedia());;
        double vidaAtacadoAntesDelAtaque = atacado.getPuntosVida();
        miPartida.atacar(atacante, atacado);
        double vidaAtacadoLuegoDelAtaque = atacado.getPuntosVida();

        assertEquals(vidaAtacadoAntesDelAtaque - 10, vidaAtacadoLuegoDelAtaque, 0);
    }

    @Test
    public void test06PartidaEnFaseMediaDejaAtacarACatapultaAPiezasEnCampoDeEnemigosCorrectamente() throws PiezaAliadaNoAtacableException, JugadorNoPuedeException, PiezaAtacadaEnRangoIncorrectoException, CasillaTieneUnidadException, PiezaFueraDeSectorException {
        Partida miPartida = new Partida();
        miPartida.cambiarFaseDePartida(new FaseMedia());

        //-------Ubicacion de fichas--------------

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

        miPartida.setJugadorEnTurno(new Jugador(1));
        miPartida.agregarNuevaUbicacionAFicha(atacado, 1, 2);
        miPartida.agregarNuevaUbicacionAFicha(atacadoDeRebote1, 2, 2);

        miPartida.setJugadorEnTurno(new Jugador(2));

        miPartida.agregarNuevaUbicacionAFicha(atacante, 18, 18);
        miPartida.agregarNuevaUbicacionAFicha(atacadoDeRebote2, 3, 3);
        miPartida.agregarNuevaUbicacionAFicha(noAtacado, 5, 6);

        //-------Ataque--------------

        double vidaJinetesAntesDelAtaque = atacado.getPuntosVida();
        miPartida.atacar(atacante, atacado);

        assertEquals(vidaJinetesAntesDelAtaque - 20, atacado.getPuntosVida(), 0);
        assertEquals(vidaJinetesAntesDelAtaque - 20, atacadoDeRebote1.getPuntosVida(), 0);
        assertEquals(vidaJinetesAntesDelAtaque - 20, atacadoDeRebote2.getPuntosVida(), 1);
        assertEquals(vidaJinetesAntesDelAtaque, noAtacado.getPuntosVida(), 0);
    }

    @Test
    public void test07PartidaEnFaseMediaDejaAtacarAJineteAPiezaEnRangoCortoCuandoEstaAsediado() throws PiezaAliadaNoAtacableException, JugadorNoPuedeException, PiezaAtacadaEnRangoIncorrectoException, JineteAsediadoException, JineteNoAsediadoException, CasillaTieneUnidadException, PiezaFueraDeSectorException {
        Partida miPartida = new Partida ();
        miPartida.cambiarFaseDePartida(new FaseMedia());

        //-------Ubicacion de fichas--------------

        Jinete atacante = new Jinete();
        atacante.setEquipo(1);
        atacante.setUbicacion(new Ubicacion(1, 2));

        Jinete atacado = new Jinete();
        atacado.setEquipo(2);
        atacado.setUbicacion(new Ubicacion(2, 2));

        miPartida.setJugadorEnTurno(new Jugador(2));
        miPartida.agregarNuevaUbicacionAFicha(atacado, 2, 2);

        miPartida.setJugadorEnTurno(new Jugador(1));
        miPartida.agregarNuevaUbicacionAFicha(atacante, 1, 2);


        //-------Ataquess--------------

        double vidaJinetesAntesDelAtaque = atacado.getPuntosVida();
        miPartida.atacar(atacante, atacado);
        assertEquals(vidaJinetesAntesDelAtaque - 5, atacado.getPuntosVida(), 0.25);
    }

    @Test (expected = JineteAsediadoException.class)
    public void test08PartidaEnFaseMediaNoDejaAtacarAJineteEnDistanciaMediaPorqueEstaAsediado() throws PiezaAliadaNoAtacableException, JugadorNoPuedeException, PiezaAtacadaEnRangoIncorrectoException, JineteAsediadoException, JineteNoAsediadoException, CasillaTieneUnidadException, PiezaFueraDeSectorException {
        Partida miPartida = new Partida ();
        miPartida.cambiarFaseDePartida(new FaseMedia());
        //-------Ubicacion de fichas--------------
        miPartida.setJugadorEnTurno(new Jugador(1));;
        Jinete atacante = new Jinete();
        atacante.setEquipo(1);
        atacante.setUbicacion(new Ubicacion(1, 2));
        miPartida.agregarNuevaUbicacionAFicha(atacante, 1, 2);

        miPartida.setJugadorEnTurno(new Jugador(2));;
        Jinete atacado = new Jinete();
        atacado.setEquipo(2);
        atacado.setUbicacion(new Ubicacion(5, 6));
        miPartida.agregarNuevaUbicacionAFicha(atacado, 5, 6);

        Jinete estorbo = new Jinete();
        estorbo.setEquipo(2);
        estorbo.setUbicacion(new Ubicacion(2, 2));
        miPartida.agregarNuevaUbicacionAFicha(estorbo, 2, 2);

        //-------Ataques--------------
        miPartida.setJugadorEnTurno(new Jugador(1));;
        miPartida.atacar(atacante, atacado);
    }

}
