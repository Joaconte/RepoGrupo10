package vista.vistaPiezas;

import modelo.pieza.ataque.PiezaAtacante;
import vista.VistaDeTablero;

public class VistaUnidadAtacante extends VistaUnidad{

    PiezaAtacante piezaAtacante;


    public VistaUnidadAtacante(PiezaAtacante piezaAtacante, VistaDeTablero vistaDeTablero, String nombre){
        super(piezaAtacante,vistaDeTablero,nombre);
        this.piezaAtacante = piezaAtacante;
        }

        @Override
        public PiezaAtacante getPieza() {
            return piezaAtacante;
        }

}
