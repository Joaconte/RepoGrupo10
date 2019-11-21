package tablero;

import pieza.Pieza;
import tablero.casilla.Casilla;

import java.util.ArrayList;
import java.util.List;

public class Columna {
    private int numeroCasillasPorColumna;
    private int numeroColumna;
    private List<Casilla> columna = new ArrayList<Casilla>();

    public Columna(int numeroColumna, int numeroCasillasPorColumna){
        this.numeroColumna = numeroColumna;
        this.numeroCasillasPorColumna = numeroCasillasPorColumna;
        for (int numeroDeCasilla=1; numeroDeCasilla<(numeroCasillasPorColumna+1); numeroDeCasilla++)
            columna.add(new Casilla());
    }

    public void ocuparCasilla(Pieza pieza, int posicionEnLaColumna) {
        Casilla unaCasilla = columna.get(posicionEnLaColumna-1);
        unaCasilla.ocuparCasilla(pieza);
    }

    public void desocuparCasilla(int posicionEnLaColumna) {
        Casilla unaCasilla = columna.get(posicionEnLaColumna-1);
        unaCasilla.desocuparCasilla();
    }

    public int getTamanio() {
        return columna.size();
    }

    public String getEstadoCasillaDeLaFila(int numeroDeLaFila) {
        Casilla unaCasilla=columna.get(numeroDeLaFila-1);
        return unaCasilla.getEstado();
    }

    public Casilla getCasilla(int numeroDeLaFila){
        return columna.get(numeroDeLaFila-1);
    }

}

