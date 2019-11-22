package pieza.tipos;

import pieza.Ubicacion;

import java.util.ArrayList;

public class Batallon {

    private ArrayList<Infanteria> soldados = new ArrayList<Infanteria>();

    public void Batallon(Infanteria primerSoldado, Infanteria segundoSoldado, Infanteria tercerSoldado){

        soldados.add(primerSoldado);
        soldados.add(segundoSoldado);
        soldados.add(tercerSoldado);
    }

    /*
    public void moverBatallon(Ubicacion ubicacionActual, Ubicacion miNuevaUbicacion){

        soldados.get(0).moverUnidad(ubicacionActual, miNuevaUbicacion);
        soldados.get(1).moverUnidad(ubicacionActual, miNuevaUbicacion);
        soldados.get(2).moverUnidad(ubicacionActual, miNuevaUbicacion);
    }
    */
}