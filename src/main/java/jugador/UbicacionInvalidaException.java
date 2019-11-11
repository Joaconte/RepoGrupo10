package jugador;

public class UbicacionInvalidaException extends Exception{

    public UbicacionInvalidaException(){
        super("Esa ubicacion ya esta ocupada");
    }
}

