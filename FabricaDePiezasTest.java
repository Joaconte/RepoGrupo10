package jugador;

import org.junit.Test;
import pieza.Pieza;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;



public class FabricaDePiezasTest {
    @Test
    public void test01PidoUnaPiezaDeCostoUnoYMeDanPiezaDeInfanteria() {
        FabricaDePiezas fabrica = new FabricaDePiezas();
        Ejercito ejercito = new Ejercito(1);
        fabrica.agregarPieza(ejercito,1);
        ArrayList<Pieza> piezas = ejercito.getPiezas();
        assertEquals(1, piezas.get(0).getCosto());
    }

    @Test
    public void test02PidoUnaPiezaDeCostoDosYMeDanPiezaCurandero() {
        FabricaDePiezas fabrica = new FabricaDePiezas();
        Ejercito ejercito = new Ejercito(1);
        fabrica.agregarPieza(ejercito, 2);
        ArrayList<Pieza> piezas = ejercito.getPiezas();
        assertEquals(2, piezas.get(0).getCosto());
    }

    @Test
    public void test03PidoUnaPiezaDeCostoTresYMeDanPiezaJinete() {
        FabricaDePiezas fabrica = new FabricaDePiezas();
        Ejercito ejercito = new Ejercito(1);
        fabrica.agregarPieza(ejercito,3);
        ArrayList<Pieza> piezas = ejercito.getPiezas();
        assertEquals(3, piezas.get(0).getCosto());
    }

    @Test
    public void test04PidoUnaPiezaDeCostoCincoYMeDanPiezaCatapulta() {
        FabricaDePiezas fabrica = new FabricaDePiezas();
        Ejercito ejercito = new Ejercito(1);
        fabrica.agregarPieza(ejercito,5);
        ArrayList<Pieza> piezas = ejercito.getPiezas();
        assertEquals(5, piezas.get(0).getCosto());
    }

    @Test
    public void test05PidoUnaPiezaDeCostoInvalidoNoMeAgregan(){
        FabricaDePiezas fabrica = new FabricaDePiezas();
        Ejercito ejercito = new Ejercito(1);
        fabrica.agregarPieza(ejercito,9);
        assertEquals(0,ejercito.getTamanio());
    }

}


