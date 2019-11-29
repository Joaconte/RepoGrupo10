package modelo.pieza.ataque;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;


public class AtaqueVariable implements IModoAtaqueVariable {

    private IModoAtaque modoAtaque;

    @Override
    public void atacar(PiezaAtacante miUnidad, Pieza victima) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        modoAtaque.atacar(miUnidad,victima);
    }

    @Override
    public void setModoDeAtaque(IModoAtaque modoAtaque){
        this.modoAtaque = modoAtaque;
    }


}
