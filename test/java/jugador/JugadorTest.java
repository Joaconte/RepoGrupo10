package jugador;

import jugador.*;
import jugador.presupuesto.EstadoPresupuestoNoAgotado;
import org.mockito.Mockito;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class JugadorTest {


    @Test
    public void test01SeAgregaNumeroDeJugadorCorrectamente(){

        Sector sectorMock = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador(1,sectorMock );

        assertEquals(1, jugador.getNumeroDeJugador() );
    }

    @Test
    public void test02SeAgregaSectorCorrectamente(){

        Sector sector = new Sector(0, 9);
        Jugador jugador = new Jugador(1,sector );

        assertEquals( sector , jugador.getSector());
    }


    @Test
    public void test03EjercitoAgrega5UnidadesCorrectamenteCuandoSeCompran(){

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador(1,sector );
        jugador.agregarUnidad(1);
        jugador.agregarUnidad(1);
        jugador.agregarUnidad(1);
        jugador.agregarUnidad(1);
        jugador.agregarUnidad(3);
        assertEquals( 5 , jugador.getTamanioDelEjercito() );
    }

    @Test
    public void test04ConPresupuestoIgualAUnoNoPuedoComprarUnaUnidadDeValorCuatroOTresODos() {

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador(1,sector );
        EstadoPresupuestoNoAgotado presupuestoEnUno =  new EstadoPresupuestoNoAgotado(1);
        jugador.setEstadoPresupuesto(presupuestoEnUno);

        jugador.agregarUnidad(5);
        jugador.agregarUnidad(3);
        jugador.agregarUnidad(2);
        assertEquals( 0 , jugador.getTamanioDelEjercito());
    }

    @Test
    public void test05ConPresupuestoIgualACeroNoComproNadaMas() {

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador(1,sector );
        EstadoPresupuestoNoAgotado presupuestoEnUno =  new EstadoPresupuestoNoAgotado(0);
        jugador.setEstadoPresupuesto(presupuestoEnUno);

        jugador.agregarUnidad(1);
        jugador.agregarUnidad(2);
        jugador.agregarUnidad(3);
        jugador.agregarUnidad(5);

        assertEquals( 0 , jugador.getTamanioDelEjercito());

    }

    @Test
    public void test06CostoEquivocadoNoAgregaNada(){

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador(1,sector );
        jugador.agregarUnidad(4);
        jugador.agregarUnidad(10);

        assertEquals( 0 , jugador.getTamanioDelEjercito() );

    }


   /* @Test(expected = UbicacionInvalidaException.class)
    public void test09PosicionDeUnidadOcupadaExceptionThrown() throws UbicacionInvalidaException{

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador(1,sector );
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
