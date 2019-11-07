package fiuba.algo3.TP2.model;

import fiuba.algo3.TP2.model.Ubicacion;

public abstract class UnidadViva extends Unidad {

    public void moverUnidad(Ubicacion nuevaUbicacion){
        this.ubicacion = nuevaUbicacion;
    }

    public void curarUnidad(int unValorDeCuracion){
        this.vida += unValorDeCuracion;
        if (vida > VIDA_INICIAL){
            this.vida = VIDA_INICIAL;
        }
    }
}