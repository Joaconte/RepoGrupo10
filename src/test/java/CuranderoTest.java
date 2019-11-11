package test;

import fiuba.algo3.TP2.exception.UnidadNoSePuedeCurar;
import fiuba.algo3.TP2.model.Catapulta;
import fiuba.algo3.TP2.model.Ubicacion;
import fiuba.algo3.TP2.model.Curandero;
import fiuba.algo3.TP2.exception.CurandoAEnemigoException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CuranderoTest {

    @Test
    public void test01CuranderoTieneCosto2() {
        Curandero unCuranderoPiola = new Curandero();
        assertEquals(2, unCuranderoPiola.getCosto());
    }

    @Test
    public void test02CurandetoIniciaCon75PuntosDeVida() {
        Curandero unCuranderoPiola = new Curandero();
        assertEquals(75, unCuranderoPiola.getPuntosVida(),0.05);
    }

    /*@Test
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
    }*/

    @Test
    public void test04CuranderoPiolaSanaEn15PuntosACuranderoAliandoDe45Puntos() {
        Curandero unCuranderoPiola = new Curandero();
        Curandero unCuranderoAliado = new Curandero();

        unCuranderoPiola.setEquipo(1);
        unCuranderoAliado.setEquipo(1);

        unCuranderoAliado.recibirDanio(30);
        try{
        unCuranderoPiola.curarAAliado(unCuranderoAliado); }
        catch(CurandoAEnemigoException | UnidadNoSePuedeCurar e) {}
        assertEquals(60,unCuranderoAliado.getPuntosVida(),0.05);
    }

    @Test (expected = CurandoAEnemigoException.class)
    public void test05CuranderoPiolaNoCuraAEnemigos() throws CurandoAEnemigoException, UnidadNoSePuedeCurar {
        Curandero unCuranderoPiola = new Curandero();
        Curandero unCuranderoAliado = new Curandero();

        unCuranderoPiola.setEquipo(2);
        unCuranderoAliado.setEquipo(1);

        unCuranderoAliado.recibirDanio(30);
        unCuranderoPiola.curarAAliado(unCuranderoAliado);
    }

    @Test(expected = UnidadNoSePuedeCurar.class)
    public void test06CuranderoNoPuedeCurarCatapultas() throws UnidadNoSePuedeCurar, CurandoAEnemigoException {
        Curandero curitas = new Curandero();
        Catapulta catapulta = new Catapulta();
        curitas.setEquipo(1);
        catapulta.setEquipo(1);
        curitas.curarAAliado(catapulta);

    }

    @Test
    public void test04CuranderoSanaHastaElMaximoAUnAliadoConDanioUno() {
        Curandero unCuranderoPiola = new Curandero();
        Curandero unCuranderoAliado = new Curandero();

        unCuranderoPiola.setEquipo(1);
        unCuranderoAliado.setEquipo(1);

        unCuranderoAliado.recibirDanio(1);
        try{
            unCuranderoPiola.curarAAliado(unCuranderoAliado); }
        catch(CurandoAEnemigoException | UnidadNoSePuedeCurar e) {}
        assertEquals(75,unCuranderoAliado.getPuntosVida(),0.05);
    }
}
