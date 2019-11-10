package test;

import fiuba.algo3.TP2.exception.CasillaNoTieneUnidadException;
import fiuba.algo3.TP2.exception.CasillaTieneUnidadException;
import fiuba.algo3.TP2.model.*;


import org.mockito.Mock;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.Mockito;

public class TableroTest {

    @Test
    public void test01TableroSeCreaConTamanioCorrecto(){


        Tablero tablero = new Tablero();
        tablero.crearTableroVacio();

        assertEquals(400,tablero.getTamanio());
    }
   @Test
   public void test02TableroSeCreaVacio(){


        Tablero tablero = new Tablero();
        tablero.crearTableroVacio();

        assertEquals(true,tablero.estaVacio());

    }


    @Test
    public void test03SeAgregaUnidadCorrectamente(){

        Tablero tablero = new Tablero();
        tablero.crearTableroVacio();
        Pieza unidadMock = Mockito.mock(Pieza.class);
        Ubicacion ubicacionMock = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacionMock.getPosicionX()).thenReturn(5);
        Mockito.when(ubicacionMock.getPosicionY()).thenReturn(10);

        try{ tablero.agregarUnidad(unidadMock,ubicacionMock);
        }catch(CasillaTieneUnidadException e){ }
        Pieza unidadMock2 = Mockito.mock(Pieza.class);

        try{ unidadMock2 = (tablero.buscarCasilla(5,10)).getUnidad();
         }catch(CasillaNoTieneUnidadException e){ }

        assertEquals(unidadMock,unidadMock2);
    }

    @Test(expected = CasillaTieneUnidadException.class)
    public void test04SeAgregaUnidadEnCasillaOcupadaLanzaExcepcion() throws CasillaTieneUnidadException{

        Tablero tablero = new Tablero();
        tablero.crearTableroVacio();
        Pieza unidadMock = Mockito.mock(Pieza.class);
        Pieza segundaUnidadMock = Mockito.mock(Pieza.class);
        Ubicacion ubicacionMock = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacionMock.getPosicionX()).thenReturn(5);
        Mockito.when(ubicacionMock.getPosicionY()).thenReturn(10);
        tablero.agregarUnidad(unidadMock,ubicacionMock);
        tablero.agregarUnidad(segundaUnidadMock,ubicacionMock);
    }
        /*try{assertEquals(unidadMock,(tablero.buscarCasilla(5,10)).getUnidad());;
        }catch(CasillaNoTieneUnidadException e){ }
        //assertEquals(unidadMock,(tablero.buscarCasilla(5,10)).getUnidad());
    }*/

}

