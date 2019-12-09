package vista.fasesPartida.faseMediaPartida.botonesFaseMedia;

import controlador.buttonHandlers.accionDeTurno.BotonMoverEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import vista.VistaDeTablero;
import vista.vistaPiezas.VistaUnidad;

public class BotonMover extends Button {

    public BotonMover(VistaUnidad vistaUnidad, VistaDeTablero vistaDeTablero, VBox barraDeOpcionesDeUnidad) {
        super("Mover");
        this.setMinWidth(140);
        this.setOnAction(new BotonMoverEventHandler(vistaUnidad,  vistaDeTablero, barraDeOpcionesDeUnidad));

    }
}
