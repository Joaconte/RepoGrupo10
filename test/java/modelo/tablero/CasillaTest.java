package modelo.tablero;
import org.junit.Test;
import org.mockito.Mockito;
import modelo.pieza.Pieza;
import modelo.tablero.casilla.Casilla;

import static org.junit.Assert.assertEquals;

public class CasillaTest {

    @Test
    public void test01CasillaSeCreaVacia() {
        Casilla casilla = new Casilla();
        assertEquals(false, casilla.estaOcupada());
    }

    @Test
    public void test02CasillaSeOcupaDevuelveQueEstaOcupada() {
        Casilla casilla = new Casilla();
        Pieza pieza = Mockito.mock(Pieza.class);
        casilla.ocuparCasilla(pieza);
        assertEquals(true, casilla.estaOcupada());
    }


}
