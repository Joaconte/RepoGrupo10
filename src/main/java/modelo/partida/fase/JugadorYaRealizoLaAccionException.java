package modelo.partida.fase;

public class JugadorYaRealizoLaAccionException extends Exception {
    public  JugadorYaRealizoLaAccionException(){
        super("Jugador no puede volver a hacer la accion en un mismo turno.");
    }

}
