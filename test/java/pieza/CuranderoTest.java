package pieza;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;
import org.mockito.Mock;

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


    @Test
    public void test03CuranderoPiolaSanaEn15PuntosACuranderoAliandoDe45Puntos() throws UnidadEstaMuertaException, UnidadNoSePuedeCurar, CurandoAEnemigoException {
        Curandero unCuranderoPiola = new Curandero(1);
        Curandero unCuranderoAliado = new Curandero(1);

        unCuranderoAliado.recibirDanio(30);
        unCuranderoPiola.curarAAliado(unCuranderoAliado);

        assertEquals(60,unCuranderoAliado.getPuntosVida(),0);
    }

    @Test (expected = CurandoAEnemigoException.class)
    public void test04CuranderoPiolaNoCuraAEnemigos() throws CurandoAEnemigoException, UnidadNoSePuedeCurar, UnidadEstaMuertaException {
        Curandero unCuranderoPiola = new Curandero(1);
        Curandero unCuranderoAliado = new Curandero(2);


        unCuranderoAliado.recibirDanio(30);
        unCuranderoPiola.curarAAliado(unCuranderoAliado);
    }

    @Test(expected = UnidadNoSePuedeCurar.class)
    public void test05CuranderoNoPuedeCurarCatapultas() throws UnidadNoSePuedeCurar, CurandoAEnemigoException {
        Curandero curitas = new Curandero(1);
        Catapulta catapulta = new Catapulta(1);
        curitas.curarAAliado(catapulta);

    }

    @Test
    public void test06CuranderoSanaHastaElMaximoAUnAliadoConDanioUno() throws UnidadEstaMuertaException {
        Curandero unCuranderoPiola = new Curandero(1);
        Curandero unCuranderoAliado = new Curandero(1);


        unCuranderoAliado.recibirDanio(1);
        try{
            unCuranderoPiola.curarAAliado(unCuranderoAliado); }
        catch(CurandoAEnemigoException | UnidadNoSePuedeCurar e) {}
        assertEquals(75,unCuranderoAliado.getPuntosVida(),0);
    }

    @Test
    public void test07CuranderoSePueceMoverCorrectamenteHaciaArriba() throws NoSePuedeMoverException {
        Curandero curandero = new Curandero(1);
        Ubicacion ubicacion = Mockito.mock(Ubicacion.class);
        Mockito.when(ubicacion.getPosicionEnY()).thenReturn(2);
        Mockito.when(ubicacion.getPosicionEnX()).thenReturn(1);

        curandero.setUbicacion(ubicacion);
        curandero.moverArriba();

        assertEquals(1, curandero.getUbicacion().getPosicionEnX());
        assertEquals(1, curandero.getUbicacion().getPosicionEnY());
        //¿Mas Direcciones en Test De Movimientos?
    }
}
