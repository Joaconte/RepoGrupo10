package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.VistaPiezaClikeada;
import vista.vistaPiezas.VistaUnidad;

public class ClickEnPiezaEventHandler implements EventHandler<MouseEvent> {

    private VistaPiezaClikeada vistaPiezaClikeada;
    private VistaUnidad piezaClikeada;

    public ClickEnPiezaEventHandler(VistaPiezaClikeada vistaUnidadClikeada, VistaUnidad piezaClikeada) {
        this.vistaPiezaClikeada = vistaUnidadClikeada;
        this.piezaClikeada = piezaClikeada;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        piezaClikeada.barraDeOpciones();
        vistaPiezaClikeada.vistaActualizada(piezaClikeada.getVistaInformacion());
    }
}
