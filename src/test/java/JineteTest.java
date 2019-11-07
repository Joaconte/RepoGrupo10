package test;

import fiuba.algo3.TP2.model.Jinete;
import fiuba.algo3.TP2.model.Unidad;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JineteTest {
    @Test
    public void test01JineteTieneCosto1() {
        Jinete jinete = new Jinete();
        assertEquals(3, jinete.getCosto());
    }

    public void test02JineteIniciaCon100PuntosDeVida() {
        Jinete jinete = new Jinete();
        assertEquals(100, jinete.getPuntosVida());
    }

    @Test
    public void test03JineteSeMueveCorrectamenteACualquierDireccionQueMePasen() {
        Jinete jinete = new Jinete();
        int cualquierDireccion = 999;

        Ubicacion miNuevaUbicacion = Mockito.mock(Ubicacion.class);
        Mockito.when(miNuevaUbicacion.darPosicionEnX()).thenReturn(cualquierDireccion);
        Mockito.when(miNuevaUbicacion.darPosicionEnY()).thenReturn(cualquierDireccion*2);
        jinete.moverUnidad(miNuevaUbicacion);
        Ubicacion ubicacionModificada = jinete.getUbicacion();

        assertEquals(cualquierDireccion,ubicacionModificada.darPosicionEnX());
        assertEquals(cualquierDireccion*2,ubicacionModificada.darPosicionEnY());
    }

}
