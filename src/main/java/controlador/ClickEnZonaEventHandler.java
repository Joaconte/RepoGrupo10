package controlador;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import modelo.pieza.Ubicacion;

public class ClickEnZonaEventHandler implements EventHandler<MouseEvent> {
    private Node nodoAMover;
    private Node nodoDireccion;
    private Ubicacion ubicacion;

    public ClickEnZonaEventHandler(Node rectanguloDeMovimiento, Node panel, Ubicacion ubicacion) {
        this.nodoAMover =rectanguloDeMovimiento;
        this.nodoDireccion = panel;
        this.ubicacion = ubicacion;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        GridPane.setColumnIndex(nodoAMover,GridPane.getColumnIndex(nodoDireccion));
        GridPane.setRowIndex(nodoAMover,GridPane.getRowIndex(nodoDireccion));
        ubicacion.setPosicionEnX(GridPane.getColumnIndex(nodoAMover));
        ubicacion.setPosicionEnY(GridPane.getRowIndex(nodoAMover));

    }
}
