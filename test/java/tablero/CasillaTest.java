package tablero;
import org.junit.Test;
import org.mockito.Mockito;
import pieza.Pieza;
import tablero.Casilla;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CasillaTest {

    @Test
    public void test01CasillaSeCreaVacia() {
        Casilla casilla = new Casilla();
        assertEquals("Libre", casilla.getEstado());
    }

    @Test
    public void test02CasillaSeOcupaDevuelveQueEstaOcupada() {
        Casilla casilla = new Casilla();
        Pieza pieza = Mockito.mock(Pieza.class);
        casilla.ocuparCasilla(pieza);
        assertEquals("Ocupada", casilla.getEstado());
    }


}
