package modelo.tablero.casilla;

import modelo.pieza.Pieza;

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

    public void removerTropasMuertas() {
        estadoCasilla = estadoCasilla.sinTropasMuertas();
    }
}

