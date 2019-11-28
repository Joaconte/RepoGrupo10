package modelo.partida.fase;

import modelo.jugador.EjercitoIncompletoException;
import modelo.jugador.Jugador;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;


public class FaseInicialTest {


    @Test
    public void test01FaseInicialDaSuNombreCorrectamente() {
        FaseInicial miFaseInicial = new FaseInicial();
        assertEquals("Fase Inicial", miFaseInicial.darNombreDeFase());
    }
    

}