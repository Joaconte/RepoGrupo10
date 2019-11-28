package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Juego;
import vista.VistaDeTablero;

public class BotonIniciarPartidaEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private VBox vbox;
    private Stage stage;

    public BotonIniciarPartidaEventHandler(Juego juego, VBox vbox, Stage stage) {

        this.juego = juego;
        this.vbox = vbox;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        juego.arrancarPartida();
        vbox.getChildren().clear();

        VistaDeTablero vistaDeTablero = new VistaDeTablero(stage, vbox);
        Scene scene = new Scene(vistaDeTablero, 900, 800);
        vistaDeTablero.getChildren().add(vbox);
        stage.setScene(scene);
    }
}
