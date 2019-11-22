package jugador;

import jugador.presupuesto.CompraInvalidaException;
import jugador.presupuesto.EstadoPresupuestoNoAgotado;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;



public class EstadoPresupuestoNoAgotadoTest {
    @Test
    public void test01EstadoPresupuestoNoAgotadoSeDevuelveASiMismoComoEstadoDePresupuestoCuandoAunHayPresupuesto() {
        EstadoPresupuestoNoAgotado estado = new EstadoPresupuestoNoAgotado(1);
        assertEquals(estado, estado.devolverEstadoDePresuesto());
    }

    @Test
    public void test02EstadoPresupuestoNoAgotadoNoSeDevuelveCuandoYaNoHayPresupuesto() {
        EstadoPresupuestoNoAgotado estadoAgotado = new EstadoPresupuestoNoAgotado(0);
        assertNotSame(estadoAgotado, estadoAgotado.devolverEstadoDePresuesto());
    }

    @Test
    public void test03PresupuestoSeAgotaYSaleDelEstadoNoAgotadoCorrectamente() throws CompraInvalidaException {
        EstadoPresupuestoNoAgotado estado = new EstadoPresupuestoNoAgotado(3);
        estado.comprarPieza(1, "Jinete");
        assertNotSame(estado, estado.devolverEstadoDePresuesto());
    }

    @Test (expected = CompraInvalidaException.class)
    public void test04NoPuedoDarUnaFichaDeValor5Teniendo3DePresupuesto() throws CompraInvalidaException {
        EstadoPresupuestoNoAgotado estadoNoAgotado = new EstadoPresupuestoNoAgotado(3);
        estadoNoAgotado.comprarPieza(1, "Catapulta");
    }

}