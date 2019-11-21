package tablero;

import pieza.Ubicacion;
import pieza.tipos.Jinete;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import org.mockito.Mockito;
import pieza.Pieza;


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
        assertEquals("Libre",tablero.getEstadoCasilla(1, 1));
    }

    @Test
    public void test04ElEstadoDeUnaCasillaLibreALaQueOcupoPasaAOcupado(){
        Tablero tablero = new Tablero();
        Pieza pieza = Mockito.mock(Pieza.class);
        tablero.ocuparCasilla(pieza, 3,4);
        assertEquals("Ocupada",tablero.getEstadoCasilla(3, 4));
    }

    @Test
    public void test05ElEstadoDeUnaCasillaALaQueOcupoPasaADesocupadaCuandoLaDesocupo(){
        Tablero tablero = new Tablero();
        Pieza pieza = Mockito.mock(Pieza.class);
        tablero.ocuparCasilla(pieza, 1,1);
        tablero.desocuparCasilla(1,1);
        assertEquals("Libre",tablero.getEstadoCasilla(1, 1));
    }

    @Test
    public void test06TableroEncuentra6PiezasAdyacenctesAPosicionDadaEIgnoraLasPosicionesANoAdyacentes(){

        Tablero tablero = new Tablero();

        Jinete pieza = Mockito.mock(Jinete.class);
        Mockito.when(pieza.getUbicacion()).thenReturn(new Ubicacion(1,1));
        Jinete pieza2 = Mockito.mock(Jinete.class);
        Jinete pieza3 = Mockito.mock(Jinete.class);
        Jinete pieza4 = Mockito.mock(Jinete.class);
        Jinete pieza5 = Mockito.mock(Jinete.class);
        Jinete pieza6 = Mockito.mock(Jinete.class);

        tablero.ocuparCasilla(pieza, 1,1);
        tablero.ocuparCasilla(pieza2, 1,2);
        tablero.ocuparCasilla(pieza3, 3,2);
        tablero.ocuparCasilla(pieza4, 2,1);
        tablero.ocuparCasilla(pieza5, 3,3);
        tablero.ocuparCasilla(pieza6, 4,4);

        Jinete pieza7 = Mockito.mock(Jinete.class);
        Jinete pieza8 = Mockito.mock(Jinete.class);

        tablero.ocuparCasilla(pieza7, 6,7);
        tablero.ocuparCasilla(pieza8, 8,8);

        assertEquals(6,tablero.getPiezasEnAdyacencia(pieza.getUbicacion()).size());
    }

    @Test
    public void test07TableroEncuentra8PiezasAdyacentesQueFormanUnCuadradoYNoCuentaDeMas(){
        Tablero tablero = new Tablero();

        Jinete pieza = Mockito.mock(Jinete.class);
        Mockito.when(pieza.getUbicacion()).thenReturn(new Ubicacion(1,1));
        Jinete pieza2 = Mockito.mock(Jinete.class);
        Jinete pieza3 = Mockito.mock(Jinete.class);
        Jinete pieza4 = Mockito.mock(Jinete.class);
        Jinete pieza5 = Mockito.mock(Jinete.class);
        Jinete pieza6 = Mockito.mock(Jinete.class);
        Jinete pieza7 = Mockito.mock(Jinete.class);
        Jinete pieza8 = Mockito.mock(Jinete.class);

        tablero.ocuparCasilla(pieza, 1,1);
        tablero.ocuparCasilla(pieza2, 1,2);
        tablero.ocuparCasilla(pieza3, 1,3);
        tablero.ocuparCasilla(pieza4, 2,3);
        tablero.ocuparCasilla(pieza5, 3,3);
        tablero.ocuparCasilla(pieza6, 3,2);
        tablero.ocuparCasilla(pieza7, 3,1);
        tablero.ocuparCasilla(pieza8, 2,1);

        assertEquals(8,tablero.getPiezasEnAdyacencia(pieza.getUbicacion()).size());
    }

    @Test
    public void test08TableroEncuentra8CasillerosAdyacenctesVacios(){

        Tablero tablero = new Tablero();

        Jinete pieza = Mockito.mock(Jinete.class);
        Mockito.when(pieza.getUbicacion()).thenReturn(new Ubicacion(2,2));

        tablero.ocuparCasilla(pieza, 2,2);

        assertEquals(8, tablero.getCasillasLibresEnAdyacencia( pieza.getUbicacion() ).size() );
    }

    @Test
    public void test09TableroEncuentra5CasillerosAdyacenctesVaciosNoHayProblemaEnBordes(){

        Tablero tablero = new Tablero();

        Ubicacion ubicacion = new Ubicacion(2,1);
        Jinete pieza = Mockito.mock(Jinete.class);
        Mockito.when(pieza.getUbicacion()).thenReturn( ubicacion );

        tablero.ocuparCasilla(pieza, 2, 1);

        assertEquals(5, tablero.getCasillasLibresEnAdyacencia( pieza.getUbicacion() ).size() );
    }
    //PROBLEMA EN LA PRIMERA COLUMNA (ENCUENTRA UNA CASILLA EXTRA)


}

