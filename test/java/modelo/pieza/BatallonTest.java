package modelo.pieza;

import modelo.pieza.movimiento.Ubicacion;
import modelo.pieza.tipos.*;
import modelo.tablero.Tablero;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BatallonTest {
/*
    @Test
    public void test01BatallonSeCreaCorrectamente() throws NoSirvenParaBatallonException {
        Infanteria pieza1  = new Infanteria(1,1,1);
        Infanteria pieza2  = new Infanteria(1,2,1);
        Infanteria pieza3  = new Infanteria(1,3,1);
        ArrayList<Pieza> listado = new ArrayList<>();
        listado.add(pieza1);
        listado.add(pieza2);
        listado.add(pieza3);
        Batallon batallon = new Batallon(listado);
        assertNotNull(batallon);
    }

    @Test
    public void test02BatallonPuedeMoverSusTresTropasHaciaAbajoEntoncesElListadoDePiezasAMoverEsDeTresUnidades() throws NoSirvenParaBatallonException {
        Infanteria pieza1  = new Infanteria(1,1,1);
        Infanteria pieza2  = new Infanteria(1,2,2);
        Infanteria pieza3  = new Infanteria(1,3,3);
        ArrayList<Pieza> listado = new ArrayList<>();

        listado.add(pieza1);
        listado.add(pieza2);
        listado.add(pieza3);

        Batallon batallon = new Batallon(listado);
        Tablero tablero = new Tablero();

        Ubicacion ubicacionInicialDelQueComanda = new Ubicacion(1,1);
        Ubicacion ubicacionFinalHaciaAbajo = new Ubicacion(2,1);

        tablero.ocuparCasilla(pieza1,1,1);
        tablero.ocuparCasilla(pieza2,2,2);
        tablero.ocuparCasilla(pieza3,3,3);
        assertEquals(3, batallon.ordenarMovimiento(tablero,ubicacionInicialDelQueComanda,ubicacionFinalHaciaAbajo).size());
    }


    public void test03BatallonPuedeMoverSoloUnaTropaHaciaArribaEntoncesElListadoDePiezasParaMoverEsUno() throws NoSirvenParaBatallonException {
        Infanteria pieza1  = new Infanteria(1,0,0);
        Infanteria pieza2  = new Infanteria(1,1,0);
        Infanteria pieza3  = new Infanteria(1,1,1);
        ArrayList<Pieza> listado = new ArrayList<>();

        listado.add(pieza1);
        listado.add(pieza2);
        listado.add(pieza3);

        Batallon batallon = new Batallon(listado);
        Tablero tablero = new Tablero();

        Ubicacion ubicacionInicialDelQueComanda = new Ubicacion(1,1);
        Ubicacion ubicacionFinalHaciaArriba = new Ubicacion(1,0);

        tablero.ocuparCasilla(pieza1,0,0);
        tablero.ocuparCasilla(pieza2,1,0);
        tablero.ocuparCasilla(pieza3,1,1);
        assertEquals(1, batallon.ordenarMovimiento(tablero,ubicacionInicialDelQueComanda,ubicacionFinalHaciaArriba).size());
    }

    public void test04BatallonPuedeMoverSoloUnaTropaHaciaArribaYLaMueveCorrectamente() throws NoSirvenParaBatallonException {
        Infanteria pieza1  = new Infanteria(1,0,0);
        Infanteria pieza2  = new Infanteria(1,1,0);
        Infanteria pieza3  = new Infanteria(1,1,1);
        ArrayList<Pieza> listado = new ArrayList<>();

        listado.add(pieza1);
        listado.add(pieza2);
        listado.add(pieza3);

        Batallon batallon = new Batallon(listado);
        Tablero tablero = new Tablero();

        Ubicacion ubicacionInicialDelQueComanda = new Ubicacion(1,1);
        Ubicacion ubicacionFinalHaciaArriba = new Ubicacion(1,0);

        tablero.ocuparCasilla(pieza1,0,0);
        tablero.ocuparCasilla(pieza2,1,0);
        tablero.ocuparCasilla(pieza3,1,1);
        batallon.desplazaBatallonEnOrden(tablero,ubicacionInicialDelQueComanda,ubicacionFinalHaciaArriba);

        assertTrue(pieza1.getUbicacion().esIgual(ubicacionFinalHaciaArriba));
      }*/

}
