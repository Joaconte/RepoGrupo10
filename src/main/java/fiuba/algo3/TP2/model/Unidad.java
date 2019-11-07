package fiuba.algo3.TP2.model;

import fiuba.algo3.TP2.exception.UnidadEstaMuertaException;

public abstract class Unidad {
    protected int costo;
    protected int vida;
    protected Ubicacion ubicacion;

    public int getCosto(){
        return costo;
    }

    public int getPuntosVida(){
        return vida;
    }

    public Ubicacion getUbicacion(){
        return ubicacion;
    }

    public void recibirDanio(int danio) {
        if (vida <= 0) {
            throw new UnidadEstaMuertaException();
        }
        vida -= danio;
    }
}

