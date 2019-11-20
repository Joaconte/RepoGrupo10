package jugador;

import jugador.Ejercito;
import pieza.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;
import pieza.tipos.Catapulta;
import pieza.tipos.Curandero;
import pieza.tipos.Infanteria;
import pieza.tipos.Jinete;

public class EjercitoTest {

    @Test
    public void test01SeAgregaNumeroDeEjercitoCorrectamente(){

        Ejercito ejercito = new Ejercito(1);
        assertEquals(1, ejercito.getNumeroDeEjercito() );
    }

    @Test
    public void test02SeAgregaUnaUnidadCorrectamente(){

        Ejercito ejercito = new Ejercito(1);
        Pieza unaPieza = Mockito.mock( Catapulta.class );
        ejercito.agregarPieza(unaPieza);
        assertEquals(1, ejercito.getTamanio() );
    }


    @Test
    public void test03SeAgregan4PiezasCorrectamente(){

        Ejercito ejercito = new Ejercito(1);
        Pieza unaPieza = Mockito.mock( Catapulta.class );
        Pieza unaPieza2 = Mockito.mock( Jinete.class );
        Pieza unaPieza3 = Mockito.mock( Curandero.class );
        Pieza unaPieza4 = Mockito.mock( Infanteria.class );

        ejercito.agregarPieza(unaPieza);
        ejercito.agregarPieza(unaPieza2);
        ejercito.agregarPieza(unaPieza3);
        ejercito.agregarPieza(unaPieza4);

        assertEquals(4, ejercito.getTamanio() );
    }
}