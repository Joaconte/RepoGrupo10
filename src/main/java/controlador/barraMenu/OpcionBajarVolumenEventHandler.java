package controlador.barraMenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import resources.sonidos.Audio;

public class OpcionBajarVolumenEventHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Audio.bajarVolumen();
    }
}
