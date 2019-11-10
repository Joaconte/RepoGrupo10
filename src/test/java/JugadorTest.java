package test;

import fiuba.algo3.TP2.exception.JugadorSinPuntosException;
import fiuba.algo3.TP2.exception.PuntosInsuficientesException;
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


    @Test(expected = PuntosInsuficientesException.class)
    public void test03PuntosInsuficientesExceptionThrown() throws PuntosInsuficientesException {

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador("Jorge",sector );
        jugador.descontarPuntos(21);
    }

    @Test
    public void test04LeResto10PuntosAlJugador() {

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador("Jorge",sector );
        try {
            jugador.descontarPuntos(10);
        } catch (PuntosInsuficientesException e) { }
        assertEquals( (20-10) , jugador.getPuntos() );
    }

    @Test(expected = JugadorSinPuntosException.class)
    public void test05JugadorSinPuntosExceptionThrown() throws JugadorSinPuntosException {

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador("Jorge",sector );
        Pieza unidadMock = Mockito.mock(Pieza.class);
        Mockito.when(unidadMock.getCosto()).thenReturn(4);

        try { jugador.descontarPuntos(20);
        }catch (PuntosInsuficientesException e) {  }

        jugador.agregarUnidad(unidadMock);
    }

    @Test
    public void test06AgregoUnidadAlEjercitoCorrectamente(){

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador("Jorge",sector );
        Pieza unidadMock = Mockito.mock(Pieza.class);
        Mockito.when(unidadMock.getCosto()).thenReturn(4);

        try { jugador.agregarUnidad(unidadMock);
        }catch (JugadorSinPuntosException e) {  }

        assertEquals( unidadMock, jugador.getEjercito().get(0));
    }

    @Test
    public void test07SeDescuentanPuntosAlAgregarUnidadAlEjercito() {

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador("Jorge",sector );
        Pieza unidadMock = Mockito.mock(Pieza.class);
        Mockito.when(unidadMock.getCosto()).thenReturn(4);
        try { jugador.agregarUnidad(unidadMock);
        } catch (JugadorSinPuntosException e) {   }

        assertEquals( (20 - 4) , jugador.getPuntos() );
    }

    @Test
    public void test08JugadorSeQuedaSinUnidades(){

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador("Jorge",sector );
        Pieza unidadMock = Mockito.mock(Pieza.class);
        Mockito.when(unidadMock.getCosto()).thenReturn(4);

        Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacion.darPosicionEnX()).thenReturn(2);
        Mockito.when(ubicacion.darPosicionEnY()).thenReturn(2);

        try { jugador.agregarUnidad(unidadMock);
        } catch (JugadorSinPuntosException e) {   }

        jugador.getEjercito().remove(0);

        assertFalse(jugador.tieneEjercito());

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
