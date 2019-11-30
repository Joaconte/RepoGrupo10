package modelo.tablero;

import modelo.pieza.Ubicacion;
import modelo.pieza.tipos.Jinete;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.mockito.Mockito;
import modelo.pieza.Pieza;
import modelo.tablero.casilla.Casilla;

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

        Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacion.getPosicionEnY()).thenReturn(1);
        Mockito.when(ubicacion.getPosicionEnX()).thenReturn(1);

        Mockito.when(pieza.getUbicacion()).thenReturn(ubicacion);

        //Adyacentes
        tablero.ocuparCasilla(pieza, 1,1);
        tablero.ocuparCasilla(pieza, 0,0);
        tablero.ocuparCasilla(pieza, 0,1);
        tablero.ocuparCasilla(pieza, 1,0);
        tablero.ocuparCasilla(pieza, 2,2);
        tablero.ocuparCasilla(pieza, 2,0);
        tablero.ocuparCasilla(pieza, 0,2);

        //No Adyacentes
        tablero.ocuparCasilla(pieza, 6,7);
        tablero.ocuparCasilla(pieza, 8,8);

        assertEquals(6,tablero.getPiezasAdyacentes(pieza.getUbicacion()).size());
    }

    @Test
    public void test07TableroEncuentra8PiezasAdyacentesQueFormanUnCuadradoYNoCuentaDeMas(){
        Tablero tablero = new Tablero();

        Jinete pieza = Mockito.mock(Jinete.class);
        Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacion.getPosicionEnY()).thenReturn(1);
        Mockito.when(ubicacion.getPosicionEnX()).thenReturn(1);
        Mockito.when(pieza.getUbicacion()).thenReturn(ubicacion);

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
        Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacion.getPosicionEnY()).thenReturn(1);
        Mockito.when(ubicacion.getPosicionEnX()).thenReturn(1);
        Mockito.when(pieza.getUbicacion()).thenReturn(ubicacion);

        tablero.ocuparCasilla(pieza, 0,0);
        tablero.ocuparCasilla(pieza, 1,1);
        tablero.ocuparCasilla(pieza, 0,1);

        assertEquals(2,tablero.getPiezasAdyacentes(pieza.getUbicacion()).size());
    }


    @Test
    public void test09TableroEncuentra8CasillerosAdyacenctesVacios(){

        Tablero tablero = new Tablero();

        Jinete pieza = Mockito.mock(Jinete.class);
        Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacion.getPosicionEnY()).thenReturn(2);
        Mockito.when(ubicacion.getPosicionEnX()).thenReturn(2);
        Mockito.when(pieza.getUbicacion()).thenReturn(ubicacion);

        tablero.ocuparCasilla(pieza, 2,2);

        List<Casilla> casillas = tablero.getCasillasVaciasAdyacentes( pieza.getUbicacion() );
        assertEquals(8, casillas.size());
    }

    @Test
    public void test10TableroEncuentra3CasillerosAdyacenctesVaciosNoHayProblemaEnEsquinas(){

        Tablero tablero = new Tablero();

        Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacion.getPosicionEnY()).thenReturn(0);
        Mockito.when(ubicacion.getPosicionEnX()).thenReturn(0);

        Jinete pieza = Mockito.mock(Jinete.class);
        Mockito.when(pieza.getUbicacion()).thenReturn( ubicacion );

        tablero.ocuparCasilla(pieza, 0, 0);

        assertEquals(3, tablero.getCasillasVaciasAdyacentes( pieza.getUbicacion() ).size() );
    }

    @Test
    public void test11TableroNoHaceBucleInfinitoAlBuscarPiezasDeFormaRecursivaYEncuentra4(){

        Tablero tablero = new Tablero();

        //-----------Mocks Piezas------------------
        Jinete pieza1 = Mockito.mock(Jinete.class);
        Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacion.getPosicionEnX()).thenReturn(0);
        Mockito.when(ubicacion.getPosicionEnY()).thenReturn(0);
        Mockito.when(pieza1.getUbicacion()).thenReturn(ubicacion);

        Jinete pieza2 = Mockito.mock(Jinete.class);
        Ubicacion ubicacionDos = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacionDos.getPosicionEnX()).thenReturn(1);
        Mockito.when(ubicacionDos.getPosicionEnY()).thenReturn(0);
        Mockito.when(pieza2.getUbicacion()).thenReturn(ubicacionDos);

        Jinete pieza3 = Mockito.mock(Jinete.class);
        Ubicacion ubicacionTres = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacionTres.getPosicionEnX()).thenReturn(0);
        Mockito.when(ubicacionTres.getPosicionEnY()).thenReturn(1);
        Mockito.when(pieza3.getUbicacion()).thenReturn(ubicacionTres);

        Jinete pieza4 = Mockito.mock(Jinete.class);
        Ubicacion ubicacionCuatro = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacionCuatro.getPosicionEnX()).thenReturn(1);
        Mockito.when(ubicacionCuatro.getPosicionEnY()).thenReturn(1);
        Mockito.when(pieza4.getUbicacion()).thenReturn(ubicacionCuatro);

        //-----------Ocupar Tablero------------------

        tablero.ocuparCasilla(pieza1, 0, 0);
        tablero.ocuparCasilla(pieza2, 1, 0);
        tablero.ocuparCasilla(pieza3, 0, 1);
        tablero.ocuparCasilla(pieza4, 1, 1);

        assertEquals(4, tablero.getPiezasAdycentesInfinitas( pieza1.getUbicacion() ).size() );
    }

    @Test
    public void test12TableroBuscaPiezasDeFormaRecursivaYEncuentra8(){

        Tablero tablero = new Tablero();

        //-----------Mocks Piezas------------------
        Jinete piezaAdyacente1 = Mockito.mock(Jinete.class);
        Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacion.getPosicionEnX()).thenReturn(0);
        Mockito.when(ubicacion.getPosicionEnY()).thenReturn(0);
        Mockito.when(piezaAdyacente1.getUbicacion()).thenReturn(ubicacion);

        Jinete piezaAdyacente2 = Mockito.mock(Jinete.class);
        Ubicacion ubicacionDos = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacionDos.getPosicionEnX()).thenReturn(1);
        Mockito.when(ubicacionDos.getPosicionEnY()).thenReturn(0);
        Mockito.when(piezaAdyacente2.getUbicacion()).thenReturn(ubicacionDos);

        Jinete piezaAdyacente3 = Mockito.mock(Jinete.class);
        Ubicacion ubicacionTres = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacionTres.getPosicionEnX()).thenReturn(2);
        Mockito.when(ubicacionTres.getPosicionEnY()).thenReturn(0);
        Mockito.when(piezaAdyacente3.getUbicacion()).thenReturn(ubicacionTres);

        Jinete piezaAdyacente4 = Mockito.mock(Jinete.class);
        Ubicacion ubicacionCuatro = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacionCuatro.getPosicionEnX()).thenReturn(3);
        Mockito.when(ubicacionCuatro.getPosicionEnY()).thenReturn(0);
        Mockito.when(piezaAdyacente4.getUbicacion()).thenReturn(ubicacionCuatro);

        Jinete piezaAdyacente5 = Mockito.mock(Jinete.class);
        Ubicacion ubicacionCinco = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacionCinco.getPosicionEnX()).thenReturn(4);
        Mockito.when(ubicacionCinco.getPosicionEnY()).thenReturn(0);
        Mockito.when(piezaAdyacente5.getUbicacion()).thenReturn(ubicacionCinco);

        Jinete piezaAdaycente6 = Mockito.mock(Jinete.class);
        Ubicacion ubicacionSeis = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacionSeis.getPosicionEnX()).thenReturn(4);
        Mockito.when(ubicacionSeis.getPosicionEnY()).thenReturn(1);
        Mockito.when(piezaAdaycente6.getUbicacion()).thenReturn(ubicacionSeis);

        Jinete piezaAdyacente7 = Mockito.mock(Jinete.class);
        Ubicacion ubicacionSiete = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacionSiete.getPosicionEnX()).thenReturn(4);
        Mockito.when(ubicacionSiete.getPosicionEnY()).thenReturn(2);
        Mockito.when(piezaAdyacente7.getUbicacion()).thenReturn(ubicacionSiete);

        Jinete piezaAdyacente8 = Mockito.mock(Jinete.class);
        Ubicacion ubicacionOcho = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacionOcho.getPosicionEnX()).thenReturn(5);
        Mockito.when(ubicacionOcho.getPosicionEnY()).thenReturn(2);
        Mockito.when(piezaAdyacente8.getUbicacion()).thenReturn(ubicacionOcho);

        //-----------Ocupar Tablero------------------

        tablero.ocuparCasilla(piezaAdyacente1, 0, 0);
        tablero.ocuparCasilla(piezaAdyacente2, 1, 0);
        tablero.ocuparCasilla(piezaAdyacente3, 2, 0);
        tablero.ocuparCasilla(piezaAdyacente4, 3, 0);
        tablero.ocuparCasilla(piezaAdyacente5, 4, 0);
        tablero.ocuparCasilla(piezaAdaycente6, 4, 1);
        tablero.ocuparCasilla(piezaAdyacente7, 4, 2);
        tablero.ocuparCasilla(piezaAdyacente8, 5, 2);

        assertEquals(8, tablero.getPiezasAdycentesInfinitas( piezaAdyacente1.getUbicacion() ).size() );
    }


    @Test
    public void test13BusquedaEnRangoDosSoloEncuentraLasFichasEnRangoDosCorrectamente(){

        Tablero tablero = new Tablero();

        //-----------Mocks Piezas------------------

        Jinete[] jinetesFila0 = new Jinete[5];
        for (int i = 0; i < 5; i++ ){
            jinetesFila0[i] = Mockito.mock(Jinete.class);
            Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
            Mockito.when(ubicacion.getPosicionEnX()).thenReturn(i);
            Mockito.when(ubicacion.getPosicionEnY()).thenReturn(0);
            Mockito.when(jinetesFila0[i].getUbicacion()).thenReturn(ubicacion);
            tablero.ocuparCasilla(jinetesFila0[i], i, 0);
        }

        Jinete[] jinetesFila1 = new Jinete[5];
        for (int i = 0; i < 5; i++ ){
            jinetesFila1[i] = Mockito.mock(Jinete.class);
            Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
            Mockito.when(ubicacion.getPosicionEnX()).thenReturn(i);
            Mockito.when(ubicacion.getPosicionEnY()).thenReturn(1);
            Mockito.when(jinetesFila1[i].getUbicacion()).thenReturn(ubicacion);
            tablero.ocuparCasilla(jinetesFila1[i], i, 1);
        }

        Jinete[] jinetesFila2 = new Jinete[5];
        for (int i = 0; i < 5; i++ ){
            jinetesFila2[i] = Mockito.mock(Jinete.class);
            Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
            Mockito.when(ubicacion.getPosicionEnX()).thenReturn(i);
            Mockito.when(ubicacion.getPosicionEnY()).thenReturn(2);
            Mockito.when(jinetesFila2[i].getUbicacion()).thenReturn(ubicacion);
            tablero.ocuparCasilla(jinetesFila2[i], i, 2);
        }

        Jinete[] jinetesFila3 = new Jinete[5];
        for (int i = 0; i < 5; i++ ){
            jinetesFila3[i] = Mockito.mock(Jinete.class);
            Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
            Mockito.when(ubicacion.getPosicionEnX()).thenReturn(i);
            Mockito.when(ubicacion.getPosicionEnY()).thenReturn(3);
            Mockito.when(jinetesFila3[i].getUbicacion()).thenReturn(ubicacion);
            tablero.ocuparCasilla(jinetesFila3[i], i, 3);
        }

        Jinete[] jinetesFila4 = new Jinete[5];
        for (int i = 0; i < 5; i++ ){
            jinetesFila4[i] = Mockito.mock(Jinete.class);
            Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
            Mockito.when(ubicacion.getPosicionEnX()).thenReturn(i);
            Mockito.when(ubicacion.getPosicionEnY()).thenReturn(4);
            Mockito.when(jinetesFila4[i].getUbicacion()).thenReturn(ubicacion);
            tablero.ocuparCasilla(jinetesFila4[i], i, 4);
        }

        //No adyacentes

        Jinete[] jinetesFila5 = new Jinete[5];
        for (int i = 0; i < 5; i++ ){
            jinetesFila5[i] = Mockito.mock(Jinete.class);
            Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
            Mockito.when(ubicacion.getPosicionEnX()).thenReturn(i);
            Mockito.when(ubicacion.getPosicionEnY()).thenReturn(5);
            Mockito.when(jinetesFila5[i].getUbicacion()).thenReturn(ubicacion);
            tablero.ocuparCasilla(jinetesFila5[i], i, 5);
        }


        Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacion.getPosicionEnX()).thenReturn(2);
        Mockito.when(ubicacion.getPosicionEnY()).thenReturn(2);

        assertEquals(24, tablero.getPiezasEntreRangos(  ubicacion,0,2 ).size() );
    }

}

