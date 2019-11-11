package fiuba.algo3.TP2.model;

import java.util.ArrayList;
import java.util.List;

public class FabricaDePiezas{

    public Pieza getPieza(int costoUnidad){
        switch (costoUnidad){
            case 1: return new Infanteria();
            case 2: return new Jinete ();
            case 3: return new Curandero ();
            case 4: return new Catapulta ();
            default: return null;
        }
    }

}