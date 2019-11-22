package jugador;

import jugador.presupuesto.CompraInvalidaException;
import pieza.Pieza;
import pieza.tipos.*;

public class FabricaDePiezas{

    public Pieza crearPieza(int ejercito, String nombreUnidad) throws CompraInvalidaException {
        switch (nombreUnidad){
            case "Infanteria": return (new Infanteria(ejercito));
            case "Curandero":  return (new Curandero(ejercito));
            case "Jinete": return (new Jinete(ejercito));
            case "Catapulta": return (new Catapulta(ejercito));
            default: throw new CompraInvalidaException();
        }
    }

}