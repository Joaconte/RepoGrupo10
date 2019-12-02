package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import vista.CamposDeTexto;

public class ClickEnZonaEventHandler implements EventHandler<MouseEvent> {
    private Rectangle rectangulo;
    private Pane panel;
    private CamposDeTexto camposDeUbicacion;

    public ClickEnZonaEventHandler(Rectangle rectanguloDeMovimiento, Pane panel, CamposDeTexto camposDeUbicacion) {
        this.rectangulo =rectanguloDeMovimiento;
        this.panel = panel;
        this.camposDeUbicacion = camposDeUbicacion;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        GridPane.setColumnIndex(rectangulo,GridPane.getColumnIndex(panel));
        GridPane.setRowIndex(rectangulo,GridPane.getRowIndex(panel));
        camposDeUbicacion.textoUno.setText(GridPane.getColumnIndex(rectangulo).toString());
        camposDeUbicacion.textoDos.setText(GridPane.getRowIndex(rectangulo).toString());

    }
}
