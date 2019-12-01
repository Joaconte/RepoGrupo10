package controlador.buttonHandlers.moverEnTablero;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import vista.CamposDeTexto;
import vista.VistaDeTablero;

public class BotonMoverAbajoEventHandler implements EventHandler<ActionEvent> {
    private Rectangle rectangulo;
    private CamposDeTexto camposDeTexto;

    public BotonMoverAbajoEventHandler(VistaDeTablero vistaDeTablero, CamposDeTexto camposDeTexto) {
        this.rectangulo = vistaDeTablero.getCirculo();
        this.camposDeTexto=camposDeTexto;
    }

    @Override
    public void handle(ActionEvent event) {
        if (GridPane.getRowIndex(rectangulo)<19) GridPane.setRowIndex(rectangulo,GridPane.getRowIndex(rectangulo)+1);
        camposDeTexto.textoUno.setText(GridPane.getColumnIndex(rectangulo).toString());
        camposDeTexto.textoDos.setText(GridPane.getRowIndex(rectangulo).toString());
    }
}
