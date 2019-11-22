package jugador;

import jugador.presupuesto.CompraInvalidaException;
import org.junit.Test;
import pieza.Pieza;
import pieza.tipos.Catapulta;
import pieza.tipos.Curandero;
import pieza.tipos.Infanteria;
import pieza.tipos.Jinete;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;



public class FabricaDePiezasTest {
    @Test
    public void test01PidoUnaPiezaInfanteriaYMeDanPiezaDeInfanteria() throws CompraInvalidaException {
        FabricaDePiezas fabrica = new FabricaDePiezas();
        assertEquals(Infanteria.class, fabrica.crearPieza(1,"Infanteria").getClass());
    }

    @Test
    public void test02PidoUnaPiezaCuranderoYMeDanPiezaCurandero() throws CompraInvalidaException {
        FabricaDePiezas fabrica = new FabricaDePiezas();
        assertEquals(Curandero.class, fabrica.crearPieza(1,"Curandero").getClass());
    }

    @Test
    public void test03PidoUnaPiezaJineteYMeDanPiezaJinete() throws CompraInvalidaException {
        FabricaDePiezas fabrica = new FabricaDePiezas();
        assertEquals(Jinete.class, fabrica.crearPieza(1,"Jinete").getClass());
    }

    @Test
    public void test04PidoUnaPiezaDeCatapultaYMeDanPiezaCatapulta() throws CompraInvalidaException {
        FabricaDePiezas fabrica = new FabricaDePiezas();
        assertEquals(Catapulta.class, fabrica.crearPieza(1,"Catapulta").getClass());
    }

    @Test(expected = CompraInvalidaException.class)
    public void test05PidoUnaPiezaInvalidaYMeDanException() throws CompraInvalidaException {
        FabricaDePiezas fabrica = new FabricaDePiezas();
        fabrica.crearPieza(1,"JineteCuranderoConCatapultaArrojaInfantesEnAmarillo");
    }

}


