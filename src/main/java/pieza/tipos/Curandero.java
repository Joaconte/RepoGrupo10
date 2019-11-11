package pieza.tipos;

import pieza.sanacion.CurandoAEnemigoException;
import pieza.Pieza;
import pieza.sanacion.UnidadNoSePuedeCurar;

public class Curandero extends Pieza {
    static final int COSTO = 2;
    static final int VIDA_MAXIMA = 75;
    static final int PUNTOS_DE_CURACION = 15;

    public Curandero(){
        super.setVida_Maxima(VIDA_MAXIMA);
        super.setVida(VIDA_MAXIMA);
        super.setCosto(COSTO);
        super.enZonaAliada();
        super.puedeCurarse();

    }

    public void curarAAliado(Pieza unaUndidadCurable) throws CurandoAEnemigoException, UnidadNoSePuedeCurar {
        if ( this.equipo != unaUndidadCurable.getEquipo()) {
            throw new CurandoAEnemigoException();
        }
        unaUndidadCurable.sanar(PUNTOS_DE_CURACION);
        }

}
