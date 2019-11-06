package fiuba.algo3.TP2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FaseMediaTest {


    @Test
    public void test01FaseMediaDaSuNombreCorrectamente() {
        FaseMedia miFaseMedia = new FaseMedia();
        assertEquals("Fase Media", miFaseMedia.darNombreDeFase());
    }


}