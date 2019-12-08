package modelo.pieza.tipos;

import modelo.pieza.Pieza;
import modelo.pieza.ataque.RangoEfecto;
import modelo.pieza.sanacion.CurandoAEnemigoException;
import modelo.pieza.sanacion.IModoSanacion;
import modelo.pieza.sanacion.SanacionNormal;
import modelo.pieza.sanacion.UnidadNoSePuedeCurar;

public class Curandero extends Pieza {
    static final int COSTO = 2;
    static final int VIDA_MAXIMA = 75;
    static final int PUNTOS_DE_CURACION = 15;
    static final IModoSanacion MODO_CURACION = new SanacionNormal();
    private RangoEfecto rangoEfecto;

    public Curandero(int equipo, int posX, int posY){
        super(COSTO, VIDA_MAXIMA, equipo, MODO_CURACION, posX, posY);
        rangoEfecto = new RangoEfecto();
    }
    public Curandero(){
        super(COSTO, VIDA_MAXIMA, 0,  MODO_CURACION, 0, 0);
    }

    public void curarAAliado(Pieza unaUndidadCurable) throws CurandoAEnemigoException, UnidadNoSePuedeCurar, CurandoCuraADistanciaCortaException {
        if ( super.getEquipo() != unaUndidadCurable.getEquipo()) { throw new CurandoAEnemigoException(); }
        if ( !rangoEfecto.esRangoCuerpoCuerpo(getDistanciaAOtraPieza(unaUndidadCurable)) ) { throw new CurandoCuraADistanciaCortaException(); }
        unaUndidadCurable.sanar(PUNTOS_DE_CURACION);
        }

    @Override
    public boolean esRefuerzoDeJinete() {
        return false;
    }

    @Override
    public boolean sePuederMoverA(int posFinalX, int posFinalY) {
        return CAPACIDAD_DESPLAZAMIENTO == ubicacion.getDistanciaAOtroPunto(posFinalX,posFinalY);
    }

    @Override
    public boolean puedeTenerBatallon() {
        return false;
    }

}
