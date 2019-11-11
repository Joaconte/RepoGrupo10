package tablero;

import pieza.Pieza;
import pieza.Ubicacion;

public class Tablero {
    private static final int FILAS = 20;
    private static final int COLUMNAS = 20;
    private Casilla[][] casillas;


    public Tablero(){
        this.casillas =  new Casilla[FILAS][COLUMNAS];
    }
    public void crearTableroVacio(){
        for (int x=0; x<FILAS; x++) {
            for(int y=0; y<COLUMNAS; y++) {
                casillas[x][y] = new Casilla();
            }
        }
    }


    public void agregarUnidad(Pieza unidad, Ubicacion ubicacion) throws CasillaTieneUnidadException{
        int x = ubicacion.getPosicionX();
        int y = ubicacion.getPosicionY();
        Casilla casilla = casillas[x][y];
        casilla.setUnidad(unidad);

    }


    public boolean tieneAlgunaCasillaOcupada(){
        for (int x=0; x<FILAS; x++) {
            for(int y=0; y<COLUMNAS; y++) {
                if (!(casillas[x][y]).estaVacia()){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean estaVacio(){return (!tieneAlgunaCasillaOcupada()); }

    public int getTamanio(){return((casillas.length) * (casillas[0].length)); }

    public Casilla buscarCasilla(int x, int y){
        return casillas[x][y];
    }
}

