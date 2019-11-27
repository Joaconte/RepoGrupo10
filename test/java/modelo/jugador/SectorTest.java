package modelo.jugador;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class SectorTest {


    @Test
    public void test01SeAgreganRangoCorrectamenteParaJugadorNumemor1(){

        Sector sector = new Sector(1 );

        assertEquals(0, sector.getPrimeraPos());
        assertEquals(9, sector.getUltimaPos());
    }

    @Test
    public void test02SeAgreganRangoCorrectamenteParaJugadorNumemor2(){

        Sector sector = new Sector(2 );

        assertEquals(10, sector.getPrimeraPos());
        assertEquals(19, sector.getUltimaPos());
    }

    @Test
    public void test03PosicionEnColumna12NoEstaEnSectorJugadorNumemor1(){

        Sector sector = new Sector(1 );

        assertFalse(sector.esDelSector(12));
    }

    @Test
    public void test04PosicionEnColumna12SiEstaEnSectorJugadorNumemor2(){

        Sector sector = new Sector(2 );

        assertTrue(sector.esDelSector(12));
    }

}

