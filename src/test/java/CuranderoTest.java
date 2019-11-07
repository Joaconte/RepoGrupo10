package test;

import fiuba.algo3.TP2.model.Ubicacion;
import fiuba.algo3.TP2.model.Curandero;
import fiuba.algo3.TP2.exception.CurandoAEnemigoException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
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
    public void test02CurandetoIniciaCon75PuntosDeVida() {
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

    @Test
    public void test04CuranderoPiolaSanaEn15PuntosACuranderoAliandoDe45Puntos() {
        Curandero unCuranderoPiola = new Curandero();
        Curandero unCuranderoAliado = new Curandero();

        unCuranderoPiola.setEquipo(2);
        unCuranderoAliado.setEquipo(2);

        unCuranderoAliado.recibirDanio(30);
        try{
        unCuranderoPiola.curarAAliado(unCuranderoAliado); }
        catch(CurandoAEnemigoException e) {}
        assertEquals(60,unCuranderoAliado.getPuntosVida());
    }

    @Test (expected = CurandoAEnemigoException.class)
    public void test05CuranderoPiolaNoCuraAEnemigos()  throws CurandoAEnemigoException {
        Curandero unCuranderoPiola = new Curandero();
        Curandero unCuranderoAliado = new Curandero();

        unCuranderoPiola.setEquipo(2);
        unCuranderoAliado.setEquipo(1);

        unCuranderoAliado.recibirDanio(30);
        unCuranderoPiola.curarAAliado(unCuranderoAliado);
    }
}
