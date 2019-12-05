package  modelo.partida.fase;

import modelo.jugador.Jugador;
import modelo.jugador.PiezaNoEsDeJugadorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.pieza.Ubicacion;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.pieza.movimiento.NoSePuedeMoverException;
import modelo.pieza.sanacion.CurandoAEnemigoException;
import modelo.pieza.sanacion.UnidadNoSePuedeCurar;
import modelo.pieza.tipos.Curandero;
import modelo.pieza.tipos.CurandoCuraADistanciaCortaException;
import modelo.pieza.tipos.Jinete;
import modelo.tablero.DesplazamientoInvalidoException;
import modelo.tablero.Tablero;
import modelo.tablero.casilla.NoHayUnidadEnPosicionException;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class FaseMediaTest {


    @Test
    public void test01FaseMediaDevuelveFalseSiLePreguntanSiEsFaseInicial() {
        FaseMedia miFaseMedia = new FaseMedia();
        assertFalse( miFaseMedia.esFaseInicial());
    }

    @Test
    public void test02FaseMediaSeDevuelveASiMismaComoProximaFase() {
        FaseMedia miFaseMedia = new FaseMedia();
        assertEquals(miFaseMedia, miFaseMedia.retornarProximaFase());
    }

    @Test (expected = JugadorYaRealizoLaAccionException.class)
    public void test03FaseMediaNoDejaRepetirAtaques() throws PiezaAliadaNoAtacableException, JugadorYaRealizoLaAccionException, UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        FaseMedia miFaseMedia = new FaseMedia();
        Tablero tablero =  new Tablero();
        Jinete jinte = new Jinete(1,9,9);
        Jinete piezaAtacada = new Jinete(2,13,13);
        tablero.ocuparCasilla(jinte,9,9);
        tablero.ocuparCasilla(piezaAtacada,13,13);
        miFaseMedia.atacar(jinte,piezaAtacada, tablero);
        miFaseMedia.atacar(jinte,piezaAtacada, tablero);
    }

    @Test
    public void test04FaseMediaDejaAtacarLaPrimeraVez() throws PiezaAliadaNoAtacableException, JugadorYaRealizoLaAccionException, UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        FaseMedia miFaseMedia = new FaseMedia();
        Tablero tablero =  new Tablero();
        Jinete jinte = new Jinete(1,9,9);
        Jinete piezaAtacada = new Jinete(2,13,13);
        tablero.ocuparCasilla(jinte,9,9);
        tablero.ocuparCasilla(piezaAtacada,13,13);

        double vida = piezaAtacada.getPuntosVida();
        miFaseMedia.atacar(jinte,piezaAtacada, tablero);
        assertEquals(vida-15,piezaAtacada.getPuntosVida(),1);
    }

    @Test (expected = JugadorYaRealizoLaAccionException.class)
    public void test05FaseMediaDejaAtacarYCurarEnUnTurno() throws PiezaAliadaNoAtacableException, JugadorYaRealizoLaAccionException, UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, CurandoAEnemigoException, CurandoCuraADistanciaCortaException, UnidadNoSePuedeCurar {
        FaseMedia miFaseMedia = new FaseMedia();
        Tablero tablero =  new Tablero();
        Jinete jinete = new Jinete(1,9,9);
        Jinete piezaAtacada = new Jinete(2,13,13);
        tablero.ocuparCasilla(jinete,9,9);
        tablero.ocuparCasilla(piezaAtacada,13,13);

        jinete.recibirDanio(22);
        Curandero curandero = new Curandero(1,8,8);

        miFaseMedia.atacar(jinete,piezaAtacada, tablero);
        miFaseMedia.curarAAliado(curandero,jinete);
    }

    @Test
    public void test06FaseMediaDejaMoverLaPrimeraVez() throws NoSePuedeMoverException, PiezaNoEsDeJugadorException, NoHayUnidadEnPosicionException, UbicacionInvalidaException, JugadorYaRealizoLaAccionException, DesplazamientoInvalidoException {
        Ubicacion ubicacionInicial = new Ubicacion(1,1);
        Tablero tablero = new Tablero();
        tablero.ocuparCasilla(new Jinete(1,1,1),1,1);
        Jugador jugadorTurno = Mockito.mock(Jugador.class);
        Mockito.when(jugadorTurno.jugadorControlaUbicacion(ubicacionInicial)).thenReturn(true);
        FaseMedia faseMedia = new FaseMedia();
        faseMedia.moverUnidadEnTablero(tablero,jugadorTurno,ubicacionInicial,new Ubicacion(2,2));
        assertTrue(tablero.casillaEstaOcupada(2,2));
    }

    @Test (expected = JugadorYaRealizoLaAccionException.class)
    public void test07FaseMediaNoDejaMoverDosVeces() throws NoSePuedeMoverException, PiezaNoEsDeJugadorException, NoHayUnidadEnPosicionException, UbicacionInvalidaException, JugadorYaRealizoLaAccionException, DesplazamientoInvalidoException {
        Ubicacion ubicacionInicial = new Ubicacion(1,1);
        Tablero tablero = new Tablero();
        tablero.ocuparCasilla(new Jinete(1,1,1),1,1);
        Jugador jugadorTurno = Mockito.mock(Jugador.class);
        Mockito.when(jugadorTurno.jugadorControlaUbicacion(ubicacionInicial)).thenReturn(true);
        FaseMedia faseMedia = new FaseMedia();
        faseMedia.moverUnidadEnTablero(tablero,jugadorTurno,ubicacionInicial,new Ubicacion(2,2));

        Ubicacion ubicacion2 = new Ubicacion(3,3);
        Mockito.when(jugadorTurno.jugadorControlaUbicacion(ubicacion2)).thenReturn(true);

        faseMedia.moverUnidadEnTablero(tablero,jugadorTurno,new Ubicacion(2,2),ubicacion2);
    }

}