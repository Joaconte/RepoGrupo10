package vista.fasesPartida.faseMediaPartida.botonesFaseMedia;

import controlador.buttonHandlers.accionDeTurno.BotonCurarEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import modelo.pieza.tipos.Curandero;
import vista.VistaDeTablero;

public class BotonCurar extends Button {

    public BotonCurar(Curandero pieza,  VistaDeTablero vistaDeTablero, VBox barraDeOpcionesDeUnidad) {
        super("Curar a Aliado");
        this.setMinWidth(140);
        this.setOnAction(new BotonCurarEventHandler(pieza,vistaDeTablero,barraDeOpcionesDeUnidad));

    }
}
