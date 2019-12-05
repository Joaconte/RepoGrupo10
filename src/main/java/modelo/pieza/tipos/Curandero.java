package modelo.pieza.tipos;

import modelo.pieza.Pieza;
import modelo.pieza.sanacion.*;

public class Curandero extends Pieza {
    static final int COSTO = 2;
    static final int VIDA_MAXIMA = 75;
    static final int PUNTOS_DE_CURACION = 15;
    static final IModoSanacion MODO_CURACION = new SanacionNormal();


    public Curandero(int equipo, int posX, int posY){
        super(COSTO, VIDA_MAXIMA, equipo, MODO_CURACION, posX, posY);
    }
    public Curandero(){
        super(COSTO, VIDA_MAXIMA, 0,  MODO_CURACION, 0, 0);
    }

    public void curarAAliado(Pieza unaUndidadCurable) throws CurandoAEnemigoException, UnidadNoSePuedeCurar, CurandoCuraADistanciaCortaException {
        if ( super.getEquipo() != unaUndidadCurable.getEquipo()) { throw new CurandoAEnemigoException(); }
        int distanciaAAliado= this.getDistanciaAOtraPieza(unaUndidadCurable);
        if ( distanciaAAliado>2 || distanciaAAliado < 0 ) { throw new CurandoCuraADistanciaCortaException(); }
        unaUndidadCurable.sanar(PUNTOS_DE_CURACION);
        }

    @Override
    public boolean esRefuerzoDeJinete() {
        return false;
    }
}
