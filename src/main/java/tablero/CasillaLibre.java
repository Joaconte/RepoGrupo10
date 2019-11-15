package tablero;

import pieza.Pieza;

import java.util.List;

public class CasillaLibre implements EstadoCasilla {

    boolean fueVisitada;

    @Override
    public String getEstado() {
        return "Libre";
    }

    @Override
    public EstadoCasilla ocuparCasilla(Pieza pieza) {
        return new CasillaOcupada(pieza);
    }

    @Override
    public EstadoCasilla desocuparCasilla() {
        return this;
    }

    @Override
    public List<Pieza> getContenido(List<Pieza> lista){
        return null;
    }


}
