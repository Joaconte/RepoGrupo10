package controlador.buttonHandlers.accionDeTurno;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import resources.sonidos.Audio;
import vista.VistaDeTablero;
import vista.vistaPiezas.VistaUnidad;

public class BotonMoverEventHandler implements EventHandler<ActionEvent> {

    private VistaDeTablero vistaDeTablero;
    private VBox barraDeOpcionesDeUnidad;
    private VistaUnidad vistaUnidad;


    public BotonMoverEventHandler(VistaUnidad vistaUnidad,  VistaDeTablero vistaDeTablero, VBox barraDeOpcionesDeUnidad) {
        this.vistaDeTablero=vistaDeTablero;
        this.barraDeOpcionesDeUnidad=barraDeOpcionesDeUnidad;
        this.vistaUnidad = vistaUnidad;
    }


    @Override
    public void handle(ActionEvent event) {
        vistaDeTablero.vistaComunicacion("Haga click en una casilla adyacente");
        vistaDeTablero.tableroEnModoMovimiento(vistaUnidad);
        barraDeOpcionesDeUnidad.setVisible(false);
        Audio.reproducirInterfaz("click");
    }
}