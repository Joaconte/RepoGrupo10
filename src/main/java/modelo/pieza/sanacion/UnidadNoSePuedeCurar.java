package modelo.pieza.sanacion;

public class UnidadNoSePuedeCurar extends Exception {
    public UnidadNoSePuedeCurar() {
        super("No podes curar esta pieza");
    }
}
