package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import modelo.pieza.Ubicacion;
import vista.CamposDeTexto;

public class ClickEnZonaEventHandler implements EventHandler<MouseEvent> {
    private Rectangle rectangulo;
    private Pane panel;
    private Ubicacion ubicacion;

    public ClickEnZonaEventHandler(Rectangle rectanguloDeMovimiento, Pane panel, Ubicacion ubicacion) {
        this.rectangulo =rectanguloDeMovimiento;
        this.panel = panel;
        this.ubicacion = ubicacion;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        GridPane.setColumnIndex(rectangulo,GridPane.getColumnIndex(panel));
        GridPane.setRowIndex(rectangulo,GridPane.getRowIndex(panel));
        ubicacion.setPosicionEnX(GridPane.getColumnIndex(rectangulo));
        ubicacion.setPosicionEnY(GridPane.getRowIndex(rectangulo));

    }
}
