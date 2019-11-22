package pieza.ataque;

import pieza.Pieza;
import pieza.UnidadEstaMuertaException;
import pieza.movimiento.IModoMovimiento;
import pieza.sanacion.IModoSanacion;
import tablero.Tablero;

public class PiezaAtacante extends Pieza {
    private int danioCuerpoCuerpo;
    private int danioDistancia;
    private int danioMedio;

    private IModoAtaque modoAtaque;

    public PiezaAtacante(int costo, int vidaMaxima, double vida, int equipo, IModoMovimiento movimiento, IModoSanacion modoSanacion,IModoAtaque modoAtaque, int danioCuerpo, int danioDistancia, int danioMedio) {
        super(costo, vidaMaxima, vida, equipo, movimiento, modoSanacion);
        this.modoAtaque= modoAtaque;
        this.danioCuerpoCuerpo = danioCuerpo;
        this.danioDistancia = danioDistancia;
        this.danioMedio = danioMedio;
    }


    public int getDanioCuerpoCuerpo(){
        return danioCuerpoCuerpo;
    }

    public int getDanioDistancia(){
        return danioDistancia;
    }

    public int getDanioMedio(){
        return danioMedio;
    }

    public void atacar(Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {
    }

    public void ejecutarUnModoDeAtaque(Pieza oponente) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        modoAtaque.atacar(this, oponente ,this.ubicacion.getDistanciaAOtroPunto(oponente.getUbicacion()));
    }
}
