package modelo.pieza.tipos;

import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;
import modelo.jugador.Sector;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.*;
import modelo.pieza.movimiento.Direccion;
import modelo.pieza.movimiento.IModoMovimiento;
import modelo.pieza.movimiento.NoSePuedeMoverException;
import modelo.pieza.movimiento.SinMovimientos;

import modelo.pieza.sanacion.IModoSanacion;
import modelo.pieza.sanacion.SinSanacion;
import modelo.tablero.Tablero;

public class Catapulta extends PiezaAtacante {
    static final int COSTO = 5;
    static final int VIDA_MAXIMA = 50;
    static final int DANIO_DISTANCIA = 20;
    static final int DANIO_CUERPO = 0;
    static final int DANIO_MEDIO = 0;
    static final IModoMovimiento MOVIMIENTO = new SinMovimientos();
    static final IModoAtaqueMasivo ATAQUE = new AtaqueADistanciaMasivo();
    static final IModoSanacion MODO_CURACION = new SinSanacion();


    public Catapulta(int equipo, int posX, int posY){
        super(COSTO,VIDA_MAXIMA,equipo, MOVIMIENTO, MODO_CURACION, ATAQUE,DANIO_CUERPO, DANIO_MEDIO, DANIO_DISTANCIA, posX, posY);
    }

    @Override
    public void atacar(Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {
        if(!this.esEnemigo(atacada)){ throw new PiezaAliadaNoAtacableException();}
        ATAQUE.atacarEnMasa(this, tablero.getPiezasAdycentesInfinitas(atacada.getUbicacion()));
    }


    @Override
    public void evaluarZonaDeDanio(Sector sector){}

    @Override
    public boolean esRefuerzoDeJinete() {
        return false;
    }

    @Override
    public void setUbicacion(Ubicacion ubicacion){}

    @Override
    public void mover(Tablero tablero, Direccion direccion) throws NoSePuedeMoverException {
        throw new NoSePuedeMoverException();

    }
}
