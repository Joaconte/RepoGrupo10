package modelo.jugador;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class JugadorTest {


    @Test
    public void test01SeAgregaNumeroDeJugadorCorrectamente(){

        Jugador jugador = new Jugador(1);

        assertEquals(1, jugador.getNumeroDeJugador() );
    }

    @Test
    public void test02SeAgregaSectorCorrectamente(){

        Jugador jugador = new Jugador(1);

        assertEquals( 0 , jugador.getSector().getPrimeraPos());
        assertEquals( 9 , jugador.getSector().getUltimaPos());
    }




   /* @Test(expected = UbicacionInvalidaException.class)
    public void test09PosicionDeUnidadOcupadaExceptionThrown() throws UbicacionInvalidaException{

        Sector sector = Mockito.mock( Sector.class );
        Jugador modelo.jugador = new Jugador(1,sector );
        Unidad unidad = Mockito.mock(Unidad.class);
        Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
        Unidad unidad2 = Mockito.mock(Unidad.class);
        Mockito.when(ubicacion.darPosicionEnX()).thenReturn(2);
        Mockito.when(ubicacion.darPosicionEnY()).thenReturn(2);

        modelo.jugador.agregarUbicacionAUnidad( unidad, ubicacion );

        try { modelo.jugador.agregarUnidad(unidad);
        } catch (JugadorSinPuntosException e) {   }

        modelo.jugador.agregarUbicacionAUnidad( unidad2, ubicacion );

        assertEquals( 1 , modelo.jugador.getEjercito().size());
    }
    */
}
