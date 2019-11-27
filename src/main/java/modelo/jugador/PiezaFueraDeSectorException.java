package modelo.jugador;

public class PiezaFueraDeSectorException extends Exception {
    public PiezaFueraDeSectorException(){
        super("La pieza se intenta colocar en Sector ajeno.");
    }
}
