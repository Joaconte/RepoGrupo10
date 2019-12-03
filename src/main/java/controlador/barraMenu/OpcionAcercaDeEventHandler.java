package controlador.barraMenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,""
                    +"2019 \n");
        alert.setTitle("Acerca de ");
        alert.setResizable(true);
        alert.setHeaderText("Trabajo Práctico 2- Algoritmos y programación 3- FIUBA");
        alert.showAndWait();
    }
}
