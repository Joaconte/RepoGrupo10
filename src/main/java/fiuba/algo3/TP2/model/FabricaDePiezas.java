package fiuba.algo3.TP2.model;

import fiuba.algo3.TP2.exception.CostoNoValidoException;
import java.util.ArrayList;
import java.util.List;

public class FabricaDePiezas{

    public Pieza getPieza(int costoUnidad) throws CostoNoValidoException{
        switch (costoUnidad){
            case 1: return new Infanteria();
            case 2: return new Curandero ();
            case 3: return new Jinete ();
            case 5: return new Catapulta ();
            default:  throw new CostoNoValidoException();
        }
    }

}