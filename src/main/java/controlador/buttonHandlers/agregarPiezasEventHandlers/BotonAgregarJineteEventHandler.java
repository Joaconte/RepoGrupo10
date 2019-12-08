package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.scene.control.Label;
import modelo.Juego;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Jinete;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.BarraLateralOpciones;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;
import vista.vistaPiezas.VistaUnidadAtacante;


public class BotonAgregarJineteEventHandler extends BotonAgregarPiezaEventHandler {

    public BotonAgregarJineteEventHandler(VistaDeTablero vistaDeTablero, BarraLateralOpciones vistaLateral, Juego juego) {

        super( vistaDeTablero, "Jinete",vistaLateral,juego);
    }

    @Override
    void agregarPiezaATablero(Pieza pieza,Juego juego) {
        VistaUnidadAtacante vistaDeUnidad = new VistaUnidadAtacante((Jinete) pieza ,vistaDeTablero,"jinete",juego);
        vistaDeUnidad.crearVistaEnTablero();
    }
}

