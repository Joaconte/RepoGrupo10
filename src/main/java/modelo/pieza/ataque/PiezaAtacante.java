package modelo.pieza.ataque;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.sanacion.IModoSanacion;
import modelo.tablero.Tablero;

public abstract class PiezaAtacante extends Pieza {

    private IModoAtaque modoAtaque;

    public PiezaAtacante(int costo, int vidaMaxima, int equipo, IModoSanacion modoSanacion, IModoAtaque modoAtaque, int posX, int posY) {
        super(costo, vidaMaxima, equipo, modoSanacion,posX,posY);
        this.modoAtaque= modoAtaque;

    }

    public void atacar(Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException{
        if(!this.esEnemigo(atacada)){ throw new PiezaAliadaNoAtacableException();}
        modoAtaque.atacar(this, atacada);
    }

    public abstract String getSonidoAtaque();

}
