package pieza.tipos;

import pieza.movimiento.IModoMovimiento;
import pieza.movimiento.SeMueveEnTodasDirecciones;
import pieza.sanacion.*;
import pieza.Pieza;

public class Curandero extends Pieza {
    static final int COSTO = 2;
    static final int VIDA_MAXIMA = 75;
    static final int PUNTOS_DE_CURACION = 15;
    static final IModoMovimiento MOVIMIENTO = new SeMueveEnTodasDirecciones();
    static final IModoSanacion MODO_CURACION = new SanacionNormal();


    public Curandero(int equipo){
        super(COSTO, VIDA_MAXIMA, VIDA_MAXIMA, equipo, MOVIMIENTO, MODO_CURACION);
    }

    public void curarAAliado(Pieza unaUndidadCurable) throws CurandoAEnemigoException, UnidadNoSePuedeCurar {
        if ( super.getEquipo() != unaUndidadCurable.getEquipo()) {
            throw new CurandoAEnemigoException();
        }
        unaUndidadCurable.sanar(PUNTOS_DE_CURACION);
        }

    @Override
    public String getNombre() {
        return "Curandero";
    }
}
