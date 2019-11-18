package tablero;

import pieza.Pieza;

import java.util.ArrayList;

public  class  Casilla {


    private EstadoCasilla estadoCasilla = new CasillaLibre();

    public String getEstado() {
        return estadoCasilla.getEstado();
    }

    public void ocuparCasilla(Pieza pieza){
        this.estadoCasilla = estadoCasilla.ocuparCasilla(pieza);
    }

    public void desocuparCasilla(){
        this.estadoCasilla = estadoCasilla.desocuparCasilla();
    }

    public Pieza getContenido() { return estadoCasilla.getContenido(); }

    public boolean getFueRevisada() { return estadoCasilla.getFueRevisada();}

    public void setFueRevisada(boolean fueRevisada) {estadoCasilla.setFueRevisada(fueRevisada);}
}

