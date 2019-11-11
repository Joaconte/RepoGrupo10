package fase;

import fase.FaseInicial;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class FaseInicialTest {


    @Test
    public void test01FaseInicialDaSuNombreCorrectamente() {
        FaseInicial miFaseInicial = new FaseInicial();
        assertEquals("Fase Inicial", miFaseInicial.darNombreDeFase());
    }


}