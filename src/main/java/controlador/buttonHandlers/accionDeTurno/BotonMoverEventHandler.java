package controlador.buttonHandlers.accionDeTurno;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import modelo.Juego;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Curandero;

import resources.sonidos.Audio;
import vista.VistaDeTablero;
import vista.vistaPiezas.VistaUnidad;

public class BotonMoverEventHandler implements EventHandler<ActionEvent> {

    private VistaDeTablero vistaDeTablero;
    private HBox barraDeOpcionesDeUnidad;
    private VistaUnidad vistaUnidad;


    public BotonMoverEventHandler(VistaUnidad vistaUnidad,  VistaDeTablero vistaDeTablero, HBox barraDeOpcionesDeUnidad) {
        this.vistaDeTablero=vistaDeTablero;
        this.barraDeOpcionesDeUnidad=barraDeOpcionesDeUnidad;
        this.vistaUnidad = vistaUnidad;
    }


    @Override
    public void handle(ActionEvent event) {
        vistaDeTablero.vistaComunicacion("Haga en la direccion a la que se movera");
        vistaDeTablero.tableroEnModoMovimiento(vistaUnidad);
        barraDeOpcionesDeUnidad.setVisible(false);
        Audio.reproducirInterfaz("click");
    }
}