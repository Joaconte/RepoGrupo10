package modelo.tablero;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.tipos.Jinete;
import org.junit.Test;
import org.mockito.Mockito;
import modelo.pieza.Pieza;
import modelo.tablero.casilla.Casilla;

import static org.junit.Assert.*;

public class CasillaTest {

    @Test
    public void test01CasillaSeCreaVacia() {
        Casilla casilla = new Casilla();
        assertFalse(casilla.estaOcupada());
    }

    @Test
    public void test02CasillaSeOcupaDevuelveQueEstaOcupada() {
        Casilla casilla = new Casilla();
        Pieza pieza = Mockito.mock(Pieza.class);
        casilla.ocuparCasilla(pieza);
        assertTrue(casilla.estaOcupada());
    }

    @Test
    public void test03ElEstadoDeUnaCasillaLibreALaQueOcupoPasaAOcupado(){
        Casilla casilla = new Casilla();
        Pieza pieza = Mockito.mock(Pieza.class);
        casilla.ocuparCasilla(pieza);
        assertTrue(casilla.estaOcupada());
    }

    @Test
    public void test04ElEstadoDeUnaCasillaALaQueOcupoPasaADesocupadaCuandoLaDesocupo(){
        Casilla casilla = new Casilla();
        Pieza pieza = Mockito.mock(Pieza.class);
        casilla.ocuparCasilla(pieza);
        casilla.desocuparCasilla();
        assertFalse(casilla.estaOcupada());
    }

    @Test
    public void test05CasillaSeLiberaSiLaPiezaMuere() throws UnidadEstaMuertaException {
        Casilla casilla = new Casilla();
        Jinete jinete = new Jinete(1,1,1);
        casilla.ocuparCasilla(jinete);
        jinete.recibirDanio(100000000);
        casilla.removerTropasMuertas();
        assertFalse(casilla.estaOcupada());
    }




}
