package vista.fasesPartida.faseMediaPartida.botonesFaseMedia;

import controlador.buttonHandlers.accionDeTurno.BotonCrearBatallonEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import modelo.pieza.ataque.PiezaAtacante;
import vista.VistaDeTablero;

public class BotonCrearBatallon extends Button {
    public BotonCrearBatallon(PiezaAtacante primerClikeada,  VistaDeTablero vistaDeTablero, VBox barraDeOpcionesDeUnidad){
        super("Crear Batallon");
        this.setMinWidth(140);
        this.setOnAction(new BotonCrearBatallonEventHandler(primerClikeada,vistaDeTablero,barraDeOpcionesDeUnidad));
    }
}
