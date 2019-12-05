package controlador.buttonHandlers.accionDeTurno;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import modelo.pieza.Pieza;
import modelo.pieza.ataque.PiezaAtacante;
import resources.sonidos.Audio;
import vista.VistaDeTablero;

import java.util.ArrayList;

public class BotonCrearBatallonEventHandler implements EventHandler<ActionEvent> {
    ArrayList<Pieza> batallon = new ArrayList<Pieza>();
    private PiezaAtacante pieza;
    private Label comunicador;
    private VistaDeTablero vistaDeTablero;
    private HBox barra;

    public BotonCrearBatallonEventHandler(PiezaAtacante pieza,Label comunicador, VistaDeTablero vistaDeTablero, HBox barraDeOpcionesDeUnidad) {
        this.comunicador = comunicador;
        this.vistaDeTablero = vistaDeTablero;
        this.batallon.add(pieza);
        this.pieza = pieza;
        this.barra = barraDeOpcionesDeUnidad;
    }

    @Override
    public void handle(ActionEvent event) {
        this.comunicador.setText("Clickea a 2 soldados de infanteria para armar el batallon.");
        this.comunicador.setTextFill(Color.web("#336600"));
        //vistaDeTablero.tableroEnModoArmarBatallon(pieza);
        barra.setVisible(false);
        Audio.reproducirInterfaz("click");
    }
}
