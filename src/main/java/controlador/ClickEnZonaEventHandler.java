package controlador;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import resources.sonidos.Audio;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.VistaPiezaClikeada;

public class ClickEnZonaEventHandler implements EventHandler<MouseEvent> {
    private Node nodoAMover;
    private Node nodoDireccion;
    private VistaDeTablero vistaDeTablero;
    private VistaPiezaClikeada vistaPiezaClikeada;

    public ClickEnZonaEventHandler(Node rectanguloDeMovimiento, Node panel, VistaDeTablero vistaDeTablero, VistaPiezaClikeada vistaPiezaClikeada) {
        this.nodoAMover =rectanguloDeMovimiento;
        this.nodoDireccion = panel;
        this.vistaDeTablero=vistaDeTablero;
        this.vistaPiezaClikeada= vistaPiezaClikeada;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        GridPane.setColumnIndex(nodoAMover,GridPane.getColumnIndex(nodoDireccion));
        GridPane.setRowIndex(nodoAMover,GridPane.getRowIndex(nodoDireccion));
        vistaDeTablero.setUbicacionClik(GridPane.getColumnIndex(nodoDireccion),GridPane.getRowIndex(nodoDireccion));
        vistaPiezaClikeada.vistaMensajeUbicacion("Fila: "+ GridPane.getRowIndex(nodoDireccion) + " Columna: " + GridPane.getColumnIndex(nodoDireccion) );
        Audio.reproducirInterfaz("click");
    }
}
