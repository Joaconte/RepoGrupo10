package  modelo.partida.fase;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FaseMediaTest {


    @Test
    public void test01FaseMediaDaSuNombreCorrectamente() {
        FaseMedia miFaseMedia = new FaseMedia();
        assertEquals("Fase Media", miFaseMedia.darNombreDeFase());
    }


}