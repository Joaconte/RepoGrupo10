package modelo.pieza;

import modelo.pieza.tipos.Batallon;
import modelo.pieza.tipos.Infanteria;
import modelo.pieza.tipos.NoSirvenParaBatallonException;
import modelo.tablero.Tablero;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BatallonTest {

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
    public void test02TropaQueChocaAOtraQuedaEnUltimaPosicion() throws NoSirvenParaBatallonException {
        Infanteria piezaQueDaOrdenDeMoverse  = new Infanteria(1,0,0);
        Infanteria piezaQueChocaAPieza3  = new Infanteria(1,1,0);
        Infanteria pieza3  = new Infanteria(1,1,1);
        ArrayList<Pieza> listado = new ArrayList<>();

        listado.add(piezaQueDaOrdenDeMoverse);
        listado.add(piezaQueChocaAPieza3);
        listado.add(pieza3);

        Batallon batallon = new Batallon(listado);
        Tablero tablero = new Tablero();

        int posicionFinalXparaPiezaQueDaOrden=0;
        int posicionFinalYparaPiezaQueDaOrden=1;


        tablero.ocuparCasilla(piezaQueDaOrdenDeMoverse,0,0);
        tablero.ocuparCasilla(piezaQueChocaAPieza3,1,0);
        tablero.ocuparCasilla(pieza3,1,1);

        ArrayList<Pieza> piezas = new ArrayList<>();
        piezas.add(piezaQueDaOrdenDeMoverse);
        ArrayList<Integer> posicionesFinalesY = new ArrayList<>();
        ArrayList<Integer> posicionesFinalesX = new ArrayList<>();

        batallon.ordenarFormacion(piezas,posicionesFinalesX,posicionesFinalesY,posicionFinalXparaPiezaQueDaOrden,posicionFinalYparaPiezaQueDaOrden);

        assertTrue(piezas.get(2)==piezaQueChocaAPieza3);
      }

    @Test
    public void test03PosicionEnXeYDelUltimoEnMoverseEstanBienRegistradas() throws NoSirvenParaBatallonException {
        Infanteria piezaQueDaOrdenDeMoverse  = new Infanteria(1,0,0);
        Infanteria piezaQueChocaAPieza3  = new Infanteria(1,1,0);
        Infanteria pieza3  = new Infanteria(1,1,1);
        ArrayList<Pieza> listado = new ArrayList<>();

        listado.add(piezaQueDaOrdenDeMoverse);
        listado.add(piezaQueChocaAPieza3);
        listado.add(pieza3);

        Batallon batallon = new Batallon(listado);
        Tablero tablero = new Tablero();

        int posicionFinalXparaPiezaQueDaOrden=0;
        int posicionFinalYparaPiezaQueDaOrden=1;


        tablero.ocuparCasilla(piezaQueDaOrdenDeMoverse,0,0);
        tablero.ocuparCasilla(piezaQueChocaAPieza3,1,0);
        tablero.ocuparCasilla(pieza3,1,1);

        ArrayList<Pieza> piezas = new ArrayList<>();
        piezas.add(piezaQueDaOrdenDeMoverse);
        ArrayList<Integer> posicionesFinalesY = new ArrayList<>();
        ArrayList<Integer> posicionesFinalesX = new ArrayList<>();

        batallon.ordenarFormacion(piezas,posicionesFinalesX,posicionesFinalesY,posicionFinalXparaPiezaQueDaOrden,posicionFinalYparaPiezaQueDaOrden);

        //Igual a la posicion de la pieza a la que choca.
        assertEquals(1,(int)posicionesFinalesX.get(2));
        assertEquals(1,(int)posicionesFinalesY.get(2));
    }

}
