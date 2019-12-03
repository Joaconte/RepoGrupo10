package controlador;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import vista.vistaPiezas.VistaUnidad;
import vista.vistaPiezas.VistaUnidadParaTablero;

public class ClickEnPiezaEventHandler implements EventHandler<MouseEvent> {

    private VistaUnidadParaTablero vistaPiezaClikeada;
    private VistaUnidadParaTablero piezaClikeada;

    public ClickEnPiezaEventHandler(VistaUnidadParaTablero vistaPiezaClikeada, VistaUnidadParaTablero piezaClikeada) {
        this.vistaPiezaClikeada = vistaPiezaClikeada;
        this.piezaClikeada = piezaClikeada;
        ;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        vistaPiezaClikeada.setVistaUnidadCompleta(piezaClikeada.getVistaUnidadCompleta());
        vistaPiezaClikeada.setInformacionUnidad();
        vistaPiezaClikeada = piezaClikeada;

    }
}
