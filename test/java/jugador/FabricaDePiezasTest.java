package jugador;

import jugador.*;
import jugador.presupuesto.CostoNoValidoException;
import org.junit.Test;
import pieza.Pieza;

import static org.junit.Assert.assertEquals;



public class FabricaDePiezasTest {
    @Test
    public void test01PidoUnaPiezaDeCostoUnoYMeDanPiezaDeInfanteria() {
        try{
            FabricaDePiezas fabrica = new FabricaDePiezas();
            Pieza infante = fabrica.getPieza(1);
            assertEquals(100,infante.getPuntosVida(),00);
            assertEquals(1,infante.getCosto());
        }
        catch (CostoNoValidoException e){}
    }

    @Test
    public void test02PidoUnaPiezaDeCostoDosYMeDanPiezaCurandero() {
        try{
            FabricaDePiezas fabrica = new FabricaDePiezas();
            Pieza curandero = fabrica.getPieza(2);
            assertEquals(75,curandero.getPuntosVida(),00);
            assertEquals(2,curandero.getCosto());
        }
        catch (CostoNoValidoException e){}
    }

    @Test
    public void test03PidoUnaPiezaDeCostoTresYMeDanPiezaJinete() {
        try{
            FabricaDePiezas fabrica = new FabricaDePiezas();
            Pieza jinete = fabrica.getPieza(3);
            assertEquals(100,jinete.getPuntosVida(),00);
            assertEquals(3,jinete.getCosto());
        }
        catch (CostoNoValidoException e){}
    }

    @Test
    public void test04PidoUnaPiezaDeCostoCincoYMeDanPiezaCatapulta() {
        try{
            FabricaDePiezas fabrica = new FabricaDePiezas();
            Pieza catapulta = fabrica.getPieza(5);
            assertEquals(50,catapulta.getPuntosVida(),00);
            assertEquals(5,catapulta.getCosto());
        }
        catch (CostoNoValidoException e){}
    }

    @Test (expected = CostoNoValidoException.class)
    public void test05PidoUnaPiezaDeCostoInvalidoYMeDanUnaExcepcion() throws CostoNoValidoException{
        FabricaDePiezas fabrica = new FabricaDePiezas();
        Pieza piezaInvalida = fabrica.getPieza(4);
    }
}


