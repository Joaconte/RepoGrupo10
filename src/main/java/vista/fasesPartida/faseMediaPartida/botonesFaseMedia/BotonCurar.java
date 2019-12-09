package vista.fasesPartida.faseMediaPartida.botonesFaseMedia;

import controlador.buttonHandlers.accionDeTurno.BotonCurarEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import modelo.Juego;
import modelo.pieza.tipos.Curandero;
import vista.VistaDeTablero;

public class BotonCurar extends Button {

    public BotonCurar(Curandero pieza,  VistaDeTablero vistaDeTablero, HBox barraDeOpcionesDeUnidad) {
        super("Curar a Aliado");
        this.setOnAction(new BotonCurarEventHandler(pieza,vistaDeTablero,barraDeOpcionesDeUnidad));

    }
}
