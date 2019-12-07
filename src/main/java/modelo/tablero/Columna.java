package modelo.tablero;

import modelo.pieza.Pieza;
import modelo.tablero.casilla.Casilla;

import java.util.ArrayList;
import java.util.List;

public class Columna {
    private List<Casilla> columna = new ArrayList<Casilla>();

    public Columna( int numeroCasillasPorColumna){
        for (int numeroDeCasilla=0; numeroDeCasilla<(numeroCasillasPorColumna); numeroDeCasilla++)
            columna.add(new Casilla());
    }

    public void ocuparCasilla(Pieza pieza, int posicionEnLaColumna) {
        Casilla unaCasilla = columna.get(posicionEnLaColumna);
        unaCasilla.ocuparCasilla(pieza);
    }

    public void desocuparCasilla(int posicionEnLaColumna) {
        Casilla unaCasilla = columna.get(posicionEnLaColumna);
        unaCasilla.desocuparCasilla();
    }

    public int getTamanio() {
        return columna.size();
    }

    public boolean casillaDeLaFilaEstaOcupada(int numeroDeLaFila) {
        Casilla unaCasilla = columna.get(numeroDeLaFila);
        return unaCasilla.estaOcupada();
    }

    public Casilla getCasilla(int numeroDeLaFila){
        return columna.get(numeroDeLaFila);
    }


}

