package jugador;

import pieza.tipos.*;

public class FabricaDePiezas{

    public void agregarPieza(Ejercito ejercito, int costoUnidad){
        switch (costoUnidad){
            case 1: ejercito.agregarInfante(new Infanteria());
            break;
            case 2: ejercito.agregarCurandero(new Curandero());
            break;
            case 3: ejercito.agregarJinete(new Jinete());
            break;
            case 5: ejercito.agregarCatapulta(new Catapulta());
            break;
            default:
        }
    }

}