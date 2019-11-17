package tablero;

import pieza.Pieza;

import java.util.List;

public class CasillaOcupada implements EstadoCasilla{

    private Pieza pieza;
    boolean fueVisitada=false;

    public CasillaOcupada(Pieza pieza){
        this.pieza= pieza;
    }

    @Override
    public String getEstado() {
        return "Ocupada";
    }

    @Override
    public EstadoCasilla ocuparCasilla(Pieza pieza) {
        return this;
    }

    @Override
    public EstadoCasilla desocuparCasilla() {
        return new CasillaLibre();
    }

    @Override
    public List<Pieza> getContenido(List<Pieza> lista){
        this.fueVisitada=true;
        return null;
    }

    @Override
    public void resetFueRevisada() {
        fueVisitada=false;
    }

    @Override
    public boolean getFueRevisada() {
        return fueVisitada;
    }
}

