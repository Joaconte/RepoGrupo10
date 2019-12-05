package vista.fasesPartida.faseMediaPartida.botonesFaseMedia;

import controlador.buttonHandlers.accionDeTurno.BotonCrearBatallonEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import modelo.pieza.ataque.PiezaAtacante;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.BarraDeJugador;

import java.util.ArrayList;

public class BotonCrearBatallon extends Button {
    public BotonCrearBatallon(PiezaAtacante primerClikeada, Label comunicador, VistaDeTablero vistaDeTablero, HBox barraDeOpcionesDeUnidad){
        super("Crear Batallon");
        this.setOnAction(new BotonCrearBatallonEventHandler(primerClikeada,comunicador,vistaDeTablero,barraDeOpcionesDeUnidad));
    }
}
