package pieza.tipos;

import pieza.movimiento.IModoMovimiento;
import pieza.movimiento.SeMueveEnTodasDirecciones;
import pieza.sanacion.CurandoAEnemigoException;
import pieza.Pieza;
import pieza.sanacion.IModoSanacion;
import pieza.sanacion.SinSanacion;
import pieza.sanacion.UnidadNoSePuedeCurar;

public class Curandero extends Pieza {
    static final int COSTO = 2;
    static final int VIDA_MAXIMA = 75;
    static final int PUNTOS_DE_CURACION = 15;
    static final IModoMovimiento MOVIMIENTO = new SeMueveEnTodasDirecciones();
    static final IModoSanacion MODO_CURACION = new SinSanacion();


    public Curandero(int equipo){
        super(COSTO, VIDA_MAXIMA, VIDA_MAXIMA, equipo, MOVIMIENTO, MODO_CURACION);
    }

    public void curarAAliado(Pieza unaUndidadCurable) throws CurandoAEnemigoException, UnidadNoSePuedeCurar {
        if ( this.equipo != unaUndidadCurable.getEquipo()) {
            throw new CurandoAEnemigoException();
        }
        unaUndidadCurable.sanar(PUNTOS_DE_CURACION);
        }

}
