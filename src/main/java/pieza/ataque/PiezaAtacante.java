package pieza.ataque;

import pieza.Pieza;
import pieza.UnidadEstaMuertaException;
import pieza.movimiento.IModoMovimiento;
import pieza.sanacion.IModoSanacion;
import tablero.Tablero;

public abstract class PiezaAtacante extends Pieza {
    private int danioCuerpoCuerpo;
    private int danioDistancia;
    private int danioMedio;

    private IModoAtaque modoAtaque;

    public PiezaAtacante(int costo, int vidaMaxima, int equipo, IModoMovimiento movimiento, IModoSanacion modoSanacion,IModoAtaque modoAtaque, int danioCuerpo, int danioMedio, int danioDistancia) {
        super(costo, vidaMaxima, equipo, movimiento, modoSanacion);
        this.modoAtaque= modoAtaque;
        this.danioCuerpoCuerpo = danioCuerpo;
        this.danioDistancia = danioDistancia;
        this.danioMedio = danioMedio;
    }

    public PiezaAtacante(int costo, int vidaMaxima, int equipo, IModoMovimiento movimiento, IModoSanacion modoSanacion,IModoAtaque modoAtaque,int danioCuerpo, int danioMedio, int danioDistancia, int posX, int posY) {
        super(costo, vidaMaxima, equipo, movimiento, modoSanacion,posX,posY);
        this.modoAtaque= modoAtaque;
        this.setDanioCuerpo_Distancia_Media(danioCuerpo,danioMedio,danioDistancia);
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

    private void setDanioCuerpo_Distancia_Media(int cantidadDanioMele, int cantidadDanioDistancia, int cantidadDanioDistanciaMedia){
        this.danioCuerpoCuerpo = cantidadDanioMele;
        this.danioDistancia = cantidadDanioDistancia;
        this.danioMedio = cantidadDanioDistanciaMedia;
    }
    public void atacar(Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {
    }

    @Override
    public abstract String getNombre();
}
