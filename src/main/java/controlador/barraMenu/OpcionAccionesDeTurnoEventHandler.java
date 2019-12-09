package controlador.barraMenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class OpcionAccionesDeTurnoEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, ""
                + "Ataques: Hasta 3 ataques. \n"
                + "Curaciones: Hasta 3 curaciones.  \n"
                + "Curaciones y ataques: las dos tienen que sumar 3. \n"
                + "Movimientos: hasta 2 movimientos. \n"
        );

        alerta.setTitle("Sobre las acciones...");
        alerta.setHeaderText("Acciones de turno: ");
        alerta.showAndWait();
    }
}
