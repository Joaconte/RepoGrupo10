package controlador.buttonHandlers.moverEnTablero;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import modelo.pieza.Ubicacion;
import vista.CamposDeTexto;
import vista.VistaDeTablero;


public class  BotonMoverArribaEventHandler implements EventHandler<ActionEvent> {

    private Rectangle rectangulo;
    private Ubicacion ubicacion;

    public BotonMoverArribaEventHandler(VistaDeTablero vistaDeTablero, Ubicacion ubicacion) {
        this.rectangulo = vistaDeTablero.getCirculo();
        this.ubicacion = ubicacion;
    }

    @Override
    public void handle(ActionEvent event) {
        if (GridPane.getRowIndex(rectangulo)>0)GridPane.setRowIndex(rectangulo,GridPane.getRowIndex(rectangulo)-1);
        ubicacion.setPosicionEnX(GridPane.getColumnIndex(rectangulo));
        ubicacion.setPosicionEnY(GridPane.getRowIndex(rectangulo));
    }
}


