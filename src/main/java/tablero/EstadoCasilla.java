package tablero;

import pieza.Pieza;

import java.util.List;

public interface EstadoCasilla {

    public String getEstado();
    public EstadoCasilla ocuparCasilla(Pieza pieza);
    public EstadoCasilla desocuparCasilla();
    public List<Pieza> getContenido(List<Pieza> lista);

}
