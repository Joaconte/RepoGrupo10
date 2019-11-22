package pieza.ataque;

public class DistanciaDeAtaqueInvalidaException extends Exception {
    public DistanciaDeAtaqueInvalidaException(){
        super("La distancia esta fuera de rango");
    }

}
