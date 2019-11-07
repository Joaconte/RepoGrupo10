package fiuba.algo3.TP2;

import fiuba.algo3.TP2.model.Jinete;
import fiuba.algo3.TP2.model.Unidad;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JineteTest extends Unidad {
    @Test
    public void test01JineteTieneCosto1() {
        Jinete jinete = new Jinete();
        assertEquals(3, jinete.getCosto());
    }


}
