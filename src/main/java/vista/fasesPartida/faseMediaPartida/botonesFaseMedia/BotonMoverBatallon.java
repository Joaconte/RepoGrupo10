package vista.fasesPartida.faseMediaPartida.botonesFaseMedia;


import controlador.buttonHandlers.accionDeTurno.BotonMoverBatallonEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import vista.VistaDeTablero;
import vista.vistaPiezas.VistaUnidadInfanteria;

public class BotonMoverBatallon extends Button {

    public BotonMoverBatallon(VistaUnidadInfanteria vistaUnidadInfanteria, VistaDeTablero vistaDeTablero, HBox barraDeOpcionesDeUnidad) {
        super("Mover Batallon");
        this.setOnAction(new BotonMoverBatallonEventHandler(vistaUnidadInfanteria,vistaDeTablero,barraDeOpcionesDeUnidad));
    }
}
