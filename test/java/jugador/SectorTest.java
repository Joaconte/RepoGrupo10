package jugador;

import jugador.Sector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class SectorTest {


    @Test
    public void test01SeAgreganRangoCorrectamenteParaJugadorNumemor1(){

        Sector sector = new Sector(1 );

        assertEquals(1, sector.getPrimeraPos());
        assertEquals(10, sector.getUltimaPos());
    }

    @Test
    public void test02SeAgreganRangoCorrectamenteParaJugadorNumemor2(){

        Sector sector = new Sector(2 );

        assertEquals(11, sector.getPrimeraPos());
        assertEquals(20, sector.getUltimaPos());
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

