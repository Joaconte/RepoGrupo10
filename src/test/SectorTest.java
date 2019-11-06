package test;

import model.Sector;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SectorTest {


    @Test
    public void test01SeAgreganRangoCorrectamente(){

        Sector sector = new Sector(0, 9 );

        assertEquals(0, sector.getPrimeraPos());
        assertEquals(9, sector.getUltimaPos());
    }
}
