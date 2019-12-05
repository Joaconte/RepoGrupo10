package modelo.pieza.tipos;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.pieza.movimiento.*;
import modelo.tablero.Tablero;

import java.util.ArrayList;

public class Batallon {
    private AnalizadorDeBatallon analizadorDeBatallon = new AnalizadorDeBatallon();
    private Ordenamientos ordenar = new Ordenamientos();
    private ArrayList<Pieza> soldados ;

    public Batallon(ArrayList<Pieza> piezas) throws NoSirvenParaBatallonException {
        if (!analizadorDeBatallon.formanBatallon(piezas)) {
            throw new NoSirvenParaBatallonException() ;
        }
        soldados = piezas;

    }

    public String getNombre() {
        return "Batallon";
    }


    /* Acá quiero ignorar si una pieza no se pudo mover */

    public void mover(Tablero tablero, Direccion direccion) throws BatallonDisueltoException {
        if (!this.siguenContiguos()){
            throw new BatallonDisueltoException();
        }

        boolean recorrerDesc = (direccion.getClass() == Derecha.class)||(direccion.getClass() == Abajo.class)||
                (direccion.getClass() == AbajoDerecha.class)||(direccion.getClass() == AbajoIzquierda.class);

        if (recorrerDesc){
            soldados.sort(Ordenamientos.ubicacionDesComparator);
        } else {
            soldados.sort(Ordenamientos.ubicacionAscComparator);
        }
        for (Pieza soldado : soldados) {
            try {
                soldado.moverA(direccion,tablero);
            } catch (Exception ignore) { }
        }
        if (!this.siguenContiguos()){
            throw new BatallonDisueltoException();
        }
    }
        /* ACA SE DISUELVE EL GRUPO DE SOLDADOS ? */

    public ArrayList<Pieza> getSoldados() {
        return soldados;
    }

    private boolean siguenContiguos(){
        return analizadorDeBatallon.estanContiguos(soldados);
    }

    public void disolverBatallon(){
        soldados.clear();
    }

}