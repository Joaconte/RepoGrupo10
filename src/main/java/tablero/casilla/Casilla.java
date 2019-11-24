package tablero.casilla;

import pieza.Pieza;

public  class  Casilla {


    private EstadoCasilla estadoCasilla = new CasillaLibre();

    public boolean estaOcupada() {
        return estadoCasilla.estaOcupada();
    }

    public void ocuparCasilla(Pieza pieza){
        this.estadoCasilla = estadoCasilla.ocuparCasilla(pieza);
    }

    public void desocuparCasilla(){
        this.estadoCasilla = estadoCasilla.desocuparCasilla();
    }

    public Pieza getContenido() { return estadoCasilla.getContenido(); }

}

