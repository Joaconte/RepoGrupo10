package jugador;

import jugador.presupuesto.CompraInvalidaException;
import pieza.Pieza;
import pieza.tipos.*;

public class FabricaDePiezas{

    public Pieza crearPieza(int ejercito, String nombreUnidad,int posX, int posY) throws CompraInvalidaException {
        switch (nombreUnidad){
            case "Infanteria": return (new Infanteria(ejercito,posX,posY));
            case "Curandero":  return (new Curandero(ejercito,posX,posY));
            case "Jinete": return (new Jinete(ejercito,posX,posY));
            case "Catapulta": return (new Catapulta(ejercito,posX,posY));
            default: throw new CompraInvalidaException();
        }
    }

}