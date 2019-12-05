package controlador.buttonHandlers.accionDeTurno;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import resources.sonidos.Audio;
import vista.VistaDeTablero;
import vista.vistaPiezas.VistaUnidad;
import vista.vistaPiezas.VistaUnidadInfanteria;

public class BotonMoverBatallonEventHandler implements EventHandler<ActionEvent> {

    private Label etiquetaTexto;
    private VistaDeTablero vistaDeTablero;
    private HBox barraDeOpcionesDeUnidad;
    private VistaUnidad vistaUnidad;


    public BotonMoverBatallonEventHandler(VistaUnidad vistaUnidad, Label etiquetaAlerta, VistaDeTablero vistaDeTablero, HBox barraDeOpcionesDeUnidad) {
        this.etiquetaTexto=etiquetaAlerta;
        this.vistaDeTablero=vistaDeTablero;
        this.barraDeOpcionesDeUnidad=barraDeOpcionesDeUnidad;
        this.vistaUnidad = vistaUnidad;
    }


    @Override
    public void handle(ActionEvent event) {
        etiquetaTexto.setText("Haga en la direccion a la que se movera");
        etiquetaTexto.setTextFill(Color.web("#336600"));
        vistaDeTablero.tableroEnModoMovimientoBatallon(vistaUnidad,etiquetaTexto);
        barraDeOpcionesDeUnidad.setVisible(false);
        Audio.reproducirInterfaz("click");
    }
}