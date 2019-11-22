package tablero;

import pieza.Ubicacion;
import pieza.tipos.Jinete;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.mockito.Mockito;
import pieza.Pieza;
import tablero.casilla.Casilla;

import java.util.List;


public class TableroTest {

    @Test
    public void test01TableroGuardaDimensionesEsperadas(){
        Tablero tablero = new Tablero();
        assertEquals(400,tablero.getTamanio());
    }

   @Test
   public void test02TableroCreaNumeroDeColumnasEsperado(){
        Tablero tablero = new Tablero();
        assertEquals(20,tablero.getCantidadColumnasCreadas());
    }

    @Test
    public void test03ElEstadoInicialDeUnaCasillaDelTableroEsLibre(){
        Tablero tablero = new Tablero();
        assertFalse(tablero.casillaEstaOcupada(1, 1));
    }

    @Test
    public void test04ElEstadoDeUnaCasillaLibreALaQueOcupoPasaAOcupado(){
        Tablero tablero = new Tablero();
        Pieza pieza = Mockito.mock(Pieza.class);
        tablero.ocuparCasilla(pieza, 3,4);
        assertTrue(tablero.casillaEstaOcupada(3, 4));
    }

    @Test
    public void test05ElEstadoDeUnaCasillaALaQueOcupoPasaADesocupadaCuandoLaDesocupo(){
        Tablero tablero = new Tablero();
        Pieza pieza = Mockito.mock(Pieza.class);
        tablero.ocuparCasilla(pieza, 1,1);
        tablero.desocuparCasilla(1,1);
        assertFalse(tablero.casillaEstaOcupada(1, 1));
    }

    @Test
    public void test06TableroEncuentra6PiezasAdyacenctesAPosicionDadaEIgnoraLasPosicionesANoAdyacentes(){

        Tablero tablero = new Tablero();

        Jinete pieza = Mockito.mock(Jinete.class);
        Mockito.when(pieza.getUbicacion()).thenReturn(new Ubicacion(1,1));

        tablero.ocuparCasilla(pieza, 1,1);
        tablero.ocuparCasilla(pieza, 0,0);
        tablero.ocuparCasilla(pieza, 0,1);
        tablero.ocuparCasilla(pieza, 1,0);
        tablero.ocuparCasilla(pieza, 2,2);
        tablero.ocuparCasilla(pieza, 2,0);
        tablero.ocuparCasilla(pieza, 0,2);

        tablero.ocuparCasilla(pieza, 6,7);
        tablero.ocuparCasilla(pieza, 8,8);

        assertEquals(6,tablero.getPiezasAdyacentes(pieza.getUbicacion()).size());
    }

    @Test
    public void test07TableroEncuentra8PiezasAdyacentesQueFormanUnCuadradoYNoCuentaDeMas(){
        Tablero tablero = new Tablero();

        Jinete pieza = Mockito.mock(Jinete.class);
        Mockito.when(pieza.getUbicacion()).thenReturn(new Ubicacion(1,1));

        tablero.ocuparCasilla(pieza, 1,1);
        tablero.ocuparCasilla(pieza, 1,2);
        tablero.ocuparCasilla(pieza, 2,1);
        tablero.ocuparCasilla(pieza, 1,0);
        tablero.ocuparCasilla(pieza, 0,1);
        tablero.ocuparCasilla(pieza, 2,0);
        tablero.ocuparCasilla(pieza, 0,2);
        tablero.ocuparCasilla(pieza, 0,0);
        tablero.ocuparCasilla(pieza, 2,2);

        assertEquals(8,tablero.getPiezasAdyacentes(pieza.getUbicacion()).size());
    }

    @Test
    public void test08TableroEncuentra2PiezasAdyacentesNoHayProblemaEnEsquinas(){
        Tablero tablero = new Tablero();

        Jinete pieza = Mockito.mock(Jinete.class);
        Mockito.when(pieza.getUbicacion()).thenReturn(new Ubicacion(1,1));

        tablero.ocuparCasilla(pieza, 0,0);
        tablero.ocuparCasilla(pieza, 1,1);
        tablero.ocuparCasilla(pieza, 0,1);

        assertEquals(2,tablero.getPiezasAdyacentes(pieza.getUbicacion()).size());
    }


    @Test
    public void test09TableroEncuentra8CasillerosAdyacenctesVacios(){

        Tablero tablero = new Tablero();

        Jinete pieza = Mockito.mock(Jinete.class);
        Mockito.when(pieza.getUbicacion()).thenReturn(new Ubicacion(2,2));

        tablero.ocuparCasilla(pieza, 2,2);

        List<Casilla> casillas = tablero.getCasillasVaciasAdyacentes( pieza.getUbicacion() );
        assertEquals(8, casillas.size());
    }

    @Test
    public void test10TableroEncuentra3CasillerosAdyacenctesVaciosNoHayProblemaEnEsquinas(){

        Tablero tablero = new Tablero();

        Ubicacion ubicacion = new Ubicacion(0,0);
        Jinete pieza = Mockito.mock(Jinete.class);
        Mockito.when(pieza.getUbicacion()).thenReturn( ubicacion );

        tablero.ocuparCasilla(pieza, 0, 0);

        assertEquals(3, tablero.getCasillasVaciasAdyacentes( pieza.getUbicacion() ).size() );
    }

    @Test
    public void test11TableroNoHaceBucleInfinitoAlBuscarPiezasDeFormaRecursivaYEncuentra4(){

        Tablero tablero = new Tablero();

        Jinete pieza1 = Mockito.mock(Jinete.class);
        Mockito.when(pieza1.getUbicacion()).thenReturn(new Ubicacion(0,0));

        Jinete pieza2 = Mockito.mock(Jinete.class);
        Mockito.when(pieza2.getUbicacion()).thenReturn(new Ubicacion(1,0));

        Jinete pieza3 = Mockito.mock(Jinete.class);
        Mockito.when(pieza3.getUbicacion()).thenReturn(new Ubicacion(0,1));

        Jinete pieza4 = Mockito.mock(Jinete.class);
        Mockito.when(pieza4.getUbicacion()).thenReturn(new Ubicacion(1,1));

        tablero.ocuparCasilla(pieza1, 0, 0);
        tablero.ocuparCasilla(pieza2, 1, 0);
        tablero.ocuparCasilla(pieza3, 0, 1);
        tablero.ocuparCasilla(pieza4, 1, 1);

        assertEquals(4, tablero.getPiezasAdycentesInfinitas( pieza1.getUbicacion() ).size() );
    }

    @Test
    public void test12TableroBuscaPiezasDeFormaRecursivaYEncuentra8(){

        Tablero tablero = new Tablero();

        Jinete pieza1 = Mockito.mock(Jinete.class);
        Mockito.when(pieza1.getUbicacion()).thenReturn(new Ubicacion(0,0));
        Jinete pieza2 = Mockito.mock(Jinete.class);
        Mockito.when(pieza2.getUbicacion()).thenReturn(new Ubicacion(1,0));
        Jinete pieza3 = Mockito.mock(Jinete.class);
        Mockito.when(pieza3.getUbicacion()).thenReturn(new Ubicacion(2,0));
        Jinete pieza4 = Mockito.mock(Jinete.class);
        Mockito.when(pieza4.getUbicacion()).thenReturn(new Ubicacion(3,0));
        Jinete pieza5 = Mockito.mock(Jinete.class);
        Mockito.when(pieza5.getUbicacion()).thenReturn(new Ubicacion(4,0));
        Jinete pieza6 = Mockito.mock(Jinete.class);
        Mockito.when(pieza6.getUbicacion()).thenReturn(new Ubicacion(4,1));
        Jinete pieza7 = Mockito.mock(Jinete.class);
        Mockito.when(pieza7.getUbicacion()).thenReturn(new Ubicacion(4,2));
        Jinete pieza8 = Mockito.mock(Jinete.class);
        Mockito.when(pieza8.getUbicacion()).thenReturn(new Ubicacion(5,2));

        tablero.ocuparCasilla(pieza1, 0, 0);
        tablero.ocuparCasilla(pieza2, 1, 0);
        tablero.ocuparCasilla(pieza3, 2, 0);
        tablero.ocuparCasilla(pieza4, 3, 0);
        tablero.ocuparCasilla(pieza5, 4, 0);
        tablero.ocuparCasilla(pieza6, 4, 1);
        tablero.ocuparCasilla(pieza7, 4, 2);
        tablero.ocuparCasilla(pieza8, 5, 2);

        assertEquals(8, tablero.getPiezasAdycentesInfinitas( pieza1.getUbicacion() ).size() );
    }

}

