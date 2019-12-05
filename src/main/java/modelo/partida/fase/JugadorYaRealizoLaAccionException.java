package modelo.partida.fase;

public class JugadorYaRealizoLaAccionException extends Exception {
    public  JugadorYaRealizoLaAccionException(){
        super("Ya se movieron 2 unidades este turno.");
    }

}
