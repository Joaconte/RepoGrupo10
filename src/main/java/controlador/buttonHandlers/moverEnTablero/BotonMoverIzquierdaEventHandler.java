package controlador.buttonHandlers.moverEnTablero;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import vista.CamposDeTexto;
import vista.VistaDeTablero;

public class BotonMoverIzquierdaEventHandler implements EventHandler<ActionEvent> {
    private Rectangle rectangulo;
    private CamposDeTexto camposDeTexto;

    public BotonMoverIzquierdaEventHandler(VistaDeTablero vistaDeTablero, CamposDeTexto camposDeTexto) {
        this.rectangulo = vistaDeTablero.getCirculo();
        this.camposDeTexto = camposDeTexto;
    }

    @Override
    public void handle(ActionEvent event) {
        if (GridPane.getColumnIndex(rectangulo)>0) GridPane.setColumnIndex(rectangulo,GridPane.getColumnIndex(rectangulo)-1);
        camposDeTexto.textoUno.setText(GridPane.getColumnIndex(rectangulo).toString());
        camposDeTexto.textoDos.setText(GridPane.getRowIndex(rectangulo).toString());
    }
}
