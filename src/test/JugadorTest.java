package test;

import exception.JugadorSinPuntosException;
import exception.PuntosInsuficientesException;
import mock.UnidadMock;
import model.Jugador;
import model.Sector;

import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
        UnidadMock unidadMock = new UnidadMock();

        try { jugador.descontarPuntos(20);
        }catch (PuntosInsuficientesException e) {  }

        jugador.agregarUnidad(unidadMock);
    }

    @Test
    public void test06AgregoUnidadAlEjercitoCorrectamente(){

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador("Jorge",sector );
        UnidadMock unidadMock = new UnidadMock();

        try { jugador.agregarUnidad(unidadMock);
        }catch (JugadorSinPuntosException e) {  }

        assertEquals( unidadMock, jugador.getEjercito().get(0));
    }

    @Test
    public void test07SeDescuentanPuntosAlAgregarUnidadAlEjercito() {

        Sector sector = Mockito.mock( Sector.class );
        Jugador jugador = new Jugador("Jorge",sector );
        UnidadMock unidadMock = new UnidadMock(4);
        try { jugador.agregarUnidad(unidadMock);
        } catch (JugadorSinPuntosException e) {   }

        assertEquals( (20 - 4) , jugador.getPuntos() );
    }


}
