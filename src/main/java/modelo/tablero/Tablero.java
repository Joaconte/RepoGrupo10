package modelo.tablero;

import modelo.pieza.Pieza;
import modelo.pieza.movimiento.Ubicacion;
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
        columnas.forEach(columna->columna.removerTropasMuertas());
    }

    public void moverUnidad(Pieza pieza, int posFinalX, int posFinalY) throws DesplazamientoInvalidoException {
        if (!existePosicion(posFinalX,posFinalY)){throw new DesplazamientoInvalidoException();}
        if (!pieza.sePuederMoverA(posFinalX,posFinalY)){throw new DesplazamientoInvalidoException();}
        movimiento (pieza,posFinalX,posFinalY);
    }

    public void moverBatallon(ArrayList<Integer> ubicacionX, ArrayList<Integer> ubicacionY,ArrayList<Pieza> pieza) throws NoSePuedeMoverException {
        for (int i=0; i<pieza.size() ; i++){
            if (existePosicion(ubicacionX.get(i),ubicacionY.get(i) )&& !casillaEstaOcupada(ubicacionX.get(i),ubicacionY.get(i))){
                movimiento(pieza.get(i),ubicacionX.get(i),ubicacionY.get(i));
                pieza.get(i).mover(ubicacionX.get(i),ubicacionY.get(i));
            }
        }
    }

    private void movimiento (Pieza pieza, int posFinalX, int posFinalY){
        desocuparCasilla(pieza.getPosicionEnColumnaQueOcupa(), pieza.getPosicionEnFilaQueOcupa());
        ocuparCasilla(pieza, posFinalX, posFinalY);
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


    public List<Pieza> getPiezasAdyacentes(Ubicacion ubicacion){
        return getPiezasEnRadio(ubicacion, 1, 1);
    }

    public List<Pieza> getPiezasAdyacentesDentroDeRadio(Ubicacion ubicacion, int radio){
        return getPiezasEnRadio(ubicacion, 1, radio);
    }

    private List<Pieza> getPiezasEnRadio(Ubicacion ubicacion, int rangoInicial, int rangoFinal) {
        return this.getCasillasEntreRangos(ubicacion, rangoInicial, rangoFinal).stream()
                .filter(Casilla::estaOcupada)
                .map(Casilla::getContenido)
                .collect(Collectors.toList());
    }

    public List<Pieza> getPiezasAdycentesInfinitas(Ubicacion ubicacion){
        ArrayList<Pieza> listaPiezas= new ArrayList<>();
        return getPiezasAdycentesRecursivo(ubicacion, listaPiezas);
    }

    public List<Pieza> getPiezasAdycentesRecursivo( Ubicacion ubicacion, ArrayList<Pieza> piezas ){
        List<Pieza> nuevasPiezas = getPiezasAdyacentes(ubicacion);
        nuevasPiezas.stream().filter(pieza -> !piezas.contains(pieza))
                    .forEach(pieza->{ piezas.add(pieza);
                                      getPiezasAdycentesRecursivo(pieza.getUbicacion(),piezas);
                             });
        return piezas;
    }



}


