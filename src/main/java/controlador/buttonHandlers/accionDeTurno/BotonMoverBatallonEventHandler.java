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

    private VistaDeTablero vistaDeTablero;
    private HBox barraDeOpcionesDeUnidad;
    private VistaUnidad vistaUnidad;


    public BotonMoverBatallonEventHandler(VistaUnidad vistaUnidad,VistaDeTablero vistaDeTablero, HBox barraDeOpcionesDeUnidad) {
        this.vistaDeTablero=vistaDeTablero;
        this.barraDeOpcionesDeUnidad=barraDeOpcionesDeUnidad;
        this.vistaUnidad = vistaUnidad;
    }


    @Override
    public void handle(ActionEvent event) {
        vistaDeTablero.vistaComunicacion("Haga en la direccion a la que se movera");
        vistaDeTablero.tableroEnModoMovimientoBatallon(vistaUnidad);
        barraDeOpcionesDeUnidad.setVisible(false);
        Audio.reproducirInterfaz("click");
    }
}