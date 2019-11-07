package test;

import fiuba.algo3.TP2.model.Ubicacion;
import fiuba.algo3.TP2.model.Curandero;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CuranderoTest {

    @Test
    public void test01JineteTieneCosto1() {
        Curandero unCuranderoPiola = new Curandero();
        assertEquals(2, unCuranderoPiola.getCosto());
    }

    @Test
    public void test02JineteIniciaCon75PuntosDeVida() {
        Curandero unCuranderoPiola = new Curandero();
        assertEquals(75, unCuranderoPiola.getPuntosVida());
    }

    @Test
    public void test03CuranderoSeMueveCorrectamenteACualquierDireccionQueMePasen() {
        Curandero unCuranderoPiola = new Curandero();
        int cualquierDireccion = 999;

        Ubicacion miNuevaUbicacion = Mockito.mock(Ubicacion.class);
        Mockito.when(miNuevaUbicacion.darPosicionEnX()).thenReturn(cualquierDireccion);
        Mockito.when(miNuevaUbicacion.darPosicionEnY()).thenReturn(cualquierDireccion*2);

        unCuranderoPiola.moverUnidad(miNuevaUbicacion);
        Ubicacion ubicacionModificada = unCuranderoPiola.getUbicacion();

        assertEquals(cualquierDireccion,ubicacionModificada.darPosicionEnX());
        assertEquals(cualquierDireccion*2,ubicacionModificada.darPosicionEnY());
    }

}
