package modelo.pieza;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import modelo.pieza.movimiento.NoSePuedeMoverException;
import modelo.pieza.sanacion.CurandoAEnemigoException;
import modelo.pieza.sanacion.UnidadNoSePuedeCurar;
import modelo.pieza.tipos.Catapulta;
import modelo.pieza.tipos.Curandero;
import modelo.pieza.tipos.CurandoCuraADistanciaCortaException;

public class CuranderoTest {


    @Test
    public void test00CuranderoPerteneceAlEjercito1YDevuelveElEjercitoCorrectamente() {
        Curandero unCuranderoPiola = new Curandero(1,2,2);
        assertEquals(1, unCuranderoPiola.getEquipo());
    }

    @Test
    public void test01CuranderoTieneCosto2() {
        Curandero unCuranderoPiola = new Curandero(1,2,2);
        assertEquals(2, unCuranderoPiola.getCosto());
    }

    @Test
    public void test02CurandetoIniciaCon75PuntosDeVida() {
        Curandero unCuranderoPiola = new Curandero(1,2,2);
        assertEquals(75, unCuranderoPiola.getPuntosVida(),0.05);
    }


    @Test
    public void test03CuranderoPiolaSanaEn15PuntosACuranderoAliandoDe45Puntos() throws UnidadEstaMuertaException, UnidadNoSePuedeCurar, CurandoAEnemigoException, CurandoCuraADistanciaCortaException {
        Curandero unCuranderoPiola = new Curandero(1,1,1);
        Curandero unCuranderoAliado = new Curandero(1,2,2);

        unCuranderoAliado.recibirDanio(30);
        unCuranderoPiola.curarAAliado(unCuranderoAliado);

        assertEquals(60,unCuranderoAliado.getPuntosVida(),0);
    }

    @Test (expected = CurandoAEnemigoException.class)
    public void test04CuranderoPiolaNoCuraAEnemigos() throws CurandoAEnemigoException, UnidadNoSePuedeCurar, UnidadEstaMuertaException, CurandoCuraADistanciaCortaException {
        Curandero unCuranderoPiola = new Curandero(1,10,10);
        Curandero unCuranderoAliado = new Curandero(2,11,11);

        unCuranderoAliado.recibirDanio(30);
        unCuranderoPiola.curarAAliado(unCuranderoAliado);
    }

    @Test(expected = UnidadNoSePuedeCurar.class)
    public void test05CuranderoNoPuedeCurarCatapultas() throws UnidadNoSePuedeCurar, CurandoAEnemigoException, CurandoCuraADistanciaCortaException {
        Curandero curitas = new Curandero(1,1,1);
        Catapulta catapulta = new Catapulta(1,2,2);
        curitas.curarAAliado(catapulta);

    }

    @Test
    public void test06CuranderoSanaHastaElMaximoAUnAliadoConDanioUno() throws UnidadEstaMuertaException {
        Curandero unCuranderoPiola = new Curandero(1,2,2);
        Curandero unCuranderoAliado = new Curandero(1,2,3);


        unCuranderoAliado.recibirDanio(1);
        try{
            unCuranderoPiola.curarAAliado(unCuranderoAliado); }
        catch(CurandoAEnemigoException | UnidadNoSePuedeCurar | CurandoCuraADistanciaCortaException e) {}
        assertEquals(75,unCuranderoAliado.getPuntosVida(),0);
    }


    @Test (expected = CurandoCuraADistanciaCortaException.class)
    public void test08CuranderoNoCuraADistanciaMayorA2Casillas() throws NoSePuedeMoverException, UnidadNoSePuedeCurar, CurandoCuraADistanciaCortaException, CurandoAEnemigoException {
        Curandero curandero = new Curandero(1,1,2);
        Curandero curanderoAliado = new Curandero(1,1,5);

        curandero.curarAAliado(curanderoAliado);
    }

}
