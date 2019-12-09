package controlador.buttonHandlers.accionDeTurno;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import modelo.Juego;
import modelo.pieza.tipos.Curandero;
import resources.sonidos.Audio;
import vista.VistaDeTablero;

public class BotonCurarEventHandler  implements EventHandler<ActionEvent>{

    private Curandero pieza;
    private VistaDeTablero vistaDeTablero;
    private HBox barraDeOpcionesDeUnidad;

    public BotonCurarEventHandler(Curandero pieza,  VistaDeTablero vistaDeTablero, HBox barraDeOpcionesDeUnidad) {
        this.pieza=pieza;
        this.vistaDeTablero=vistaDeTablero;
        this.barraDeOpcionesDeUnidad=barraDeOpcionesDeUnidad;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        vistaDeTablero.vistaComunicacion("Haga click en la pieza a la que desea curar");
        vistaDeTablero.tableroEnModoCuracion(pieza);
        barraDeOpcionesDeUnidad.setVisible(false);
        Audio.reproducirInterfaz("click");
    }
}

