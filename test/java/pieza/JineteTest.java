package pieza;

import org.junit.Test;
import pieza.ataque.DistanciaDeAtaqueInvalidaException;
import pieza.ataque.PiezaAliadaNoAtacableException;
import pieza.tipos.Infanteria;
import pieza.tipos.Jinete;
import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;
import org.mockito.Mock;
import tablero.Tablero;

import java.util.*;

public class JineteTest {

    @Test
    public void test01JineteTieneCosto3() {
        Jinete jinete = new Jinete(1);
        assertEquals(3, jinete.getCosto());
    }

    @Test
    public void test02JineteIniciaCon100PuntosDeVida() {
        Jinete jinete = new Jinete(1);
        assertEquals(100, jinete.getPuntosVida(),0);
    }

    @Test
    public void test03JineteAtacaADistanciaAEnemigoYSaca15PuntosDeVida() throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {

        //----------Jinete atacante se prepara --------
        Jinete jinete = new Jinete(1);
        Ubicacion ubicacionJinete = Mockito.mock(Ubicacion.class);
        jinete.setUbicacion(ubicacionJinete);

        //----------Jinete atacado se prepara --------
        Jinete oponente = new Jinete(2);
        Ubicacion ubicacionJineteAtacado = Mockito.mock(Ubicacion.class);
        oponente.setUbicacion(ubicacionJineteAtacado);
        double vida= oponente.getPuntosVida();

        //----------Metodos Probados Tablero/Ubicacion ------
        Tablero tablero = Mockito.mock(Tablero.class);
        List<Pieza> lista = Mockito.mock(ArrayList.class);
        Mockito.when(lista.size()).thenReturn(0);
        Mockito.when(tablero.getPiezasAdyacentes(ubicacionJinete)).thenReturn(lista);
        Mockito.when(ubicacionJinete.getDistanciaAOtroPunto(ubicacionJineteAtacado)).thenReturn(5);

        //----------Ataque ------------------
        jinete.atacar(oponente,tablero);
        assertEquals(vida-15,oponente.getPuntosVida(),0);
    }

    @Test (expected = DistanciaDeAtaqueInvalidaException.class)
    public void test04JineteNoAtacaADistanciaAEnemigoPorqueEstaAsediadoYNoTieneRefuerzos() throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {

        //----------Jinete atacante se prepara --------
        Jinete jinete = new Jinete(1);
        Ubicacion ubicacionJinete = Mockito.mock(Ubicacion.class);
        jinete.setUbicacion(ubicacionJinete);

        //----------Jinete blanco Fallido se prepara -------
        Jinete oponente = new Jinete(2);
        Ubicacion ubicacionJineteAtacado = Mockito.mock(Ubicacion.class);
        oponente.setUbicacion(ubicacionJineteAtacado);

        //----------Jinete a corta distancia se prepara -------
        Jinete jineteAcosador = new Jinete(2);

        //----------Metodos Probados Tablero/Ubicacion -------
        Tablero tablero = Mockito.mock(Tablero.class);
        List<Pieza> lista = Mockito.mock(ArrayList.class);
        Mockito.when(lista.size()).thenReturn(1);
        Mockito.when(lista.get(0)).thenReturn(jineteAcosador);
        Mockito.when(tablero.getPiezasAdyacentes(ubicacionJinete)).thenReturn(lista);
        Mockito.when(ubicacionJinete.getDistanciaAOtroPunto(ubicacionJineteAtacado)).thenReturn(5);

        //----------Ataque -----------------
        jinete.atacar(oponente,tablero);
    }

    @Test
    public void test05JineteAtacaAEnemigoACortaDistanciaEstandoCuebierto() throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {

        //----------Jinete atacante se prepara -------
        Jinete jinete = new Jinete(1);
        Ubicacion ubicacionJinete = Mockito.mock(Ubicacion.class);
        jinete.setUbicacion(ubicacionJinete);

        //----------Jinete a corta distancia se prepara -------
        Jinete oponenteCercano = new Jinete(2);
        Ubicacion ubicacionJineteAcosador = Mockito.mock(Ubicacion.class);
        oponenteCercano.setUbicacion(ubicacionJineteAcosador);
        double vida = oponenteCercano.getPuntosVida();

        //----------Infante Aliado se prepara -------
        Infanteria infanteAliado = Mockito.mock(Infanteria.class);
        Mockito.when(infanteAliado.esEnemigo(jinete)).thenReturn(false);


        //----------Metodos Probados Tablero/Ubicacion ------
        Tablero tablero = Mockito.mock(Tablero.class);
        List<Pieza> lista = Mockito.mock(ArrayList.class);
        Mockito.when(lista.size()).thenReturn(2);
        Mockito.when(lista.get(0)).thenReturn(oponenteCercano);
        Mockito.when(lista.get(1)).thenReturn(infanteAliado);
        Mockito.when(tablero.getPiezasAdyacentes(ubicacionJinete)).thenReturn(lista);
        Mockito.when(infanteAliado.getNombre()).thenReturn("Infanteria");
        Mockito.when(ubicacionJinete.getDistanciaAOtroPunto(ubicacionJineteAcosador)).thenReturn(2);

        //----------Ataque ------------------
        jinete.atacar(oponenteCercano,tablero);
        assertEquals(vida-5,oponenteCercano.getPuntosVida(),0);
    }

    @Test
    public void test06JineteAtacaACortaDistanciaAEnemigoQueLoAsediaSinEstarCuebierto() throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {
        //----------Jinete atacante se prepara -------
        Jinete jinete = new Jinete(1);
        Ubicacion ubicacionJinete = Mockito.mock(Ubicacion.class);
        jinete.setUbicacion(ubicacionJinete);

        //----------Jinete acosador se prepara ------
        Jinete oponenteCercano = new Jinete(2);
        Ubicacion ubicacionJineteAcosador = Mockito.mock(Ubicacion.class);
        oponenteCercano.setUbicacion(ubicacionJineteAcosador);
        double vida = oponenteCercano.getPuntosVida();

        //----------Metodos Probados Tablero/Ubicacion ------
        Tablero tablero = Mockito.mock(Tablero.class);
        List<Pieza> lista = Mockito.mock(ArrayList.class);
        Mockito.when(lista.size()).thenReturn(1);
        Mockito.when(lista.get(0)).thenReturn(oponenteCercano);
        Mockito.when(tablero.getPiezasAdyacentes(ubicacionJinete)).thenReturn(lista);
        Mockito.when(ubicacionJinete.getDistanciaAOtroPunto(ubicacionJineteAcosador)).thenReturn(2);

        //----------Ataque ------------------
        jinete.atacar(oponenteCercano,tablero);
        assertEquals(vida-5,oponenteCercano.getPuntosVida(),0);
    }

    @Test(expected= DistanciaDeAtaqueInvalidaException.class)
    public void test07JineteNoAtacaAEnemigoAMediaDistanciaPorqueUnidadDistintaAInfanteEsUnicoRefuerzoYEstaSiendoAsediado() throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {

        //----------Jinete atacante se prepara --------
        Jinete jinete = new Jinete(1);
        Ubicacion ubicacionJinete = Mockito.mock(Ubicacion.class);
        jinete.setUbicacion(ubicacionJinete);

        //----------Jinete blanco fallido se prepara --------
        Jinete jineteADistancia = new Jinete(2);
        Ubicacion ubicacionJineteADistancia = Mockito.mock(Ubicacion.class);
        jineteADistancia.setUbicacion(ubicacionJineteADistancia);

        //----------Jinete a Corta Distancia se prepara --------
        Jinete jineteAcosador = new Jinete(2);

        //----------Jinete Aliado fallido se prepara --------
        Jinete jineteAliado = Mockito.mock(Jinete.class);
        Mockito.when(jineteAliado.esEnemigo(jinete)).thenReturn(false);


        //----------Metodos Probados Tablero/Ubicacion --------
        Tablero tablero = Mockito.mock(Tablero.class);
        List<Pieza> lista = Mockito.mock(ArrayList.class);
        Mockito.when(lista.size()).thenReturn(2);
        Mockito.when(lista.get(0)).thenReturn(jineteAcosador);
        Mockito.when(lista.get(1)).thenReturn(jineteAliado);
        Mockito.when(tablero.getPiezasAdyacentes(ubicacionJinete)).thenReturn(lista);
        Mockito.when(jineteAliado.getNombre()).thenReturn("Jinete");

        Mockito.when(ubicacionJinete.getDistanciaAOtroPunto(ubicacionJineteADistancia)).thenReturn(5);

        //----------Ataque ------------------
        jinete.atacar(jineteADistancia,tablero);

    }

    @Test
    public void test08JineteAtacaEnDistanciaMediaSiendoAsediadoYConRefuerzoCorrecto() throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {

        //----------Jinete atacante se prepara --------
        Jinete jinete = new Jinete(1);
        Ubicacion ubicacionJinete = Mockito.mock(Ubicacion.class);
        jinete.setUbicacion(ubicacionJinete);

        //----------Jinete blanco certero --------
        Jinete jineteADistancia = new Jinete(2);
        Ubicacion ubicacionJineteADistancia = Mockito.mock(Ubicacion.class);
        jineteADistancia.setUbicacion(ubicacionJineteADistancia);
        double vida = jineteADistancia.getPuntosVida();

        //----------Jinete acosador se prepara --------
        Jinete jineteAcosador = new Jinete(2);

        //----------Infante Aliado se prepara --------
        Infanteria infanteAliado = Mockito.mock(Infanteria.class);
        Mockito.when(infanteAliado.esEnemigo(jinete)).thenReturn(false);


        //----------Metodos Probados Tablero/Ubicacion --------
        Tablero tablero = Mockito.mock(Tablero.class);
        List<Pieza> lista = Mockito.mock(ArrayList.class);
        Mockito.when(lista.size()).thenReturn(2);
        Mockito.when(lista.get(0)).thenReturn(jineteAcosador);
        Mockito.when(lista.get(1)).thenReturn(infanteAliado);
        Mockito.when(tablero.getPiezasAdyacentes(ubicacionJinete)).thenReturn(lista);
        Mockito.when(infanteAliado.getNombre()).thenReturn("Infanteria");

        Mockito.when(ubicacionJinete.getDistanciaAOtroPunto(ubicacionJineteADistancia)).thenReturn(5);

        //----------Ataque ------------------
        jinete.atacar(jineteADistancia,tablero);
        assertEquals(vida-15,jineteADistancia.getPuntosVida(),0);
    }

    @Test (expected = PiezaAliadaNoAtacableException.class)
    public void test09JineteNoAtacaAliados() throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {

        //----------Jinete atacante se prepara --------
        Jinete jinete = new Jinete(1);
        Ubicacion ubicacionJinete = Mockito.mock(Ubicacion.class);
        jinete.setUbicacion(ubicacionJinete);


        //----------Infante Aliado fallido se prepara --------
        Jinete aliado = Mockito.mock(Jinete.class);
        Ubicacion ubicacionAliado = Mockito.mock(Ubicacion.class);
        aliado.setUbicacion(ubicacionAliado);
        Mockito.when(aliado.getEquipo()).thenReturn(1);


        //----------Metodos Probados Tablero/Ubicacion --------
        Tablero tablero = Mockito.mock(Tablero.class);
        List<Pieza> lista = Mockito.mock(ArrayList.class);
        Mockito.when(lista.size()).thenReturn(0);
        Mockito.when(tablero.getPiezasAdyacentes(ubicacionJinete)).thenReturn(lista);

        //----------Ataque ------------------
        jinete.atacar(aliado,tablero);
    }

}
