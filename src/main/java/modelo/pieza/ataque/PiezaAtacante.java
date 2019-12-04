package modelo.pieza.ataque;

import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.movimiento.IModoMovimiento;
import modelo.pieza.sanacion.IModoSanacion;
import modelo.tablero.Tablero;

public abstract class PiezaAtacante extends Pieza {
    private int danioCuerpoCuerpo;
    private int danioDistanciaLejana;
    private int danioMedio;

    private IModoAtaque modoAtaque;
    public PiezaAtacante(int costo, int vidaMaxima, int equipo, IModoMovimiento movimiento, IModoSanacion modoSanacion, IModoAtaque modoAtaque, int danioCuerpo, int danioMedio, int danioDistanciaLejana, int posX, int posY) {
        super(costo, vidaMaxima, equipo, movimiento, modoSanacion,posX,posY);
        this.modoAtaque= modoAtaque;
        this.danioCuerpoCuerpo = danioCuerpo;
        this.danioDistanciaLejana = danioDistanciaLejana;
        this.danioMedio = danioMedio;
    }

    public int getDanioCuerpoCuerpo(){
        return danioCuerpoCuerpo;
    }

    public int getDanioDistanciaLejana(){
        return danioDistanciaLejana;
    }

    public int getDanioMedio(){
        return danioMedio;
    }

    public void atacar(Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException{
        if(!this.esEnemigo(atacada)){ throw new PiezaAliadaNoAtacableException();}
        modoAtaque.atacar(this, atacada);
    }
}
