package vista.fasesPartida.faseMediaPartida.botonesFaseMedia;

import controlador.buttonHandlers.accionDeTurno.BotonMoverEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import vista.VistaDeTablero;
import vista.vistaPiezas.VistaUnidad;

public class BotonMover extends Button {

    public BotonMover(VistaUnidad vistaUnidad, VistaDeTablero vistaDeTablero, HBox barraDeOpcionesDeUnidad) {
        super("Mover");
        this.setOnAction(new BotonMoverEventHandler(vistaUnidad,  vistaDeTablero, barraDeOpcionesDeUnidad));

    }
}
