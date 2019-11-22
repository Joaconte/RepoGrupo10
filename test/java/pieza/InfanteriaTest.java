package pieza;

import org.junit.Test;
import pieza.tipos.Infanteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InfanteriaTest {
    @Test
    public void test01InfanteriaTieneCosto1() {
        Infanteria soldado = new Infanteria();
        assertEquals(1, soldado.getCosto());
    }

    @Test
    public void test02InfanteriaTiene100DeVidaAlIniciar() {
        Infanteria soldado = new Infanteria();
        assertEquals(100, soldado.getPuntosVida(),0.05);
    }

    @Test
    public void test03InfanteriaRecibe10DeDanio_vida90() {
        Infanteria soldado = new Infanteria();
        double vida = soldado.getPuntosVida();
        soldado.recibirDanio(10);
        assertEquals(vida-10, soldado.getPuntosVida(),0.05);
    }

    @Test
    public void test04InfanteriaRecibe100DeDanio_vida0() {
        Infanteria soldado = new Infanteria();
        soldado.recibirDanio(100);
        assertEquals(100-100, soldado.getPuntosVida(),0.05);
    }

    @Test(expected = UnidadEstaMuertaException.class)
    public void test05InfanteriaRecibe101DeDanio_ExceptionUnidadMuerta() {
        Infanteria soldado = new Infanteria();
        soldado.recibirDanio(100);
        soldado.recibirDanio(1);
    }

    /*@Test
    public void test06InfanteriaDeDiferentesEquiposSonEnemigos() {
        Infanteria soldado = new Infanteria();
        soldado.setEquipo(1);
        Infanteria otroSoldado = new Infanteria();
        otroSoldado.setEquipo(2);
        assertTrue(soldado.esEnemigo(otroSoldado));
    }

    @Test
    public void test07JineteSeMueveCorrectamenteACualquierDireccionQueMePasen() {
        Infanteria soldado = new Infanteria();
        int cualquierDireccion = 999;

        Ubicacion miNuevaUbicacion = Mockito.mock(Ubicacion.class);
        Mockito.when(miNuevaUbicacion.darPosicionEnX()).thenReturn(cualquierDireccion);
        Mockito.when(miNuevaUbicacion.darPosicionEnY()).thenReturn(cualquierDireccion*2);
        soldado.moverUnidad(miNuevaUbicacion);
        Ubicacion ubicacionModificada = soldado.getUbicacion();

        assertEquals(cualquierDireccion,ubicacionModificada.darPosicionEnX());
        assertEquals(cualquierDireccion*2,ubicacionModificada.darPosicionEnY());
    }*/
}

