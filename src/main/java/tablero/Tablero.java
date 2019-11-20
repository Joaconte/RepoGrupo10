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

    public Casilla getCasilla(Ubicacion ubicacion){
        return columnas.get(ubicacion.getPosicionEnX()-1).getCasilla(ubicacion.getPosicionEnY());
    }

    public ArrayList<Casilla> getCasillasEnAdyacenciaCercana(Ubicacion  ubicacionOcupada){
        Casilla unaCasilla= getCasilla(ubicacionOcupada);
        BuscadorCasillasAdyacentes iterador= new BuscadorCasillasAdyacentes();
        ArrayList<Casilla> casillas = iterador.buscarCasillasOcupadasEnDistanciaCorta(ubicacionOcupada, columnas, unaCasilla);
        return casillas;
    }

    public ArrayList<Casilla> getCasillasEnAdyacencia(Ubicacion ubicacionOcupada){
        Casilla unaCasilla= getCasilla(ubicacionOcupada);
        BuscadorCasillasAdyacentes iterador= new BuscadorCasillasAdyacentes();
        return iterador.buscarCasillasOcupadasAdyacentes(ubicacionOcupada,columnas,unaCasilla);
    }

}

