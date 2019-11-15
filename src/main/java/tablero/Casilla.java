package tablero;

import pieza.Pieza;

import java.util.List;

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

    public List<Pieza> getContenido(List<Pieza> lista) { return estadoCasilla.getContenido(lista); }

}

