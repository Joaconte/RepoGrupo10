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
        Catapulta unaPieza = Mockito.mock( Catapulta.class );
        ejercito.agregarCatapulta(unaPieza);
        assertEquals(1, ejercito.getTamanio() );
    }


    @Test
    public void test03SeAgregan10PiezasCorrectamente(){

        Ejercito ejercito = new Ejercito(1);
        Catapulta unaPieza = Mockito.mock( Catapulta.class );
        Jinete unaPieza2 = Mockito.mock( Jinete.class );
        Curandero unaPieza3 = Mockito.mock( Curandero.class );
        Infanteria unaPieza4 = Mockito.mock( Infanteria.class );
        ejercito.agregarJinete(unaPieza2);
        ejercito.agregarCurandero(unaPieza3);
        ejercito.agregarCatapulta(unaPieza);
        ejercito.agregarInfante(unaPieza4);
        ejercito.agregarJinete(unaPieza2);
        ejercito.agregarCurandero(unaPieza3);
        ejercito.agregarCatapulta(unaPieza);
        ejercito.agregarInfante(unaPieza4);
        ejercito.agregarJinete(unaPieza2);
        ejercito.agregarCurandero(unaPieza3);

        assertEquals(10, ejercito.getTamanio() );
    }

}