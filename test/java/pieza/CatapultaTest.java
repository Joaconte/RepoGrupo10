package pieza;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;
import org.mockito.Mock;
import pieza.movimiento.NoSePuedeMoverException;
import pieza.tipos.Catapulta;

import static org.junit.Assert.assertEquals;

public class CatapultaTest {
    @Test
    public void test01CatapultaCuesta5Puntos() {
        Catapulta catapulta = new Catapulta(1);
        assertEquals(5, catapulta.getCosto());
    }

    @Test
    public void test02CatapultaNuevaTiene50PuntosDeVida() {
        Catapulta catapulta = new Catapulta(1);
        assertEquals(50, catapulta.getPuntosVida(),0.05);
    }

    @Test(expected = NoSePuedeMoverException.class)
    public void test03CatapultaNoSePuedeMoverArriba() throws NoSePuedeMoverException {
        Catapulta catapulta = new Catapulta(1);
        Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacion.getPosicionEnY()).thenReturn(1);
        Mockito.when(ubicacion.getPosicionEnX()).thenReturn(1);
        catapulta.setUbicacion(ubicacion);
        catapulta.moverArriba();
        assertEquals(1,catapulta.getUbicacion().getPosicionEnX());
    }
}
