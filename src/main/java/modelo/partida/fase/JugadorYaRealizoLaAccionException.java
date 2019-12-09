package modelo.partida.fase;

public class JugadorYaRealizoLaAccionException extends Exception {
    public  JugadorYaRealizoLaAccionException(){
        super("2 movimientos y 3 (curas+ataques) por turno.");
    }

}
