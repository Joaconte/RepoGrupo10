package modelo.jugador;

import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



public class EjercitoTest {

    @Test
    public void test01SeAgregaNumeroDeEjercitoCorrectamente(){

        Ejercito ejercito = new Ejercito(1);
        assertEquals(1, ejercito.getNumeroDeEjercito() );
    }

    @Test
    public void test02SeAgregaUnaUnidadCorrectamente() throws PresupuestoAgotadoException, CompraInvalidaException {

        Ejercito ejercito = new Ejercito(1);
        ejercito.obtenerNuevaPieza("Jinete",1,1);
        assertEquals(1, ejercito.getTamanio() );
    }


    @Test
    public void test03SeAgregan4PiezasCorrectamente() throws PresupuestoAgotadoException, CompraInvalidaException {

        Ejercito ejercito = new Ejercito(1);

        ejercito.obtenerNuevaPieza("Jinete",1,1);
        ejercito.obtenerNuevaPieza("Infanteria",2,1);
        ejercito.obtenerNuevaPieza("Curandero",3,1);
        ejercito.obtenerNuevaPieza("Catapulta",4,1);

        assertEquals(4, ejercito.getTamanio() );
    }

    @Test
    public void test04EjercitoConPresupuestoAgotadoNoArrojaExcepcionAlVerificarSiEstaCompleto() throws PresupuestoAgotadoException, CompraInvalidaException {

        Ejercito ejercito = new Ejercito(1);
        ejercito.obtenerNuevaPieza("Catapulta",1,1);
        ejercito.obtenerNuevaPieza("Catapulta",1,1);
        ejercito.obtenerNuevaPieza("Catapulta",1,1);
        ejercito.obtenerNuevaPieza("Catapulta",1,1);
        assertTrue(ejercito.verificarSiEstaCompleto());
    }

    @Test
    public void test05EjercitoSinPresupuestoAgotadoArrojaExcepcionAlVerificarSiEstaCompleto() throws  EjercitoIncompletoException {

        Ejercito ejercito = new Ejercito(1);
        assertFalse(ejercito.verificarSiEstaCompleto());
    }
}