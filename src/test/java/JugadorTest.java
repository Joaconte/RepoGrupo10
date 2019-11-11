package test;

import fiuba.algo3.TP2.exception.UbicacionInvalidaException;
import fiuba.algo3.TP2.model.*;

import org.mockito.Mockito;
import org.mockito.Mock;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class JugadorTest {


    @Test
    public void test01SeAgregaNombreCorrectamente(){

        Sector sectorMock = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador("Jorge",sectorMock );

        assertEquals("Jorge", jugador.getNombre() );
    }

    @Test
    public void test02SeAgregaSectorCorrectamente(){

        Sector sector = new Sector(0, 9);
        Jugador jugador = new Jugador("Jorge",sector );

        assertEquals( sector , jugador.getSector());
    }


    @Test
    public void test03EjercitoAgrega5UnidadesCorrectamenteCuandoSeCompran(){

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador("Jorge",sector );
        jugador.agregarUnidad(4);
        jugador.agregarUnidad(4);
        jugador.agregarUnidad(4);
        jugador.agregarUnidad(4);
        jugador.agregarUnidad(3);
        assertEquals( 5 , jugador.getTamanioDelEjercito() );
    }

    @Test
    public void test04ConPresupuestoIgualAUnoNoPuedoComprarUnaUnidadDeValorTres() {

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador("Jorge",sector );

        jugador.agregarUnidad(4);
        jugador.agregarUnidad(4);
        jugador.agregarUnidad(4);
        jugador.agregarUnidad(4);
        jugador.agregarUnidad(3);
        //Presupuesto = 19
        jugador.agregarUnidad(3);

        assertEquals( 5 , jugador.getTamanioDelEjercito());

    }

/*      @Test
    public void test04LeResto10PuntosAlJugador() {

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador("Jorge",sector );
        try {
            jugador.descontarPuntos(10);
        } catch (PuntosInsuficientesException e) { }
        assertEquals( (20-10) , jugador.getPuntos() );
    }

 */

    @Test
    public void test05ConPresupuestoIgualACeroNoComproNadaMas() {

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador("Jorge",sector );

        jugador.agregarUnidad(4);
        jugador.agregarUnidad(4);
        jugador.agregarUnidad(4);
        jugador.agregarUnidad(4);
        jugador.agregarUnidad(4);
        //Presupuesto = 20
        jugador.agregarUnidad(1);
        jugador.agregarUnidad(2);
        jugador.agregarUnidad(3);
        jugador.agregarUnidad(4);
        assertEquals( 5 , jugador.getTamanioDelEjercito());

    }

    @Test
    public void test06AgregoUnidadYLaBorroCorrectamente(){

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador("Jorge",sector );
        jugador.agregarUnidad(3);
        jugador.quitarUnidad(0);

        assertEquals( 0 , jugador.getTamanioDelEjercito() );

    }

    @Test
    public void test07AgregoCuatroUnidadesYLasSacoEnCualquierOrdenCorrectamente(){

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador("Jorge",sector );
        jugador.agregarUnidad(3);
        jugador.agregarUnidad(1);
        jugador.agregarUnidad(2);
        jugador.agregarUnidad(4);

        jugador.quitarUnidad(3);
        jugador.quitarUnidad(2);
        jugador.quitarUnidad(0);
        jugador.quitarUnidad(0);

        assertEquals( 0 , jugador.getTamanioDelEjercito() );

    }

   /* @Test(expected = UbicacionInvalidaException.class)
    public void test09PosicionDeUnidadOcupadaExceptionThrown() throws UbicacionInvalidaException{

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador("Jorge",sector );
        Unidad unidad = Mockito.mock(Unidad.class);
        Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
        Unidad unidad2 = Mockito.mock(Unidad.class);
        Mockito.when(ubicacion.darPosicionEnX()).thenReturn(2);
        Mockito.when(ubicacion.darPosicionEnY()).thenReturn(2);

        jugador.agregarUbicacionAUnidad( unidad, ubicacion );

        try { jugador.agregarUnidad(unidad);
        } catch (JugadorSinPuntosException e) {   }

        jugador.agregarUbicacionAUnidad( unidad2, ubicacion );

        assertEquals( 1 , jugador.getEjercito().size());
    }
    */
}
