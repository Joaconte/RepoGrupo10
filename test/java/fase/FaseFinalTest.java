package fase;

import fase.FaseFinal;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FaseFinalTest {


    @Test
    public void test01FaseFinalDaSuNombreCorrectamente() {
        FaseFinal miFaseFinal = new FaseFinal();
        assertEquals("Fase Final", miFaseFinal.darNombreDeFase());
    }


}
