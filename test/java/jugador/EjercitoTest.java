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
        ejercito.comprarPieza("Jinete");
        assertEquals(1, ejercito.getTamanio() );
    }


    @Test
    public void test03SeAgregan4PiezasCorrectamente() throws PresupuestoAgotadoException, CompraInvalidaException {

        Ejercito ejercito = new Ejercito(1);

        ejercito.comprarPieza("Jinete");
        ejercito.comprarPieza("Infanteria");
        ejercito.comprarPieza("Curandero");
        ejercito.comprarPieza("Catapulta");

        assertEquals(4, ejercito.getTamanio() );
    }

}