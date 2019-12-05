package modelo.partida.fase;

public class PiezaYaAtacoException extends Exception {
    public  PiezaYaAtacoException(){ super("Esta pieza ya ataco o curo este turno."); }
}
