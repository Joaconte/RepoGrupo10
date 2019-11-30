package modelo.pieza;

import modelo.pieza.tipos.Catapulta;
import modelo.pieza.tipos.Curandero;
import modelo.pieza.tipos.Infanteria;
import org.junit.Test;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.pieza.tipos.Jinete;
import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;
import modelo.tablero.Tablero;

import java.util.*;

public class JineteTest {

    @Test
    public void test00JineteSeCreaConEquipo1Correctamente() {
        Jinete jinete = new Jinete(1,5,5);
        assertEquals(1, jinete.getEquipo());
    }

    @Test
    public void test01JineteTieneCosto3() {
        Jinete jinete = new Jinete(1,5,5);
        assertEquals(3, jinete.getCosto());
    }

    @Test
    public void test02JineteIniciaCon100PuntosDeVida() {
        Jinete jinete = new Jinete(1,1,1);
        assertEquals(100, jinete.getPuntosVida(),0);
    }

    @Test
    public void test03JineteAtacaADistanciaMediaMaximaAEnemigoYSaca15PuntosDeVida() throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {

        Jinete jineteAtacante = new Jinete(1,1,1);  //----------Jinete atacante
        Jinete oponente = new Jinete(2,6,6);  //----------Enemigo atacado Media distancia
        double vidaAntesDelAtaque= oponente.getPuntosVida();

        //----------Metodos Probados Tablero/Ubicacion
        Tablero tablero = Mockito.mock(Tablero.class);
        List<Pieza> lista = new ArrayList<>();
        Mockito.when(tablero.getPiezasAdyacentes(jineteAtacante.getUbicacion())).thenReturn(lista);

        //----------Ataque ------------------
        jineteAtacante.atacar(oponente,tablero);
        assertEquals(vidaAntesDelAtaque-15,oponente.getPuntosVida(),0);
    }

    @Test (expected = DistanciaDeAtaqueInvalidaException.class)
    public void test04JineteNoAtacaAMediaDistanciaAEnemigoPorqueEstaAsediadoYNoTieneRefuerzos() throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {

        Jinete jinete = new Jinete(1,1,1); //----------Jinete atacante
        Jinete oponente = new Jinete(2,4,4); //-----Blanco enemigo media distancia
        Jinete jineteAcosador = new Jinete(2,1,2);//-----Enemigo asediador

        //----------Metodos Probados Tablero/Ubicacion -------
        Tablero tablero = Mockito.mock(Tablero.class);
        List<Pieza> lista = new ArrayList<>();
        lista.add(jineteAcosador);
        Mockito.when(tablero.getPiezasDentroDeRadio(jinete.getUbicacion(),2)).thenReturn(lista);

        //----------Ataque -----------------
        jinete.atacar(oponente,tablero);
    }

    @Test (expected = DistanciaDeAtaqueInvalidaException.class)
    public void test05JineteNoPuedeAtacarACortaDistanciaCuandoEstaCubiertoYAsediado() throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {

        Jinete jinete = new Jinete(1,9,9); //----------Jinete atacante
        Jinete oponenteCercano = new Jinete(2,9,8); //----------Enemigo atacado que asedia

        Infanteria infanteAliado = new Infanteria(1,8,8);

        //----------Metodos Probados Tablero/Ubicacion ------
        Tablero tablero = Mockito.mock(Tablero.class);
        List<Pieza> lista = new ArrayList<>();
        lista.add(infanteAliado);
        lista.add(oponenteCercano);
        Mockito.when(tablero.getPiezasDentroDeRadio(jinete.getUbicacion(),2)).thenReturn(lista);

        //----------Ataque ------------------
        jinete.atacar(oponenteCercano,tablero);
    }

    @Test
    public void test06JineteAtacaACortaDistanciaAEnemigoQueLoAsediaSinEstarCuebierto() throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {

        Jinete jinete = new Jinete(1,6,6); //----------Jinete atacante
        Jinete oponenteCercano = new Jinete(2,8,7); //------Enemigo atacado que asedia
        double vidaAntesDelAtaque = oponenteCercano.getPuntosVida();

        //----------Metodos Probados Tablero/Ubicacion ------
        Tablero tablero = Mockito.mock(Tablero.class);
        List<Pieza> lista =  new ArrayList<>();
        lista.add(oponenteCercano);
        Mockito.when(tablero.getPiezasDentroDeRadio(jinete.getUbicacion(),2)).thenReturn(lista);


        //----------Ataque ------------------
        jinete.atacar(oponenteCercano,tablero);
        assertEquals(vidaAntesDelAtaque-5,oponenteCercano.getPuntosVida(),0);
    }

    @Test(expected= DistanciaDeAtaqueInvalidaException.class)
    public void test07JineteNoAtacaAEnemigoAMediaDistanciaPorqueUnidadDistintaAInfanteEsUnicoRefuerzoYEstaSiendoAsediado() throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {

        Jinete jinete = new Jinete(1,2,2); //----------Jinete atacante
        Jinete jineteAliado = new Jinete (1,2,1); //---- Aliado jinete cercano
        Curandero curanderoAliado = new Curandero(1,1,2); //---- Aliado curandero cercano
        Catapulta catapultaAliada = new Catapulta(1,2,3); //---- Aliado Catapulta cercano

        Jinete jineteADistancia = new Jinete(2,5,4);  //----Enemigo Blanco fallido medio-lejano
        Jinete jineteAcosador = new Jinete(2,3,3);  //--------Enemigo Asediador


        //----------Metodos Probados Tablero/Ubicacion --------
        Tablero tablero = Mockito.mock(Tablero.class);
        List<Pieza> lista = new ArrayList<>();
        lista.add(jineteAliado);
        lista.add(curanderoAliado);
        lista.add(catapultaAliada);
        lista.add(jineteAcosador);
        Mockito.when(tablero.getPiezasDentroDeRadio(jinete.getUbicacion(),2)).thenReturn(lista);

        //----------Ataque ------------------
        jinete.atacar(jineteADistancia,tablero);
    }

    @Test
    public void test08JineteAtacaEnDistanciaMediaSiendoAsediadoYConRefuerzoCorrecto() throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {

        Jinete jinete = new Jinete(1, 1, 1); //----------Jinete atacante
        Jinete jineteADistancia = new Jinete(2, 5,5 ); //---Enemigo atacado a media distancia
        double vidaAntesDelAtaque = jineteADistancia.getPuntosVida();

        Jinete jineteAcosador = new Jinete(2,2,2 ); //-----Enemigo a corta distancia
        Infanteria infanteAliado = new Infanteria(1,2,1); //---Infante Aliado a corta distancia


        //----------Metodos Probados Tablero/Ubicacion --------
        Tablero tablero = Mockito.mock(Tablero.class);
        List<Pieza> lista = new ArrayList<>();
        lista.add(jineteAcosador);
        lista.add(infanteAliado);
        Mockito.when(tablero.getPiezasDentroDeRadio(jinete.getUbicacion(),2)).thenReturn(lista);

        //----------Ataque ------------------
        jinete.atacar(jineteADistancia,tablero);
        assertEquals(vidaAntesDelAtaque-15,jineteADistancia.getPuntosVida(),0);
    }

    @Test (expected = PiezaAliadaNoAtacableException.class)
    public void test09JineteNoAtacaAliados() throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {

        Jinete jinete = new Jinete(1, 1,1 ); //---Atacante
        Jinete aliado = new Jinete(1, 2,1 ); //---Atacado aliado

        //----------Metodos Probados Tablero/Ubicacion --------
        Tablero tablero = Mockito.mock(Tablero.class);
        List<Pieza> lista = new ArrayList<>();
        Mockito.when(tablero.getPiezasDentroDeRadio(jinete.getUbicacion(),2)).thenReturn(lista);

        //----------Ataque ------------------
        jinete.atacar(aliado,tablero);
    }

}
