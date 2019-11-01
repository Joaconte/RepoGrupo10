import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class PruebaTest {
    @Test
    public void sumaEsCorrecta() {
        Prueba tester = new Prueba();
        assertEquals(4, tester.suma(1,3));
        assertEquals(0, tester.suma(1,-1));
        assertEquals(67, tester.suma(65,2));
    }
}