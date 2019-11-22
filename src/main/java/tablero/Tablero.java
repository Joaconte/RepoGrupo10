package tablero;

import pieza.Pieza;
import pieza.Ubicacion;
import tablero.casilla.Casilla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tablero {
    private static final int FILAS = 20;
    private static final int COLUMNAS = 20;
    private List<Columna> columnas = new ArrayList<Columna>();


    public Tablero(){
        for (int numeroDeColumna=0; numeroDeColumna<(COLUMNAS); numeroDeColumna++)
            columnas.add(new Columna(numeroDeColumna, FILAS));
    }

    public void ocuparCasilla(Pieza pieza, int numeroDeColumna, int numeroDeFila){
        Columna unaColumna = columnas.get(numeroDeColumna);
        unaColumna.ocuparCasilla(pieza, numeroDeFila);
    }

    // se usa solo en pruebas
    public void desocuparCasilla(int numeroDeColumna, int numeroDeFila){
        Columna unaColumna = columnas.get(numeroDeColumna);
        unaColumna.desocuparCasilla(numeroDeFila);
    }

    public int getTamanio(){
        return FILAS * COLUMNAS;
    }

    public int getCantidadColumnasCreadas(){
        return columnas.size();
    }

    // solo se usa en las pruebas
    public boolean casillaEstaOcupada(int numeroDeLaColumna, int numeroDeLaFila){
        Columna unaColumna = columnas.get(numeroDeLaColumna);
        return unaColumna.casillaDeLaFilaEstaOcupada(numeroDeLaFila);
    }


    /* POR SI LAS DUDAS
    private ArrayList<Casilla> getCasillasPorRango(Ubicacion ubicacion, int rango){

        ArrayList<Casilla> listadoDeCasillas = new ArrayList<Casilla>();

        int posicionEnX = ubicacion.getPosicionEnX();
        int posicionEnY = ubicacion.getPosicionEnY();

        //Problemas de borde
        int inicioX = Math.max( 0, posicionEnX - rango );
        int finX = Math.min( 19, posicionEnX + rango );
        int inicioY = Math.max( 0, posicionEnY - rango );
        int finY = Math.min( 19, posicionEnY + rango );

        for (int i = inicioX; i <= finX ; i++){

            Columna columna = columnas.get(i);
            for (int j = inicioY; j <= finY ; j++){

                Casilla casilla = columna.getCasilla(j);
                listadoDeCasillas.add(casilla);
            }
        }
        return listadoDeCasillas;
    }
     */

    private ArrayList<Casilla> getCasillasEntreRangos(Ubicacion ubicacion, int radioInicial, int radioFinal){

        ArrayList<Casilla> listadoDeCasillas = new ArrayList<Casilla>();

        int posicionEnX = ubicacion.getPosicionEnX();
        int posicionEnY = ubicacion.getPosicionEnY();

        //Problemas de borde
        int inicioRadio1X = Math.max( 0, posicionEnX - radioInicial );
        int finRadio1X = Math.min( 19, posicionEnX + radioInicial );
        int inicioRadio2X = Math.max( 0, posicionEnX - radioFinal );
        int finRadio2X = Math.min( 19, posicionEnX + radioFinal );

        int inicioRadio1Y = Math.max( 0, posicionEnY - radioInicial );
        int finRadio1Y = Math.min( 19, posicionEnY + radioInicial );
        int inicioRadio2Y = Math.max( 0, posicionEnY - radioFinal );
        int finRadio2Y = Math.min( 19, posicionEnY + radioFinal );

        for (int i = inicioRadio2X; i <= inicioRadio1X ; i++){

            Columna columna = columnas.get(i);
            for (int j = inicioRadio2Y; j <= finRadio2Y ; j++){

                Casilla casilla = columna.getCasilla(j);
                listadoDeCasillas.add(casilla);
            }
        }

        for (int i = finRadio1X; i <= finRadio2X ; i++){

            Columna columna = columnas.get(i);
            for (int j = inicioRadio2Y; j <= finRadio2Y ; j++){

                Casilla casilla = columna.getCasilla(j);
                listadoDeCasillas.add(casilla);
            }
        }

        for (int i = inicioRadio1X + 1; i < finRadio1X ; i++){

            Columna columna = columnas.get(i);
            for (int j = inicioRadio2Y; j <= inicioRadio1Y ; j++){

                Casilla casilla = columna.getCasilla(j);
                listadoDeCasillas.add(casilla);
            }

            for (int j = finRadio1Y; j <= finRadio2Y ; j++){

                Casilla casilla = columna.getCasilla(j);
                listadoDeCasillas.add(casilla);
            }
        }

        return listadoDeCasillas;
    }

    public Object[] getPiezasAdyacentes(Ubicacion ubicacion){

        return getPiezasEntreRangos(ubicacion, 1, 1);
    }

    public Object[] getPiezasEntreRangos(Ubicacion ubicacion, int rangoInicial, int rangoFinal) {

        Object[] piezas = this.getCasillasEntreRangos(ubicacion, rangoInicial, rangoFinal).stream()
             .filter(c -> c.estaOcupada() == true)
                .map(c -> c.getContenido())
                .toArray();
        return piezas;
    }

    public Object[] getCasillasVaciasAdyacentes(Ubicacion ubicacion) {

        Object[] casillas = this.getCasillasEntreRangos(ubicacion, 1, 1).stream()
                .filter(c -> c.estaOcupada() == false).toArray();
        return casillas;
    }



}


