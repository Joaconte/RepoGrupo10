package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TextoEventHandler implements EventHandler<KeyEvent> {

    private Button botonAgregarJugador;

    public TextoEventHandler(Button botonAgregarJugador) {
        this.botonAgregarJugador = botonAgregarJugador;
    }

    @Override
    public void handle(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            Event.fireEvent(botonAgregarJugador, new ActionEvent());
        }
    }
}
