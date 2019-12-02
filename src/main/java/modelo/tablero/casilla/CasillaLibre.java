package modelo.tablero.casilla;

import modelo.pieza.Pieza;

public class CasillaLibre implements EstadoCasilla {

    @Override
    public boolean estaOcupada() {
        return false;
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
    public Pieza getContenido() throws NoHayUnidadEnPosicionException{
        throw new NoHayUnidadEnPosicionException();
    };


}
