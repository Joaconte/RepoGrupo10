package pieza;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import pieza.movimiento.NoSePuedeMoverException;
import pieza.sanacion.CurandoAEnemigoException;
import pieza.sanacion.UnidadNoSePuedeCurar;
import pieza.tipos.Catapulta;
import pieza.tipos.Curandero;

public class CuranderoTest {

    @Test
    public void test01CuranderoTieneCosto2() {
        Curandero unCuranderoPiola = new Curandero(1);
        assertEquals(2, unCuranderoPiola.getCosto());
    }

    @Test
    public void test02CurandetoIniciaCon75PuntosDeVida() {
        Curandero unCuranderoPiola = new Curandero(1);
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
    public void test04CuranderoPiolaSanaEn15PuntosACuranderoAliandoDe45Puntos() throws UnidadEstaMuertaException, UnidadNoSePuedeCurar, CurandoAEnemigoException {
        Curandero unCuranderoPiola = new Curandero(1);
        Curandero unCuranderoAliado = new Curandero(1);

        unCuranderoAliado.recibirDanio(30);
        unCuranderoPiola.curarAAliado(unCuranderoAliado);

        assertEquals(60,unCuranderoAliado.getPuntosVida(),0);
    }

    @Test (expected = CurandoAEnemigoException.class)
    public void test05CuranderoPiolaNoCuraAEnemigos() throws CurandoAEnemigoException, UnidadNoSePuedeCurar, UnidadEstaMuertaException {
        Curandero unCuranderoPiola = new Curandero(1);
        Curandero unCuranderoAliado = new Curandero(2);


        unCuranderoAliado.recibirDanio(30);
        unCuranderoPiola.curarAAliado(unCuranderoAliado);
    }

    @Test(expected = UnidadNoSePuedeCurar.class)
    public void test06CuranderoNoPuedeCurarCatapultas() throws UnidadNoSePuedeCurar, CurandoAEnemigoException {
        Curandero curitas = new Curandero(1);
        Catapulta catapulta = new Catapulta(1);
        curitas.curarAAliado(catapulta);

    }

    @Test
    public void test07CuranderoSanaHastaElMaximoAUnAliadoConDanioUno() throws UnidadEstaMuertaException {
        Curandero unCuranderoPiola = new Curandero(1);
        Curandero unCuranderoAliado = new Curandero(1);


        unCuranderoAliado.recibirDanio(1);
        try{
            unCuranderoPiola.curarAAliado(unCuranderoAliado); }
        catch(CurandoAEnemigoException | UnidadNoSePuedeCurar e) {}
        assertEquals(75,unCuranderoAliado.getPuntosVida(),0);
    }

    @Test
    public void test08CuranderoEstaEn1x2y_seMueveA1x1y() throws NoSePuedeMoverException {
        Curandero curandero = new Curandero(1);
        Ubicacion ubicacion = new Ubicacion(1,2);
        curandero.setUbicacion(ubicacion);
        curandero.moverArriba();
        assertEquals(1, curandero.getUbicacion().getPosicionEnX());
        assertEquals(1, curandero.getUbicacion().getPosicionEnY());
    }
}
