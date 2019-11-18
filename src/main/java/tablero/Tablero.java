package tablero;

import pieza.Pieza;
import pieza.Ubicacion;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private static final int FILAS = 20;
    private static final int COLUMNAS = 20;
    private List<Columna> columnas = new ArrayList<Columna>();



    public Tablero(){
        for (int numeroDeColumna=1; numeroDeColumna<(COLUMNAS+1); numeroDeColumna++)
            columnas.add(new Columna(numeroDeColumna, FILAS));
    }

    public void ocuparCasilla(Pieza pieza, int numeroDeColumna, int numeroDeFila){
        Columna unaColumna = columnas.get(numeroDeColumna-1);
        unaColumna.ocuparCasilla(pieza, numeroDeFila);
    }

    public void desocuparCasilla(int numeroDeColumna, int numeroDeFila){
        Columna unaColumna = columnas.get(numeroDeColumna-1);
        unaColumna.desocuparCasilla(numeroDeFila);
    }

    public int getTamanio(){
        return FILAS * COLUMNAS; }

    public int getCantidadColumnasCreadas(){
        return columnas.size(); }

    public String getEstadoCasilla(int numeroDeLaColumna, int numeroDeLaFila){
        Columna unaColumna = columnas.get(numeroDeLaColumna-1);
        return unaColumna.getEstadoCasillaDeLaFila(numeroDeLaFila);
    }

    public boolean soldadosEnAdyacencia(int numeroDeLaColumna, int numeroDeLaFila){
        //implementar
        return true;
    }

    public Casilla getCasilla(Ubicacion ubicacion){
        int numeroColumna = ubicacion.getPosicionEnX();
        int numeroFila = ubicacion.getPosicionEnY();
        Columna unaColumna = columnas.get(numeroColumna-1);
        return unaColumna.getCasilla(numeroFila);
    }

    public ArrayList<Casilla> getCasillasEnAdyacencia(Ubicacion ubicacionOcupada){
        Casilla unaCasilla= getCasilla(ubicacionOcupada);
        IteradorCasillasOcupadasAdyacentes iterador= new IteradorCasillasOcupadasAdyacentes();
        return iterador.buscarCasillasOcupadasAdyacentes(ubicacionOcupada,columnas,unaCasilla);
    }

}

