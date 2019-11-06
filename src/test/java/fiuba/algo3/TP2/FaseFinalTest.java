package fiuba.algo3.TP2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FaseFinalTest {


    @Test
    public void test01FaseFinalDaSuNombreCorrectamente() {
        FaseFinal miFaseFinal = new FaseFinal();
        assertEquals("Fase Final", miFaseFinal.darNombreDeFase());
    }


}
