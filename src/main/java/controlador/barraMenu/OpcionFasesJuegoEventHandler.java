package controlador.barraMenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class OpcionFasesJuegoEventHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION,""
                +"Fase Inicial: Elegir ejercito y acomodarlos.\n"
                +"Fase Media: Por Turnos eligen que pieza se mueve y a quién ataca\n"
                +"Fase final: Pierde el que se quede sin piezas en el tablero\n"
            );

        alerta.setTitle("Sobre las fases del Juego...");
        alerta.setHeaderText("Fases de Juego: ");
        alerta.showAndWait();
    }
}
