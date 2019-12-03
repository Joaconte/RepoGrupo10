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


    public void moverUnidad(Ubicacion ubicacionInicial, Ubicacion ubicacionFinal) throws NoHayUnidadEnPosicionException, DesplazamientoInvalidoException {

        List<Casilla> casillas = getCasillasVaciasAdyacentes(ubicacionInicial);
        for (int i = 0; i < casillas.size(); i++) {

            Casilla casilla = casillas.get(i);
            if (desplazamientoEsValido( ubicacionInicial, ubicacionFinal )) {

                Pieza pieza = getUnidad(ubicacionInicial.getPosicionEnX(), ubicacionInicial.getPosicionEnY());
                desocuparCasilla(ubicacionInicial.getPosicionEnX(), ubicacionInicial.getPosicionEnY());
                ocuparCasilla(pieza, ubicacionFinal.getPosicionEnX(), ubicacionFinal.getPosicionEnY());
            }
            else throw new DesplazamientoInvalidoException();
        }
    }

    private boolean desplazamientoEsValido(Ubicacion ubicacionInicial, Ubicacion ubicacionFinal) {

        int desplazamientoPos = Math.min (ubicacionInicial.getPosicionEnX() - ubicacionFinal.getPosicionEnX(),
                ubicacionInicial.getPosicionEnY() - ubicacionFinal.getPosicionEnY());

        int desplazamientoNeg = Math.max (ubicacionInicial.getPosicionEnX() - ubicacionFinal.getPosicionEnX(),
                ubicacionInicial.getPosicionEnY() - ubicacionFinal.getPosicionEnY());

        return (desplazamientoNeg > -2 && desplazamientoPos < 2);
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


