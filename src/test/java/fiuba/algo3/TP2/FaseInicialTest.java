package fiuba.algo3.TP2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FaseInicialTest {


    @Test
    public void test01FaseInicialDaSuNombreCorrectamente() {
        FaseInicial miFaseInicial = new FaseInicial();
        assertEquals("Fase Inicial", miFaseInicial.darNombreDeFase());
    }


}