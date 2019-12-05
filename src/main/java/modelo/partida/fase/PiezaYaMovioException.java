package modelo.partida.fase;

public class PiezaYaMovioException extends Exception {
    public  PiezaYaMovioException(){ super("Esta pieza ya se movio este turno."); }
}