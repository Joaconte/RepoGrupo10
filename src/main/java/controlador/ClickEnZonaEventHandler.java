package controlador;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import resources.sonidos.Audio;
import vista.VistaDeTablero;

public class ClickEnZonaEventHandler implements EventHandler<MouseEvent> {
    private Node nodoAMover;
    private Node nodoDireccion;
    private VistaDeTablero vistaDeTablero;

    public ClickEnZonaEventHandler(Node rectanguloDeMovimiento, Node panel, VistaDeTablero vistaDeTablero) {
        this.nodoAMover =rectanguloDeMovimiento;
        this.nodoDireccion = panel;
        this.vistaDeTablero=vistaDeTablero;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        GridPane.setColumnIndex(nodoAMover,GridPane.getColumnIndex(nodoDireccion));
        GridPane.setRowIndex(nodoAMover,GridPane.getRowIndex(nodoDireccion));
        vistaDeTablero.setUbicacionClik(GridPane.getColumnIndex(nodoDireccion),GridPane.getRowIndex(nodoDireccion));

        Audio.reproducirInterfaz("click");
    }
}
