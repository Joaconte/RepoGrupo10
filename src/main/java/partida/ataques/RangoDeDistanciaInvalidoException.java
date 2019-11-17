package partida.ataques;

public class RangoDeDistanciaInvalidoException extends Exception {
    public RangoDeDistanciaInvalidoException(){
        super("La distancia esta fuera de rango");
    }

}
