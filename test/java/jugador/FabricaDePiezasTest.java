package jugador;

import org.junit.Test;
import pieza.tipos.*;

import static org.junit.Assert.assertEquals;



public class FabricaDePiezasTest {
    @Test
    public void test01PidoUnaPiezaDeCostoUnoYMeDanPiezaDeInfanteria() {
        FabricaDePiezas fabrica = new FabricaDePiezas();
        Ejercito ejercito = new Ejercito(1);
        fabrica.agregarPieza(ejercito,1);
        assertEquals(1,ejercito.getCantidadInfantes());
    }

    @Test
    public void test02PidoUnaPiezaDeCostoDosYMeDanPiezaCurandero() {
        FabricaDePiezas fabrica = new FabricaDePiezas();
        Ejercito ejercito = new Ejercito(1);
        fabrica.agregarPieza(ejercito, 2);
        assertEquals(1, ejercito.getCantidadCuranderos());
    }

    @Test
    public void test03PidoUnaPiezaDeCostoTresYMeDanPiezaJinete() {
        FabricaDePiezas fabrica = new FabricaDePiezas();
        Ejercito ejercito = new Ejercito(1);
        fabrica.agregarPieza(ejercito,3);
        assertEquals(1,ejercito.getCantidadJinetes());
    }

    @Test
    public void test04PidoUnaPiezaDeCostoCincoYMeDanPiezaCatapulta() {
        FabricaDePiezas fabrica = new FabricaDePiezas();
        Ejercito ejercito = new Ejercito(1);
        fabrica.agregarPieza(ejercito,5);
        assertEquals(1,ejercito.getCantidadCatapultas());
    }

    @Test
    public void test05PidoUnaPiezaDeCostoInvalidoNoMeAgregan(){
        FabricaDePiezas fabrica = new FabricaDePiezas();
        Ejercito ejercito = new Ejercito(1);
        fabrica.agregarPieza(ejercito,9);
        assertEquals(0,ejercito.getTamanio());
    }

}


