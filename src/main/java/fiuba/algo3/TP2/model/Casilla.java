package fiuba.algo3.TP2.model;
import fiuba.algo3.TP2.exception.CasillaNoTieneUnidadException;
import fiuba.algo3.TP2.exception.CasillaTieneUnidadException;


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

