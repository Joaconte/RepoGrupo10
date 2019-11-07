package fiuba.algo3.TP2.model;

import fiuba.algo3.TP2.exception.CurandoAEnemigoException;

public class Curandero extends UnidadViva {
    static final int COSTO = 2;
    static final int PUNTOS_DE_CURACION = 15;
    private int curacion;

    public Curandero(){
        VIDA_INICIAL = 75;
        costo = COSTO;
        vida = VIDA_INICIAL;
        curacion = PUNTOS_DE_CURACION;
    }

    public void curarAAliado(UnidadViva unaUndidadCurable) throws CurandoAEnemigoException{
        if ( this.equipo != unaUndidadCurable.getEquipo()) {
            throw new CurandoAEnemigoException();
        }
        unaUndidadCurable.curarUnidad(curacion);
        }

}
