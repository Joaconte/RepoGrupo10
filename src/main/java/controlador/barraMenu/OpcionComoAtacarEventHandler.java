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
                +"Atacan en rango corto: infantes, jinete.\n"
                +"Atacan en rango largo: Catapulta.\n"
                +"Atacan en rango medio: Jinete.\n"
                +"Jinete debe estar sin rivales en rango corto para atacar en rango media.\n"
                +"Jinete puede atacar a distancia media SIEMPRE si un infante aliado lo rodea.\n"



        );
        alerta.setTitle("Atacar...");
        alerta.setHeaderText("Como realizar ataque o curacion:");
        alerta.showAndWait();
    }
}
