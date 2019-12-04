package controlador.buttonHandlers.accionDeTurno;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import modelo.Juego;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Curandero;

import vista.VistaDeTablero;
import vista.vistaPiezas.VistaUnidad;

public class BotonMoverEventHandler implements EventHandler<ActionEvent> {

    private Label etiquetaTexto;
    private VistaDeTablero vistaDeTablero;
    private HBox barraDeOpcionesDeUnidad;
    private VistaUnidad vistaUnidad;


    public BotonMoverEventHandler(VistaUnidad vistaUnidad, Label etiquetaAlerta, VistaDeTablero vistaDeTablero, HBox barraDeOpcionesDeUnidad) {
        this.etiquetaTexto=etiquetaAlerta;
        this.vistaDeTablero=vistaDeTablero;
        this.barraDeOpcionesDeUnidad=barraDeOpcionesDeUnidad;
        this.vistaUnidad = vistaUnidad;
    }


    @Override
    public void handle(ActionEvent event) {
        etiquetaTexto.setText("Haga en la direccion a la que se movera");
        etiquetaTexto.setTextFill(Color.web("#336600"));
        vistaDeTablero.tableroEnModoMovimiento(vistaUnidad,etiquetaTexto);
        barraDeOpcionesDeUnidad.setVisible(false);

    }
}