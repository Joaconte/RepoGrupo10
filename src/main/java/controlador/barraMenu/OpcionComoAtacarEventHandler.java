package controlador.barraMenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class OpcionComoAtacarEventHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION,""
                +"Las posiciones empiezan en 0 y van de izquierda a derecha.\n"
                +"Elegir pieza que va a atacar o curar\n"
                +"Elegir pieza que va a recibir el daño o curacion.\n"
            );
        alerta.setTitle("Atacar...");
        alerta.setHeaderText("Como realizar ataque o curacion:");
        alerta.showAndWait();
    }
}
