package fiuba.algo3.TP2.test;

import static org.junit.Assert.assertEquals;

import fiuba.algo3.TP2.model.FaseFinal;
import org.junit.Test;

public class FaseFinalTest {


    @Test
    public void test01FaseFinalDaSuNombreCorrectamente() {
        FaseFinal miFaseFinal = new FaseFinal();
        assertEquals("Fase Final", miFaseFinal.darNombreDeFase());
    }


}
