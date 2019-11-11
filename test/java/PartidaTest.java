import fase.FaseDePartida;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class PartidaTest {


    @Test
    public void test01PartidaInciaSeCreaEnFaseInicial() {
        Partida miPartida = new Partida ();
        assertEquals("Fase Inicial", miPartida.darNombreDeFase());
    }

    @Test
    public void test02PartidaCambiaSuFaseCorrectamenteACualquierOtraQueSeIndique() {
        Partida miPartida = new Partida ();
        FaseDePartida miNuevaFase = Mockito.mock(FaseDePartida.class);
        Mockito.when(miNuevaFase.darNombreDeFase()).thenReturn("Otra fase cualquiera");
        miPartida.cambiarFaseDePartida(miNuevaFase);
        assertEquals("Otra fase cualquiera", miPartida.darNombreDeFase());
    }

}
