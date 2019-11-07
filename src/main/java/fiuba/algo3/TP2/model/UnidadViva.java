package fiuba.algo3.TP2.model;

import fiuba.algo3.TP2.model.Ubicacion;

public abstract class UnidadViva extends Unidad {

    public void moverUnidad(Ubicacion miNuevaUbicacion){
        this.ubicacion = new Ubicacion(miNuevaUbicacion.darPosicionEnX(),miNuevaUbicacion.darPosicionEnY());
    }

    public void curarUnidad(int unValorDeCuracion){
        this.vida += unValorDeCuracion;
        if (vida > VIDA_INICIAL){
            this.vida = VIDA_INICIAL;
        }
    }
}