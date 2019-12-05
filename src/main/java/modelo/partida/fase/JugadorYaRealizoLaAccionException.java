package modelo.partida.fase;

public class JugadorYaRealizoLaAccionException extends Exception {
    public  JugadorYaRealizoLaAccionException(){
        super("Accion de turno gastada.");
    }

}
