package  modelo.partida.fase;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
public class FaseMediaTest {


    @Test
    public void test01FaseMediaDevuelveFalseSiLePreguntanSiEsFaseInicial() {
        FaseMedia miFaseMedia = new FaseMedia();
        assertFalse( miFaseMedia.esFaseInicial());
    }

    @Test
    public void test02FaseMediaSeDevuelveASiMismaComoProximaFase() {
        FaseMedia miFaseMedia = new FaseMedia();
        assertEquals(miFaseMedia, miFaseMedia.retornarProximaFase());
    }


}