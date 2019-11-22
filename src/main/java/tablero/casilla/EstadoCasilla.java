package tablero.casilla;

import pieza.Pieza;

public interface EstadoCasilla {

    public boolean estaOcupada();
    public EstadoCasilla ocuparCasilla(Pieza pieza);
    public EstadoCasilla desocuparCasilla();
    public Pieza getContenido();
    public void setFueRevisada(boolean fueRevisada);
    public boolean getFueRevisada();
}
