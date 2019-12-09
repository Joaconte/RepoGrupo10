package controlador.buttonHandlers.accionDeTurno;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import modelo.pieza.Pieza;
import modelo.pieza.ataque.PiezaAtacante;
import resources.sonidos.Audio;
import vista.VistaDeTablero;

import java.util.ArrayList;

public class BotonCrearBatallonEventHandler implements EventHandler<ActionEvent> {
    ArrayList<Pieza> batallon = new ArrayList<>();
    private VistaDeTablero vistaDeTablero;
    private VBox barra;

    public BotonCrearBatallonEventHandler(PiezaAtacante pieza, VistaDeTablero vistaDeTablero, VBox barraDeOpcionesDeUnidad) {
        this.vistaDeTablero = vistaDeTablero;
        this.batallon.add(pieza);
        this.barra = barraDeOpcionesDeUnidad;
    }

    @Override
    public void handle(ActionEvent event) {
        vistaDeTablero.vistaComunicacion("Clickea a otros 2 infantes adyacentes.");
        vistaDeTablero.tableroEnModoArmarBatallon(batallon);
        barra.setVisible(false);
        Audio.reproducirInterfaz("click");
    }
}
