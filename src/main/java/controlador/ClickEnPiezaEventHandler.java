package controlador;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.Effect;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class ClickEnPiezaEventHandler implements EventHandler<MouseEvent> {

    private Node unidad;
    private VBox vistaPiezaClikeada;
    private VBox piezaClikeada;

    public ClickEnPiezaEventHandler(Node unidadImagen, VBox vistaPiezaClikeada, VBox piezaClikeada) {
        this.unidad=unidadImagen;
        this.vistaPiezaClikeada = vistaPiezaClikeada;
        this.piezaClikeada = piezaClikeada;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        vistaPiezaClikeada.getChildren().clear();
        piezaClikeada.setAlignment(Pos.CENTER);
        vistaPiezaClikeada.getChildren().add(piezaClikeada);
        vistaPiezaClikeada.setAlignment(Pos.CENTER);
    }
}
