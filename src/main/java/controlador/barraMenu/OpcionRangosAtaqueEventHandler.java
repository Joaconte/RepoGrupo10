package controlador.barraMenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class OpcionRangosAtaqueEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION,""
                    +"Rango Corto: Una a dos casillas. \n"
                    +"Rango Medio: tres a cinco casillas.  \n"
                    +"Rango lejano: de seis a veinte casillas. \n"
            );

            alerta.setTitle("Sobre los Rangos de Ataque...");
            alerta.setHeaderText("Rangos de Ataque: ");
            alerta.showAndWait();
        }
    }
