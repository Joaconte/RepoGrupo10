package test;

import fiuba.algo3.TP2.model.EstadoPresupuestoNoAgotado;
import fiuba.algo3.TP2.exception.CostoNoValidoException;
import fiuba.algo3.TP2.model.Ejercito;

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
    public void test03PresupuestoSeAgotaYSaleDelEstadoNoAgotadoCorrectamente() {
        try{
            EstadoPresupuestoNoAgotado estado = new EstadoPresupuestoNoAgotado(3);
            Ejercito ejercito = new Ejercito(1);
            estado.agregarPiezas(ejercito, 3);
            assertNotSame(estado, estado.devolverEstadoDePresuesto());
        }
        catch (CostoNoValidoException e){}
    }

    @Test
    public void test04NoPuedoAgregarUnaFichaDeValor5EntoncesNoSeGastaElPresupuestoDeValor3YNoCambiaDeEstado() {
        try {
            EstadoPresupuestoNoAgotado estadoNoAgotado = new EstadoPresupuestoNoAgotado(3);
            Ejercito ejercito = new Ejercito(1);
            estadoNoAgotado.agregarPiezas(ejercito, 5);
            assertEquals(estadoNoAgotado, estadoNoAgotado.devolverEstadoDePresuesto());
        }
        catch (CostoNoValidoException e){}
    }

    @Test (expected = CostoNoValidoException.class)
    public void test05PidoUnaPiezaDeCostoInvalidoYMeDanUnaExcepcion() throws CostoNoValidoException{
        EstadoPresupuestoNoAgotado estado = new EstadoPresupuestoNoAgotado(10);
        Ejercito ejercito = new Ejercito(1);
        estado.agregarPiezas(ejercito, 10);
    }

}