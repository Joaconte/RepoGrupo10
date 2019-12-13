package modelo.tablero;

import modelo.jugador.UbicacionInvalidaException;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.NoSePuedeMoverException;
import modelo.tablero.casilla.Casilla;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tablero {
    private static final int FILAS = 20;
    private static final int COLUMNAS = 20;
    private List<Columna> columnas = new ArrayList<>();


    public Tablero(){
        for (int numeroDeColumna=0; numeroDeColumna<(COLUMNAS); numeroDeColumna++)
            columnas.add(new Columna(FILAS));
    }

    public void removerTropasMuertas(){
        columnas.forEach(Columna::removerTropasMuertas);
    }

    public void moverUnidad(Pieza pieza, int posFinalX, int posFinalY) throws DesplazamientoInvalidoException, UbicacionInvalidaException, NoSePuedeMoverException {
        if (!existePosicion(posFinalX,posFinalY) || !pieza.sePuederMoverA(posFinalX,posFinalY)){throw new DesplazamientoInvalidoException();}
        if (casillaEstaOcupada(posFinalX,posFinalY)){throw new UbicacionInvalidaException(); }
        movimiento (pieza,posFinalX,posFinalY);
        pieza.mover(posFinalX,posFinalY);
    }

    public void moverBatallon(ArrayList<Integer> ubicacionX, ArrayList<Integer> ubicacionY,ArrayList<Pieza> pieza) throws NoSePuedeMoverException, UbicacionInvalidaException {
        if (casillaEstaOcupada(ubicacionX.get(0),ubicacionY.get(0))){throw new UbicacionInvalidaException(); }
        for (int i=0; i<pieza.size() ; i++){
            if (existePosicion(ubicacionX.get(i),ubicacionY.get(i) )&& !casillaEstaOcupada(ubicacionX.get(i),ubicacionY.get(i))){
                movimiento(pieza.get(i),ubicacionX.get(i),ubicacionY.get(i));
                pieza.get(i).mover(ubicacionX.get(i),ubicacionY.get(i));
            }
        }
    }

    private void movimiento (Pieza pieza, int posFinalX, int posFinalY){
        ocuparCasilla(pieza, posFinalX, posFinalY);
        desocuparCasilla(pieza.getPosicionEnColumnaQueOcupa(), pieza.getPosicionEnFilaQueOcupa());
    }

    public void ocuparCasilla(Pieza pieza, int numeroDeColumna, int numeroDeFila){
        Columna unaColumna = columnas.get(numeroDeColumna);
        unaColumna.ocuparCasilla(pieza, numeroDeFila);
    }

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

    public boolean casillaEstaOcupada(int numeroDeLaColumna, int numeroDeLaFila){
        Columna unaColumna = columnas.get(numeroDeLaColumna);
        return unaColumna.casillaDeLaFilaEstaOcupada(numeroDeLaFila);
    }

    public boolean existePosicion(int fila, int columna){
        return (fila<FILAS && 0<=fila) && (columna<COLUMNAS && columna>=0);
    }

    private ArrayList<Casilla> getCasillasEntreRangos(int posicionColumna, int posicionEnFila, int radioInicial, int radioFinal){

        ArrayList<Casilla> listadoDeCasillas = new ArrayList<>();

        //Problemas de borde
        int inicioRadio1X = Math.max( 0, posicionColumna - radioInicial );
        int finRadio1X = Math.min( 19, posicionColumna + radioInicial );
        int inicioRadio2X = Math.max( 0, posicionColumna - radioFinal );
        int finRadio2X = Math.min( 19, posicionColumna + radioFinal );

        int inicioRadio1Y = Math.max( 0, posicionEnFila - radioInicial );
        int finRadio1Y = Math.min( 19, posicionEnFila + radioInicial );
        int inicioRadio2Y = Math.max( 0, posicionEnFila - radioFinal );
        int finRadio2Y = Math.min( 19, posicionEnFila + radioFinal );

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

    public List<Pieza> getPiezasAdyacentes(int posicionColumna, int posicionFila){
        return getPiezasEnRadio(posicionColumna,posicionFila, 1, 1);
    }

    public List<Pieza> getPiezasAdyacentesDentroDeRadio(int posicionColumna, int posicionFila, int radio){
        return getPiezasEnRadio(posicionColumna,posicionFila, 1, radio);
    }

    private List<Pieza> getPiezasEnRadio(int posicionColumna, int posicionFila, int rangoInicial, int rangoFinal) {
        return this.getCasillasEntreRangos(posicionColumna,posicionFila, rangoInicial, rangoFinal).stream()
                .filter(Casilla::estaOcupada)
                .map(Casilla::getContenido)
                .collect(Collectors.toList());
    }

    public List<Pieza> getPiezasAdycentesInfinitas(int posicionColumna, int posicionFila){
        ArrayList<Pieza> listaPiezas= new ArrayList<>();
        return getPiezasAdycentesRecursivo(posicionColumna,posicionFila, listaPiezas);
    }

    public List<Pieza> getPiezasAdycentesRecursivo( int posicionColumna,int posicionFila, ArrayList<Pieza> piezas ){
        List<Pieza> nuevasPiezas = getPiezasAdyacentes(posicionColumna,posicionFila);
        nuevasPiezas.stream().filter(pieza -> !piezas.contains(pieza))
                    .forEach(pieza->{ piezas.add(pieza);
                                      getPiezasAdycentesRecursivo(pieza.getPosicionEnColumnaQueOcupa(),pieza.getPosicionEnFilaQueOcupa(),piezas);
                             });
        return piezas;
    }



}


