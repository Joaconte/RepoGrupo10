package controlador;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.Effect;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import vista.vistaPiezas.VistaUnidad;

public class ClickEnPiezaEventHandler implements EventHandler<MouseEvent> {

    private VistaUnidad vistaPiezaClikeada;
    private VistaUnidad piezaClikeada;

    public ClickEnPiezaEventHandler( VistaUnidad vistaPiezaClikeada, VistaUnidad piezaClikeada) {
        this.vistaPiezaClikeada = vistaPiezaClikeada;
        this.piezaClikeada = piezaClikeada;
        ;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        vistaPiezaClikeada.getVistaInformacion().getChildren().clear();
        vistaPiezaClikeada.getVistaInformacion().getChildren().add(piezaClikeada.getVistaInformacion());
        vistaPiezaClikeada.setAlignment(Pos.CENTER);
        vistaPiezaClikeada.setPieza(piezaClikeada.getPieza());

    }
}
