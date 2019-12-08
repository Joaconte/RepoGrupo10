package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.scene.control.Label;
import modelo.Juego;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Curandero;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.BarraLateralOpciones;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;
import vista.vistaPiezas.VistaUnidadCurandera;


public class BotonAgregarCuranderoEventHandler extends BotonAgregarPiezaEventHandler {

    public BotonAgregarCuranderoEventHandler(VistaDeTablero vistaDeTablero, BarraLateralOpciones vistaLateral, Juego juego) {

        super( vistaDeTablero,  "Curandero", vistaLateral,juego);

    }


    @Override
    void agregarPiezaATablero(Pieza pieza, Juego juego) {
        VistaUnidadCurandera vistaDeUnidad = new VistaUnidadCurandera((Curandero) pieza ,vistaDeTablero,"curandero",juego);
        vistaDeUnidad.crearVistaEnTablero();

    }
}
