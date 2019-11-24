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


    public Curandero(int equipo, int posX, int posY){
        super(COSTO, VIDA_MAXIMA, equipo, MOVIMIENTO, MODO_CURACION, posX, posY);
    }

    public void curarAAliado(Pieza unaUndidadCurable) throws CurandoAEnemigoException, UnidadNoSePuedeCurar, CurandoCuraADistanciaCortaException {
        if ( super.getEquipo() != unaUndidadCurable.getEquipo()) { throw new CurandoAEnemigoException(); }
        int distanciaAAliado= this.ubicacion.getDistanciaAOtroPunto(unaUndidadCurable.getUbicacion());
        if ( distanciaAAliado>2 || distanciaAAliado < 0 ) { throw new CurandoCuraADistanciaCortaException(); }

        unaUndidadCurable.sanar(PUNTOS_DE_CURACION);

        }

    @Override
    public String getNombre() {
        return "Curandero";
    }
}
