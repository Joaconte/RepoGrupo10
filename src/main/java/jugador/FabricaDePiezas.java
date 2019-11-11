package jugador;

import jugador.presupuesto.CostoNoValidoException;
import pieza.Pieza;
import pieza.tipos.*;

public class FabricaDePiezas{

    public Pieza getPieza(int costoUnidad) throws CostoNoValidoException {
        switch (costoUnidad){
            case 1: return new Infanteria();
            case 2: return new Curandero();
            case 3: return new Jinete();
            case 5: return new Catapulta();
            default:  throw new CostoNoValidoException();
        }
    }

}