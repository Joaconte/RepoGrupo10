package tablero;

import pieza.Pieza;

public  class  Casilla {
    private Pieza unidad;
    public Casilla(){
        unidad = null;
    }
    public Pieza getUnidad()throws CasillaNoTieneUnidadException{
        if (estaVacia()) {
            throw new CasillaNoTieneUnidadException();
        }
        return unidad;
    }

    public void setUnidad(Pieza unidad)throws CasillaTieneUnidadException {
        if(!estaVacia()) {
            throw new CasillaTieneUnidadException();
        }
        this.unidad = unidad;}

    public boolean estaVacia(){
        if (unidad == null)
            {return true;
            }
        return false;

    }


}

