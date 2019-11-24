package jugador;

import jugador.presupuesto.CompraInvalidaException;
import jugador.presupuesto.PresupuestoAgotadoException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;



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

}