package test;

import fiuba.algo3.TP2.model.Ejercito;
import fiuba.algo3.TP2.model.Pieza;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.Mock;
import org.mockito.Mockito;

public class EjercitoTest {

    @Test
    public void test01SeAgregaNumeroDeEjercitoCorrectamente(){

        Ejercito ejercito = new Ejercito(1);
        assertEquals(1, ejercito.getNumeroDeEjercito() );
    }

    @Test
    public void test02SeAgregaUnaUnidadCorrectamente(){

        Ejercito ejercito = new Ejercito(1);
        Pieza unaPieza = Mockito.mock( Pieza.class );
        ejercito.agregarPieza(unaPieza);
        assertEquals(1, ejercito.getTamanio() );
    }


    @Test
    public void test03SeAgregaYRemueveUnaPiezaCorrectamente(){

        Ejercito ejercito = new Ejercito(1);
        Pieza unaPieza = Mockito.mock( Pieza.class );
        ejercito.agregarPieza(unaPieza);
        ejercito.removerPieza(0);
        assertEquals(0, ejercito.getTamanio() );
    }

    @Test
    public void test03SeAgregan10PiezasYRemuevenDosPiezasCorrectamente(){

        Ejercito ejercito = new Ejercito(1);
        Pieza unaPieza = Mockito.mock( Pieza.class );
        ejercito.agregarPieza(unaPieza);
        ejercito.agregarPieza(unaPieza);
        ejercito.agregarPieza(unaPieza);
        ejercito.agregarPieza(unaPieza);
        ejercito.agregarPieza(unaPieza);
        ejercito.agregarPieza(unaPieza);
        ejercito.agregarPieza(unaPieza);
        ejercito.agregarPieza(unaPieza);
        ejercito.agregarPieza(unaPieza);
        ejercito.agregarPieza(unaPieza);

        ejercito.removerPieza(0);
        ejercito.removerPieza(0);
        assertEquals(8, ejercito.getTamanio() );
    }

}