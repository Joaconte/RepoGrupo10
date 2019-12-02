package controlador.buttonHandlers.fase.faseJuego;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import modelo.pieza.Ubicacion;

public class BotonActualizarPosicionesEventHandler implements EventHandler<ActionEvent> {

    private Label eti1;
    private Label eti2;
    private Ubicacion ubicacionVariable;
    private Ubicacion ubicacionEstatica;

    public BotonActualizarPosicionesEventHandler(Label etiquetaUbicacion1, Label etiquetaUbicacion2, Ubicacion ubicacionVariable, Ubicacion ubicacionEstatica){

        eti1 = etiquetaUbicacion1;
        eti2 = etiquetaUbicacion2;
        this.ubicacionVariable = ubicacionVariable;
        this.ubicacionEstatica = ubicacionEstatica;

    }
    @Override
    public void handle(ActionEvent event) {


        eti1.setText(Integer.toString( ubicacionVariable.getPosicionEnX()) + " " +
                Integer.toString(ubicacionVariable.getPosicionEnY()) );
        Label etiquetaUbicacion2 = new Label();
        eti2.setText(Integer.toString( ubicacionEstatica.getPosicionEnX()) + " " +
                Integer.toString(ubicacionEstatica.getPosicionEnY()) );

    }

}
