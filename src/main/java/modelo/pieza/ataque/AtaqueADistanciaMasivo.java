package modelo.pieza.ataque;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;

import java.util.List;

public class AtaqueADistanciaMasivo extends AtaqueADistancia  implements IModoAtaqueMasivo  {

    @Override
    public void atacarEnMasa(PiezaAtacante miUnidad, List<Pieza> piezas) throws DistanciaDeAtaqueInvalidaException, UnidadEstaMuertaException {

        Pieza victimaPrincipal = piezas.get(0);
        piezas.remove(0);

        double daniaAReplicar = victimaPrincipal.getPuntosVida(); //Cuestiones de enunciado.
        super.atacar(miUnidad, victimaPrincipal);
        daniaAReplicar = daniaAReplicar - victimaPrincipal.getPuntosVida();

        for (int i=0; i<piezas.size(); i++){
            piezas.get(i).recibirDanio(daniaAReplicar);
        }
    }

}
