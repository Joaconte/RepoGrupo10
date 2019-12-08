package controlador.buttonHandlers.agregarPiezasEventHandlers;

import modelo.Juego;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Catapulta;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.BarraLateralOpciones;
import vista.vistaPiezas.VistaUnidadCatapulta;


public class BotonAgregarCatapultaEventHandler extends BotonAgregarPiezaEventHandler {

    public BotonAgregarCatapultaEventHandler(VistaDeTablero vistaDeTablero, BarraLateralOpciones vistaLateral, Juego juego) {
        super(vistaDeTablero,  "Catapulta", vistaLateral,juego);
    }

    @Override
    void agregarPiezaATablero(Pieza pieza, Juego juego) {
        VistaUnidadCatapulta vistaDeUnidad = new VistaUnidadCatapulta((Catapulta) pieza ,vistaDeTablero,"catapulta",juego);
        vistaDeUnidad.crearVistaEnTablero();
    }
}
