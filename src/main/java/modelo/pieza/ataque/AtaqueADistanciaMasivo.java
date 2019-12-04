package modelo.pieza.ataque;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;

import java.util.List;

public class AtaqueADistanciaMasivo extends AtaqueADistancia  implements IModoAtaqueMasivo  {

    @Override
    public void atacarEnMasa(PiezaAtacante miUnidad, Pieza piezaAtacada, List<Pieza> piezas) throws DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException {


        double vidaAntesDelAtaque= piezaAtacada.getPuntosVida();
        super.atacar(miUnidad, piezaAtacada);
        double danioAReplicar = vidaAntesDelAtaque - piezaAtacada.getPuntosVida();
        piezas.stream().filter(p->p!=piezaAtacada).forEach(p-> { try { p.recibirDanio(danioAReplicar); } catch (UnidadEstaMuertaException e) { } });


    }


}
