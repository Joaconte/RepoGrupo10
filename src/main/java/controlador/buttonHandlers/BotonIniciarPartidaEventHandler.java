package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Juego;

public class BotonIniciarPartidaEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;

    public BotonIniciarPartidaEventHandler(Juego juego) {

        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        juego.arrancarPartida();
    }
}
