package controlador.buttonHandlers.moverEnTablero;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import modelo.pieza.Ubicacion;
import vista.VistaDeTablero;

public class BotonMoverAbajoEventHandler implements EventHandler<ActionEvent> {
    private Rectangle rectangulo;
    private Ubicacion ubicacion;

    public BotonMoverAbajoEventHandler(VistaDeTablero vistaDeTablero, Ubicacion ubicacion) {
        this.rectangulo = vistaDeTablero.getCirculo();
        this.ubicacion=ubicacion;
    }

    @Override
    public void handle(ActionEvent event) {
        if (GridPane.getRowIndex(rectangulo)<19) GridPane.setRowIndex(rectangulo,GridPane.getRowIndex(rectangulo)+1);
        ubicacion.setPosicionEnX(GridPane.getColumnIndex(rectangulo));
        ubicacion.setPosicionEnY(GridPane.getRowIndex(rectangulo));
    }
}
