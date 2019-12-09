package controlador.buttonHandlers.accionDeTurno;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import resources.sonidos.Audio;
import vista.VistaDeTablero;
import vista.vistaPiezas.VistaUnidad;

public class BotonMoverBatallonEventHandler implements EventHandler<ActionEvent> {

    private VistaDeTablero vistaDeTablero;
    private VBox barraDeOpcionesDeUnidad;
    private VistaUnidad vistaUnidad;


    public BotonMoverBatallonEventHandler(VistaUnidad vistaUnidad,VistaDeTablero vistaDeTablero, VBox barraDeOpcionesDeUnidad) {
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