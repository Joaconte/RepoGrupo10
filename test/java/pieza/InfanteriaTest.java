package pieza;

import org.junit.Test;
import pieza.ataque.DistanciaDeAtaqueInvalidaException;
import pieza.ataque.PiezaAliadaNoAtacableException;
import pieza.tipos.Infanteria;
import tablero.Tablero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.mockito.Mockito;
import org.mockito.Mock;

public class InfanteriaTest {
    @Test
    public void test01InfanteriaTieneCosto1() {
        Infanteria soldado = new Infanteria(1);
        assertEquals(1, soldado.getCosto());
    }

    @Test
    public void test02InfanteriaTiene100DeVidaAlIniciar() {
        Infanteria soldado = new Infanteria(1);
        assertEquals(100, soldado.getPuntosVida(),0);
    }

    @Test
    public void test03InfanteriaRecibe10DeDanio_vida90() throws UnidadEstaMuertaException {
        Infanteria soldado = new Infanteria(1);
        double vida = soldado.getPuntosVida();
        soldado.recibirDanio(10);
        assertEquals(vida-10, soldado.getPuntosVida(),0);
    }

    @Test
    public void test04InfanteriaRecibe100DeDanio_vida0() throws UnidadEstaMuertaException {
        Infanteria soldado = new Infanteria(1);
        soldado.recibirDanio(100);
        assertEquals(100-100, soldado.getPuntosVida(),0.05);
    }

    @Test(expected = UnidadEstaMuertaException.class)
    public void test05InfanteriaRecibe101DeDanio_ExceptionUnidadMuerta() throws UnidadEstaMuertaException {
        Infanteria soldado = new Infanteria(2);
        soldado.recibirDanio(100);
        soldado.recibirDanio(1);
    }

    @Test
    public void test06InfanteriaDeDiferentesEquiposSonEnemigos() {
        Infanteria soldado = new Infanteria(1);
        Infanteria otroSoldado = new Infanteria(2);
        assertTrue(soldado.esEnemigo(otroSoldado));
    }

    @Test (expected = PiezaAliadaNoAtacableException.class)
    public void test07InfanteriaDeMismosEquiposNoSeAtacan() throws PiezaAliadaNoAtacableException, DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException {

        //--------------Atacante Preparacion------------//
        Infanteria soldado = new Infanteria(1);
        Ubicacion ubicacionSoldado = Mockito.mock(Ubicacion.class);
        soldado.setUbicacion(ubicacionSoldado);

        //---------------Atacado Preparacion------------//
        Infanteria otroSoldado = new Infanteria(1);
        Ubicacion ubicacionOtroSoldado = Mockito.mock(Ubicacion.class);
        otroSoldado.setUbicacion(ubicacionOtroSoldado);

        //----------Metodo testeado en Ubicacion------------//
        Mockito.when(ubicacionSoldado.getDistanciaAOtroPunto(ubicacionOtroSoldado)).thenReturn(1);

        //--------------Ataque en concreto----------------//
        soldado.atacar(otroSoldado, Mockito.mock(Tablero.class));

    }

    @Test
    public void test08InfanteriaDeDistintosEquiposSeAtacanCorrectamente() throws PiezaAliadaNoAtacableException, DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException {

        //--------------Atacante Preparacion------------//
        Infanteria soldado = new Infanteria(1);
        Ubicacion ubicacionSoldado = Mockito.mock(Ubicacion.class);
        soldado.setUbicacion(ubicacionSoldado);

        //---------------Atacado Preparacion------------//
        Infanteria otroSoldado = new Infanteria(2);
        Ubicacion ubicacionOtroSoldado = Mockito.mock(Ubicacion.class);
        double vidaAntesDelAtaque = otroSoldado.getPuntosVida();
        otroSoldado.setUbicacion(ubicacionOtroSoldado);

        //----------Metodo testeado en Ubicacion------------//
        Mockito.when(ubicacionSoldado.getDistanciaAOtroPunto(ubicacionOtroSoldado)).thenReturn(1);

        //--------------Ataque en concreto----------------//
        soldado.atacar(otroSoldado, Mockito.mock(Tablero.class));
        assertEquals(vidaAntesDelAtaque-10, otroSoldado.getPuntosVida(),00);

    }


    @Test (expected= DistanciaDeAtaqueInvalidaException.class)
    public void test09InfanteriaDeDistintosEquiposNoSeAtacanEnDistanciaSuperiorA2Casillas() throws PiezaAliadaNoAtacableException, DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException {

        //--------------Atacante Preparacion------------
        Infanteria soldado = new Infanteria(1);
        Ubicacion ubicacionSoldado = Mockito.mock(Ubicacion.class);
        soldado.setUbicacion(ubicacionSoldado);

        //---------------Atacado Preparacion------------
        Infanteria otroSoldado = new Infanteria(2);
        Ubicacion ubicacionOtroSoldado = Mockito.mock(Ubicacion.class);
        otroSoldado.setUbicacion(ubicacionOtroSoldado);

        //----------Metodo testeado en Ubicacion------------
        Mockito.when(ubicacionSoldado.getDistanciaAOtroPunto(ubicacionOtroSoldado)).thenReturn(3);

        //--------------Ataque en concreto----------------
        soldado.atacar(otroSoldado, Mockito.mock(Tablero.class));

    }



}

