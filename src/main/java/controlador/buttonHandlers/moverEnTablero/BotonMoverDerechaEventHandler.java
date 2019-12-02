package controlador.buttonHandlers.moverEnTablero;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import modelo.pieza.Ubicacion;
import vista.CamposDeTexto;
import vista.VistaDeTablero;

public class BotonMoverDerechaEventHandler implements EventHandler<ActionEvent> {
    private Rectangle rectangulo;
    private Ubicacion ubicacion;

    public BotonMoverDerechaEventHandler(VistaDeTablero vistaDeTablero, Ubicacion ubicacion) {
        this.rectangulo = vistaDeTablero.getCirculo();
        this.ubicacion = ubicacion;
    }

    @Override
    public void handle(ActionEvent event) {
        if (GridPane.getColumnIndex(rectangulo)<19)GridPane.setColumnIndex(rectangulo,GridPane.getColumnIndex(rectangulo)+1);
        ubicacion.setPosicionEnX(GridPane.getColumnIndex(rectangulo));
        ubicacion.setPosicionEnY(GridPane.getRowIndex(rectangulo));
    }
}
