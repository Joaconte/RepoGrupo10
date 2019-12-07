package modelo.tablero.casilla;

import modelo.pieza.Pieza;

public interface EstadoCasilla {

    boolean estaOcupada();
    EstadoCasilla ocuparCasilla(Pieza pieza);
    EstadoCasilla desocuparCasilla();
    Pieza getContenido();
}
