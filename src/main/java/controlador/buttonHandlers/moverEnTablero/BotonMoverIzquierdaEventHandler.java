package controlador.buttonHandlers.moverEnTablero;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import vista.CamposDeTexto;
import vista.VistaDeTablero;

public class BotonMoverIzquierdaEventHandler implements EventHandler<ActionEvent> {
    private Circle circulo;
    private CamposDeTexto camposDeTexto;

    public BotonMoverIzquierdaEventHandler(VistaDeTablero vistaDeTablero, CamposDeTexto camposDeTexto) {
        this.circulo = vistaDeTablero.getCirculo();
        this.camposDeTexto = camposDeTexto;
    }

    @Override
    public void handle(ActionEvent event) {
        if (GridPane.getColumnIndex(circulo)>0) GridPane.setColumnIndex(circulo,GridPane.getColumnIndex(circulo)-1);
        camposDeTexto.textoUno.setText(GridPane.getColumnIndex(circulo).toString());
        camposDeTexto.textoDos.setText(GridPane.getRowIndex(circulo).toString());
    }
}
