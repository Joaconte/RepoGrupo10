package modelo.pieza;

import org.junit.Test;
import org.mockito.Mockito;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.pieza.tipos.Catapulta;
import modelo.tablero.Tablero;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatapultaTest {

    @Test
    public void test00CatapultaDeEjercito1DaBienSuNumeroDeEjercito() {
        Catapulta catapulta = new Catapulta(1,2,2);
        assertEquals(1, catapulta.getEquipo());
    }

    @Test
    public void test01CatapultaCuesta5Puntos() {
        Catapulta catapulta = new Catapulta(1,1,1);
        assertEquals(5, catapulta.getCosto());
    }

    @Test
    public void test02CatapultaNuevaTiene50PuntosDeVida() {
        Catapulta catapulta = new Catapulta(1,2,2);
        assertEquals(50, catapulta.getPuntosVida(),0);
    }



    @Test (expected = PiezaAliadaNoAtacableException.class)
    public void test05CatapultaNoAtacaAPiezaAliada() throws PiezaAliadaNoAtacableException, DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException {
        Catapulta atacante = new Catapulta(1,1,1);

        Catapulta atacada = new Catapulta(1,2,2);

        Tablero tablero= Mockito.mock(Tablero.class);
        List<Pieza> lista = new ArrayList<>();
        lista.add(atacada);
        Mockito.when(tablero.getPiezasAdycentesInfinitas(atacada.getUbicacion())).thenReturn(lista); //Probado en modelo.tablero

        atacante.atacar(atacada,tablero);
    }

    @Test (expected = DistanciaDeAtaqueInvalidaException.class)
    public void test06CatapultaNoAtacaAPiezaEnRangoMenorA6() throws PiezaAliadaNoAtacableException, DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException {
        Catapulta atacante = new Catapulta(1,5,5);

        Catapulta atacada = new Catapulta(2,10,10);

        Tablero tablero= Mockito.mock(Tablero.class);
        List<Pieza> lista = new ArrayList<>();
        lista.add(atacada);
        Mockito.when(tablero.getPiezasAdycentesInfinitas(atacada.getUbicacion())).thenReturn(lista); //Probado en modelo.tablero

        atacante.atacar(atacada,tablero);
    }

    @Test (expected = UnidadEstaMuertaException.class)
    public void test07CatapultaNoHaceAtaquesEnUnidadesMuertas() throws PiezaAliadaNoAtacableException, DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException {
        Catapulta atacante = new Catapulta(1,5,5);

        Catapulta atacada = new Catapulta(2,12,12);
        atacada.recibirDanio(100);

        Tablero tablero= Mockito.mock(Tablero.class);
        List<Pieza> lista = new ArrayList<>();
        lista.add(atacada);
        Mockito.when(tablero.getPiezasAdycentesInfinitas(atacada.getUbicacion())).thenReturn(lista); //Probado en modelo.tablero

        atacante.atacar(atacada,tablero);
    }

    @Test
    public void test08CatapultaAtacaAUnEnemigoLejanoCorrectamente() throws PiezaAliadaNoAtacableException, DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException {
        Catapulta atacante = new Catapulta(1,5,5);

        Catapulta atacada = new Catapulta(2,12,12);
        double vidaAntesDelAtaque = atacada.getPuntosVida();

        Tablero tablero= Mockito.mock(Tablero.class);
        List<Pieza> lista = new ArrayList<>();
        lista.add(atacada);
        Mockito.when(tablero.getPiezasAdycentesInfinitas(atacada.getUbicacion())).thenReturn(lista); //Probado en modelo.tablero

        atacante.atacar(atacada,tablero);
        assertEquals(vidaAntesDelAtaque-20,atacada.getPuntosVida(),1);
    }

    @Test
    public void test09CatapultaAtacaAUnEnemigoLejanoYAdyacentesRecibenElMismoDanio() throws PiezaAliadaNoAtacableException, DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException {
        Catapulta atacante = new Catapulta(1,5,5);

        Catapulta atacada = new Catapulta(2,12,12);
        double vidaAntesDelAtaque = atacada.getPuntosVida();

        Catapulta atacadaPorAdyacente1 = new Catapulta(1,12,13);
        Catapulta atacadaPorAdyacente2 = new Catapulta(2,13,13);
        Catapulta atacadaPorAdyacente3 = new Catapulta(1,14,13);
        Catapulta atacadaPorAdyacente4 = new Catapulta(2,15,13);
        Catapulta atacadaPorAdyacente5 = new Catapulta(1,16,13);

        Tablero tablero= Mockito.mock(Tablero.class);
        List<Pieza> lista = new ArrayList<>();
        lista.add(atacada);
        lista.add(atacadaPorAdyacente1);
        lista.add(atacadaPorAdyacente2);
        lista.add(atacadaPorAdyacente3);
        lista.add(atacadaPorAdyacente4);
        lista.add(atacadaPorAdyacente5);
        Mockito.when(tablero.getPiezasAdycentesInfinitas(atacada.getUbicacion())).thenReturn(lista); //Probado en modelo.tablero

        atacante.atacar(atacada,tablero);

        assertEquals(vidaAntesDelAtaque-20,atacadaPorAdyacente5.getPuntosVida(),1);
        assertEquals(vidaAntesDelAtaque-20,atacadaPorAdyacente4.getPuntosVida(),1);
        assertEquals(vidaAntesDelAtaque-20,atacada.getPuntosVida(),1);
        assertEquals(vidaAntesDelAtaque-20,atacadaPorAdyacente1.getPuntosVida(),1);
        assertEquals(vidaAntesDelAtaque-20,atacadaPorAdyacente2.getPuntosVida(),1);
        assertEquals(vidaAntesDelAtaque-20,atacadaPorAdyacente3.getPuntosVida(),1);


    }
}
