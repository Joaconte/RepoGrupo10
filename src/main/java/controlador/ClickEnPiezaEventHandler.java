package controlador;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import vista.vistaPiezas.VistaUnidad;

public class ClickEnPiezaEventHandler implements EventHandler<MouseEvent> {

    private VistaUnidad vistaPiezaClikeada;
    private VBox piezaClikeada;


    public ClickEnPiezaEventHandler(VBox etiquetaUnidad, VistaUnidad vistaUnidadClikeada) {
    this.vistaPiezaClikeada = vistaUnidadClikeada;
    this.piezaClikeada = etiquetaUnidad;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        piezaClikeada.getChildren().clear();
        vistaPiezaClikeada.getVistaInformacion().actualizarDatosEnPartida();
        piezaClikeada.getChildren().add(vistaPiezaClikeada.getVistaInformacion());
        vistaPiezaClikeada.visibilidadDeOpcionesPorTurno();
        vistaPiezaClikeada.barraDeOpciones();
    }
}
