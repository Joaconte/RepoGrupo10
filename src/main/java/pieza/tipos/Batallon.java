package pieza.tipos;

import pieza.Pieza;
import pieza.Ubicacion;
import pieza.UnidadEstaMuertaException;
import pieza.ataque.DistanciaDeAtaqueInvalidaException;
import pieza.ataque.PiezaAliadaNoAtacableException;
import pieza.ataque.PiezaAtacante;
import pieza.movimiento.*;
import tablero.Tablero;

import java.util.ArrayList;

public class Batallon {

    private ArrayList<Infanteria> soldados = new ArrayList<Infanteria>();

    public Batallon(Infanteria primerSoldado, Infanteria segundoSoldado, Infanteria tercerSoldado){
        soldados.add(primerSoldado);
        soldados.add(segundoSoldado);
        soldados.add(tercerSoldado);

    }

    public void atacar(Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {
        /* ataca solo 1 o todos los que tengan un enemigo a rango*/

    }

    public String getNombre() {
        return "Batallon";
    }


    /*public void moverBatallon(Ubicacion ubicacionActual, Ubicacion miNuevaUbicacion){

        soldados.get(0).moverUnidad(ubicacionActual, miNuevaUbicacion);
        soldados.get(1).moverUnidad(ubicacionActual, miNuevaUbicacion);
        soldados.get(2).moverUnidad(ubicacionActual, miNuevaUbicacion);
    }*/

    /* Acá quiero ignorar si una pieza no se pudo mover */
    public void mover(Tablero tablero, Direccion direccion) {
        boolean recorrerDesc = (direccion.getClass() == Derecha.class)||(direccion.getClass() == Abajo.class)||
                (direccion.getClass() == AbajoDerecha.class)||(direccion.getClass() == AbajoIzquierda.class);

        if (recorrerDesc){
            soldados.sort(Infanteria.ubicacionDesComparator);
        } else {
            soldados.sort(Infanteria.ubicacionAscComparator);
        }
        for (Infanteria soldado : soldados) {
            try {
                soldado.mover(tablero, direccion);
            } catch (Exception ignore) { }
        }
        /* ACA SE DISUELVE EL GRUPO DE SOLDADOS ? */
    }
}