package modelo.pieza.tipos;

import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.movimiento.*;
import modelo.tablero.Tablero;

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
    public void mover(Tablero tablero, Direccion direccion) throws BatallonDisueltoException {
        if (!this.siguenContiguos()){
            throw new BatallonDisueltoException();
        }

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

    public ArrayList<Infanteria> getSoldados() {
        return soldados;
    }

    private boolean siguenContiguos(){
        ArrayList<Infanteria> soldados = this.getSoldados();
        if (soldados.size()==3) {
            int distanciaP1aP2 = soldados.get(0).getUbicacion().getDistanciaAOtroPunto(soldados.get(1).getUbicacion());
            int distanciaP1aP3 = soldados.get(0).getUbicacion().getDistanciaAOtroPunto(soldados.get(2).getUbicacion());
            int distanciaP2aP3 = soldados.get(1).getUbicacion().getDistanciaAOtroPunto(soldados.get(2).getUbicacion());
            int distanciaTotal = distanciaP1aP2 + distanciaP1aP3 + distanciaP2aP3;
            return (distanciaTotal <= 4);
        } else {
            return false;
        }
    }

    public boolean disolverBatallon(){
        if (this.siguenContiguos()){
            return false;
        } else {
            soldados.clear();
            return true;
        }
    }
}