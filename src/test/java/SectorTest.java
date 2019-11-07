package test;
import fiuba.algo3.TP2.model.Sector;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SectorTest {


    @Test
    public void test01SeAgreganRangoCorrectamente(){

        Sector sector = new Sector(0, 9 );

        assertEquals(0, sector.getPrimeraPos());
        assertEquals(9, sector.getUltimaPos());
    }
}

