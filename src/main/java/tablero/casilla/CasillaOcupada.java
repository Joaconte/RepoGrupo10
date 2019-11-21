package tablero.casilla;

import pieza.Pieza;

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
    public Pieza getContenido(){
        return pieza;
    }

    @Override
    public void setFueRevisada(boolean fueRevisada) {
        fueVisitada=fueRevisada;
    }

    @Override
    public boolean getFueRevisada() {
        return fueVisitada;
    }
}

