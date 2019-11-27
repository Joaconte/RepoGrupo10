package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import modelo.Juego;

public class BotonIniciarPartidaEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private VBox vbox;

    public BotonIniciarPartidaEventHandler(Juego juego, VBox vbox) {

        this.juego = juego;
        this.vbox = vbox;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        juego.arrancarPartida();
        vbox.getChildren().clear();
    }
}
