package vista.fasesPartida.faseMediaPartida.botonesFaseMedia;


import controlador.buttonHandlers.accionDeTurno.BotonMoverBatallonEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import vista.VistaDeTablero;
import vista.vistaPiezas.VistaUnidadInfanteria;

public class BotonMoverBatallon extends Button {

    public BotonMoverBatallon(VistaUnidadInfanteria vistaUnidadInfanteria, VistaDeTablero vistaDeTablero, VBox barraDeOpcionesDeUnidad) {
        super("Mover Batallon");
        this.setMinWidth(140);
        this.setOnAction(new BotonMoverBatallonEventHandler(vistaUnidadInfanteria,vistaDeTablero,barraDeOpcionesDeUnidad));
    }
}
