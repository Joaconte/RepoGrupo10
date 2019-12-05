package vista.vistaPiezas;

import modelo.Juego;
import modelo.pieza.ataque.PiezaAtacante;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.botonesFaseMedia.BotonCrearBatallon;

public class VistaUnidadInfanteria extends VistaUnidadAtacante {

    public VistaUnidadInfanteria(PiezaAtacante piezaAtacante, VistaDeTablero vistaDeTablero, String nombre, Juego juego) {
        super(piezaAtacante, vistaDeTablero, nombre, juego);

    }

    public void barraDeOpciones() {
        super.barraDeOpciones();
        barraDeOpcionesDeUnidad.getChildren().add(new BotonCrearBatallon(piezaAtacante,etiquetaDeTexto,vistaDeTablero,barraDeOpcionesDeUnidad));
    }

}
