package modelo.tablero;

import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;
import modelo.tablero.casilla.Casilla;
import modelo.tablero.casilla.NoHayUnidadEnPosicionException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tablero {
    private static final int FILAS = 20;
    private static final int COLUMNAS = 20;
    private List<Columna> columnas = new ArrayList<>();


    public Tablero(){
        for (int numeroDeColumna=0; numeroDeColumna<(COLUMNAS); numeroDeColumna++)
            columnas.add(new Columna(numeroDeColumna, FILAS));
    }

    public Pieza getUnidad(int x, int y) throws NoHayUnidadEnPosicionException { return columnas.get(x).getCasilla(y).getContenido();}

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

    public int getFilas(){ return FILAS;}
    public int getColumnas(){ return COLUMNAS;}


    public int getCantidadColumnasCreadas(){
        return columnas.size();
    }

    // solo se usa en las pruebas
    public boolean casillaEstaOcupada(int numeroDeLaColumna, int numeroDeLaFila){
        Columna unaColumna = columnas.get(numeroDeLaColumna);
        return unaColumna.casillaDeLaFilaEstaOcupada(numeroDeLaFila);
    }


    private ArrayList<Casilla> getCasillasEntreRangos(Ubicacion ubicacion, int radioInicial, int radioFinal){

        ArrayList<Casilla> listadoDeCasillas = new ArrayList<>();

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

    public List<Casilla> getCasillasVaciasAdyacentes(Ubicacion ubicacion) {
        return this.getCasillasEntreRangos(ubicacion, 1, 1).stream()
                .filter(c-> !c.estaOcupada())
                .collect(Collectors.toList());
    }



    public List<Pieza> getPiezasAdyacentes(Ubicacion ubicacion) throws NoHayUnidadEnPosicionException {
        return getPiezasEnRadio(ubicacion, 1, 1);
    }

    public List<Pieza> getPiezasAdyacentesDentroDeRadio(Ubicacion ubicacion, int radio) throws NoHayUnidadEnPosicionException {
        return getPiezasEnRadio(ubicacion, 1, radio);
    }

    private List<Pieza> getPiezasEnRadio(Ubicacion ubicacion, int rangoInicial, int rangoFinal) throws NoHayUnidadEnPosicionException {
        List<Pieza> list = new ArrayList<>();
        for (Casilla casilla : this.getCasillasEntreRangos(ubicacion, rangoInicial, rangoFinal)) {
            if (casilla.estaOcupada()) {
                Pieza contenido = casilla.getContenido();
                list.add(contenido);
            }
        }
        return list;
    }

    public List<Pieza> getPiezasAdycentesInfinitas(Ubicacion ubicacion) throws NoHayUnidadEnPosicionException{
        ArrayList<Pieza> listaPiezas= new ArrayList<>();
        return getPiezasAdycentesRecursivo(ubicacion, listaPiezas);
    }

    public List<Pieza> getPiezasAdycentesRecursivo( Ubicacion ubicacion, ArrayList<Pieza> piezas ) throws NoHayUnidadEnPosicionException {
        List<Pieza> nuevasPiezas = getPiezasAdyacentes(ubicacion);
        for (Pieza pieza : nuevasPiezas) {
            if (!piezas.contains(pieza)) {
                piezas.add(pieza);
                getPiezasAdycentesRecursivo(pieza.getUbicacion(), piezas);
            }
        }
        return piezas;
    }

}


