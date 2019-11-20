package jugador;

import pieza.tipos.*;

public class FabricaDePiezas{

    public void agregarPieza(Ejercito ejercito, int costoUnidad){
        switch (costoUnidad){
            case 1: ejercito.agregarPieza(new Infanteria());
            break;
            case 2: ejercito.agregarPieza(new Curandero());
            break;
            case 3: ejercito.agregarPieza(new Jinete());
            break;
            case 5: ejercito.agregarPieza(new Catapulta());
            break;
            default:
        }
    }

}