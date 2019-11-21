package tablero.casilla;

import pieza.Pieza;

public class CasillaLibre implements EstadoCasilla {

    boolean fueVisitada=false;

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
    public Pieza getContenido(){
        return null;
    }

    @Override
    public void setFueRevisada(boolean fueRevisada) {
        this.fueVisitada=fueRevisada;
    }

    @Override
    public boolean getFueRevisada() {
        return fueVisitada;
    }

}
