package modelo.tablero;

import modelo.pieza.movimiento.Ubicacion;
import modelo.pieza.tipos.Jinete;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


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
    public void test04TableroEncuentra6PiezasAdyacenctesAPosicionDadaEIgnoraLasPosicionesANoAdyacentes(){

        Tablero tablero = new Tablero();

        Jinete pieza = Mockito.mock(Jinete.class);


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

        assertEquals(6,tablero.getPiezasAdyacentes(1,1).size());
    }

    @Test
    public void test05TableroEncuentra8PiezasAdyacentesQueFormanUnCuadradoYNoCuentaDeMas(){
        Tablero tablero = new Tablero();

        Jinete pieza = Mockito.mock(Jinete.class);

        tablero.ocuparCasilla(pieza, 1,1);
        tablero.ocuparCasilla(pieza, 1,2);
        tablero.ocuparCasilla(pieza, 2,1);
        tablero.ocuparCasilla(pieza, 1,0);
        tablero.ocuparCasilla(pieza, 0,1);
        tablero.ocuparCasilla(pieza, 2,0);
        tablero.ocuparCasilla(pieza, 0,2);
        tablero.ocuparCasilla(pieza, 0,0);
        tablero.ocuparCasilla(pieza, 2,2);

        assertEquals(8,tablero.getPiezasAdyacentes(1,1).size());
    }

    @Test
    public void test06TableroEncuentra2PiezasAdyacentesNoHayProblemaEnEsquinas(){
        Tablero tablero = new Tablero();

        Jinete pieza = Mockito.mock(Jinete.class);
        Mockito.when(pieza.getPosicionEnFilaQueOcupa()).thenReturn(1);
        Mockito.when(pieza.getPosicionEnColumnaQueOcupa()).thenReturn(1);

        tablero.ocuparCasilla(pieza, 0,0);
        tablero.ocuparCasilla(pieza, 1,1);
        tablero.ocuparCasilla(pieza, 0,1);

        assertEquals(2,tablero.getPiezasAdyacentes(pieza.getPosicionEnColumnaQueOcupa(),pieza.getPosicionEnFilaQueOcupa()).size());
    }


    @Test
    public void test07TableroNoHaceBucleInfinitoAlBuscarPiezasDeFormaRecursivaYEncuentra4(){

        Tablero tablero = new Tablero();

        //-----------Mocks Piezas------------------
        Jinete pieza1 = Mockito.mock(Jinete.class);
        Mockito.when(pieza1.getPosicionEnFilaQueOcupa()).thenReturn(0);
        Mockito.when(pieza1.getPosicionEnColumnaQueOcupa()).thenReturn(0);

        Jinete pieza2 = Mockito.mock(Jinete.class);
        Mockito.when(pieza1.getPosicionEnFilaQueOcupa()).thenReturn(1);
        Mockito.when(pieza1.getPosicionEnColumnaQueOcupa()).thenReturn(0);

        Jinete pieza3 = Mockito.mock(Jinete.class);
        Mockito.when(pieza1.getPosicionEnFilaQueOcupa()).thenReturn(0);
        Mockito.when(pieza1.getPosicionEnColumnaQueOcupa()).thenReturn(1);

        Jinete pieza4 = Mockito.mock(Jinete.class);
        Mockito.when(pieza1.getPosicionEnFilaQueOcupa()).thenReturn(1);
        Mockito.when(pieza1.getPosicionEnColumnaQueOcupa()).thenReturn(1);

        //-----------Ocupar Tablero------------------

        tablero.ocuparCasilla(pieza1, 0, 0);
        tablero.ocuparCasilla(pieza2, 1, 0);
        tablero.ocuparCasilla(pieza3, 0, 1);
        tablero.ocuparCasilla(pieza4, 1, 1);

        assertEquals(4, tablero.getPiezasAdycentesInfinitas( pieza1.getPosicionEnColumnaQueOcupa(),pieza1.getPosicionEnFilaQueOcupa() ).size() );
    }

    @Test
    public void test08TableroBuscaPiezasDeFormaRecursivaYEncuentra8(){

        Tablero tablero = new Tablero();

        //-----------Mocks Piezas------------------
        Jinete piezaAdyacente1 = Mockito.mock(Jinete.class);
        Mockito.when(piezaAdyacente1.getPosicionEnColumnaQueOcupa()).thenReturn(0);
        Mockito.when(piezaAdyacente1.getPosicionEnFilaQueOcupa()).thenReturn(0);

        Jinete piezaAdyacente2 = Mockito.mock(Jinete.class);
        Mockito.when(piezaAdyacente2.getPosicionEnColumnaQueOcupa()).thenReturn(1);
        Mockito.when(piezaAdyacente2.getPosicionEnFilaQueOcupa()).thenReturn(0);

        Jinete piezaAdyacente3 = Mockito.mock(Jinete.class);
        Mockito.when(piezaAdyacente3.getPosicionEnColumnaQueOcupa()).thenReturn(2);
        Mockito.when(piezaAdyacente3.getPosicionEnFilaQueOcupa()).thenReturn(0);

        Jinete piezaAdyacente4 = Mockito.mock(Jinete.class);
        Mockito.when(piezaAdyacente4.getPosicionEnColumnaQueOcupa()).thenReturn(3);
        Mockito.when(piezaAdyacente4.getPosicionEnFilaQueOcupa()).thenReturn(0);

        Jinete piezaAdyacente5 = Mockito.mock(Jinete.class);
        Mockito.when(piezaAdyacente5.getPosicionEnColumnaQueOcupa()).thenReturn(4);
        Mockito.when(piezaAdyacente5.getPosicionEnFilaQueOcupa()).thenReturn(0);

        Jinete piezaAdyacente6 = Mockito.mock(Jinete.class);
        Mockito.when(piezaAdyacente6.getPosicionEnColumnaQueOcupa()).thenReturn(4);
        Mockito.when(piezaAdyacente6.getPosicionEnFilaQueOcupa()).thenReturn(1);

        Jinete piezaAdyacente7 = Mockito.mock(Jinete.class);
        Mockito.when(piezaAdyacente7.getPosicionEnColumnaQueOcupa()).thenReturn(4);
        Mockito.when(piezaAdyacente7.getPosicionEnFilaQueOcupa()).thenReturn(2);

        Jinete piezaAdyacente8 = Mockito.mock(Jinete.class);
        Mockito.when(piezaAdyacente8.getPosicionEnColumnaQueOcupa()).thenReturn(5);
        Mockito.when(piezaAdyacente8.getPosicionEnFilaQueOcupa()).thenReturn(2);

        //-----------Ocupar Tablero------------------

        tablero.ocuparCasilla(piezaAdyacente1, 0, 0);
        tablero.ocuparCasilla(piezaAdyacente2, 1, 0);
        tablero.ocuparCasilla(piezaAdyacente3, 2, 0);
        tablero.ocuparCasilla(piezaAdyacente4, 3, 0);
        tablero.ocuparCasilla(piezaAdyacente5, 4, 0);
        tablero.ocuparCasilla(piezaAdyacente6, 4, 1);
        tablero.ocuparCasilla(piezaAdyacente7, 4, 2);
        tablero.ocuparCasilla(piezaAdyacente8, 5, 2);

        assertEquals(8, tablero.getPiezasAdycentesInfinitas( 0,0 ).size() );
    }


    @Test
    public void test09BusquedaEnRangoDosSoloEncuentraLasFichasEnRangoDosCorrectamente(){

        Tablero tablero = new Tablero();

        //-----------Mocks Piezas------------------

        for (int i = 0; i < 5; i++ ){
            tablero.ocuparCasilla(new Jinete(1,i,0), i, 0);
        }

        for (int i = 0; i < 5; i++ ){
            tablero.ocuparCasilla(new Jinete(1,i,1), i, 1);
        }

        for (int i = 0; i < 5; i++ ){
            tablero.ocuparCasilla(new Jinete(1,i,2), i, 2);
        }

        for (int i = 0; i < 5; i++ ){
            tablero.ocuparCasilla(new Jinete(1,i,3), i, 3);
        }

        for (int i = 0; i < 5; i++ ){
            tablero.ocuparCasilla(new Jinete(1,i,4), i, 4);

        }

        //No adyacentes

        for (int i = 0; i < 5; i++ ){
            tablero.ocuparCasilla(new Jinete(1,i,5), i, 5);
        }


        //Pos a evaluar: 2, 2

        assertEquals(24, tablero.getPiezasAdyacentesDentroDeRadio(  2,2,2 ).size() );
    }

}

