package pieza;

import org.junit.Test;
import pieza.movimiento.NoSePuedeMoverException;
import pieza.tipos.Catapulta;

import static org.junit.Assert.assertEquals;

public class CatapultaTest {
    @Test
    public void test01CatapultaCuesta5Puntos() {
        Catapulta catapulta = new Catapulta();
        assertEquals(5, catapulta.getCosto());
    }

    @Test
    public void test02CatapultaNuevaTiene50PuntosDeVida() {
        Catapulta catapulta = new Catapulta();
        assertEquals(50, catapulta.getPuntosVida(),0.05);
    }

    @Test(expected = NoSePuedeMoverException.class)
    public void test03CatapultaNoSePuedeMoverArriba() throws NoSePuedeMoverException {
        Catapulta catapulta = new Catapulta();
        Ubicacion ubicacion = new Ubicacion(1,1);
        catapulta.setUbicacion(ubicacion);
        catapulta.moverArriba();
        assertEquals(1,catapulta.getUbicacion().getPosicionEnX());
    }
}
