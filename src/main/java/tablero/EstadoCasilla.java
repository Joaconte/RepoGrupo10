package tablero;

import pieza.Pieza;

import java.util.ArrayList;

public interface EstadoCasilla {

    public String getEstado();
    public EstadoCasilla ocuparCasilla(Pieza pieza);
    public EstadoCasilla desocuparCasilla();
    public Pieza getContenido();
    public void setFueRevisada(boolean fueRevisada);
    public boolean getFueRevisada();
}
