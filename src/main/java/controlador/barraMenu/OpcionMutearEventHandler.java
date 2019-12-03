package controlador.barraMenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import resources.sonidos.Audio;

public class OpcionMutearEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Audio.mutear();
    }
}
