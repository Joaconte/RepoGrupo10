package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import modelo.Juego;
import resources.sonidos.Audio;
import vista.fasesPartida.faseInicialPartida.PantallaFaseInicialPartida;

public class BotonIniciarPartidaEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Stage escenarioPrincipal;

    public BotonIniciarPartidaEventHandler(Juego juego, Stage escenarioPrincipal) {

        this.juego = juego;
        this.escenarioPrincipal = escenarioPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        PantallaFaseInicialPartida pantallaFaseInicialPartida = new PantallaFaseInicialPartida(juego, escenarioPrincipal);
        ScrollPane barras = new ScrollPane(pantallaFaseInicialPartida);
        Scene escenaFaseInicial = new Scene (barras);
        escenarioPrincipal.setScene(escenaFaseInicial);
        escenarioPrincipal.setResizable(true);
        Audio.reproducirClick();
    }

}
