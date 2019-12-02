package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Juego;
import vista.VistaDeTablero;
import vista.fases.faseInicial.VistaFaseInicial;

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

        HBox hbox = new HBox();

        vbox.getChildren().add(hbox);

        VistaDeTablero vistaDeTablero = new VistaDeTablero(juego.getTablero());
        hbox.getChildren().add(vistaDeTablero);
        VistaFaseInicial vistaFaseInicial = new VistaFaseInicial( juego, vistaDeTablero, hbox);

    }

}
