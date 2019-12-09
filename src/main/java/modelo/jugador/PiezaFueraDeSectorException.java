package modelo.jugador;

public class PiezaFueraDeSectorException extends Exception {
    public PiezaFueraDeSectorException(){
        super("La pieza en Sector ajeno.");
    }
}
