package test;

import fiuba.algo3.TP2.model.EstadoPresupuestoAgotado;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class EstadoPresupuestoAgotadoTest  {
    @Test
    public void test01EstadoPresupuestoAgotadoSeDevuelveASiMismoComoEstadoDePresupuesto() {
        EstadoPresupuestoAgotado estado = new EstadoPresupuestoAgotado();
        assertEquals(estado, estado.devolverEstadoDePresuesto());
    }

}