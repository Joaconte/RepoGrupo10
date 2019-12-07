package modelo.tablero.casilla;

import modelo.pieza.Pieza;

public class CasillaOcupada implements EstadoCasilla{

    private Pieza pieza;

    public CasillaOcupada(Pieza pieza){
        this.pieza= pieza;
    }

    @Override
    public boolean estaOcupada() {
        return true;
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
    public EstadoCasilla sinTropasMuertas() {
        if (!pieza.estaViva()) return new CasillaLibre();
        return this;
    }


}

