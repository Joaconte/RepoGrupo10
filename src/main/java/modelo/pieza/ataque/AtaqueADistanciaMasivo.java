package modelo.pieza.ataque;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;

import java.util.List;

public class AtaqueADistanciaMasivo extends AtaqueADistancia  implements IModoAtaqueMasivo  {

    @Override
    public void atacarEnMasa(PiezaAtacante miUnidad, List<Pieza> piezas) throws DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException {

        Pieza victimaPrincipal = piezas.get(0);
        piezas.remove(0);


        double vidaAntesDelAtaque= victimaPrincipal.getPuntosVida(); //Cuestiones de enunciado.
        super.atacar(miUnidad, victimaPrincipal);
        double danioAReplicar = vidaAntesDelAtaque - victimaPrincipal.getPuntosVida();

        piezas.stream().forEach(p-> { try { p.recibirDanio(danioAReplicar); } catch (UnidadEstaMuertaException e) { e.printStackTrace(); } });
    }

}
