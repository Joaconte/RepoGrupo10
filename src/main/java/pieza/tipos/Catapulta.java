package pieza.tipos;

import pieza.Pieza;
import pieza.UnidadEstaMuertaException;
import pieza.ataque.*;
import pieza.movimiento.IModoMovimiento;
import pieza.movimiento.SinMovimientos;

import pieza.sanacion.IModoSanacion;
import pieza.sanacion.SinSanacion;
import tablero.Tablero;

public class Catapulta extends PiezaAtacante {
    static final int COSTO = 5;
    static final int VIDA_MAXIMA = 50;
    static final int DANIO_DISTANCIA = 20;
    static final int DANIO_CUERPO = 0;
    static final int DANIO_MEDIO = 0;
    static final IModoMovimiento MOVIMIENTO = new SinMovimientos();
    static final IModoAtaque ATAQUE = new AtaqueADistancia();
    static final IModoSanacion MODO_CURACION = new SinSanacion();


    public Catapulta(int equipo){
        super(COSTO, VIDA_MAXIMA, VIDA_MAXIMA, equipo, MOVIMIENTO, MODO_CURACION,  ATAQUE, DANIO_CUERPO, DANIO_MEDIO, DANIO_DISTANCIA);
    }

    @Override
    public void atacar(Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {
        if(!this.esEnemigo(atacada)){ throw new PiezaAliadaNoAtacableException();}
        ATAQUE.atacar(this, atacada ,this.ubicacion.getDistanciaAOtroPunto(atacada.getUbicacion()));
    }
}
