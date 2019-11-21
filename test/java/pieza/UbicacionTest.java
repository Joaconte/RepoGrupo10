package pieza;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UbicacionTest {

    @Test
    public void test01SeCreaUbicacionConSusPosicionesCorrectamente() {
        Ubicacion ubicacion = new Ubicacion(1, 2);
        assertEquals(1, ubicacion.getPosicionEnX() );
        assertEquals(2, ubicacion.getPosicionEnY() );
    }

    @Test
    public void test02SeCalculaCorrectamenteLaDistanciaEntre2Ubicaciones() {
        Ubicacion ubicacion1 = new Ubicacion(1, 2);
        Ubicacion ubicacion2 = new Ubicacion(5, 3);

        assertEquals(4,  ubicacion1.getDistanciaAOtroPunto(ubicacion2) );
        assertEquals(4,  ubicacion2.getDistanciaAOtroPunto(ubicacion1) );
    }

    @Test
    public void test03SeCalculaCorrectamenteLaDistanciaEntre2UbicacionesConIgualPosicionEnX() {
        Ubicacion ubicacion1 = new Ubicacion(1, 2);
        Ubicacion ubicacion2 = new Ubicacion(1, 3);

        assertEquals(1,  ubicacion1.getDistanciaAOtroPunto(ubicacion2) );
        assertEquals(1,  ubicacion2.getDistanciaAOtroPunto(ubicacion1) );
    }

    @Test
    public void test04SeCalculaCorrectamenteLaDistanciaEntre2UbicacionesConIgualPosicionEnY() {
        Ubicacion ubicacion1 = new Ubicacion(11, 2);
        Ubicacion ubicacion2 = new Ubicacion(1, 2);

        assertEquals(10,  ubicacion1.getDistanciaAOtroPunto(ubicacion2) );
        assertEquals(10,  ubicacion2.getDistanciaAOtroPunto(ubicacion1) );
    }

    @Test
    public void test04SeCalculaCorrectamenteLaDistanciaMedia() {
        Ubicacion ubicacion1 = new Ubicacion(1, 2);
        Ubicacion ubicacion2 = new Ubicacion(5, 6);

        assertEquals(4,  ubicacion1.getDistanciaAOtroPunto(ubicacion2) );
        assertEquals(4,  ubicacion2.getDistanciaAOtroPunto(ubicacion1) );
    }

}