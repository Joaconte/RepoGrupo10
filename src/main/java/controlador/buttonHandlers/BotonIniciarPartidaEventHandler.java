package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import modelo.Juego;
import vista.fasePartida.faseInicialPartida.ContenedorFaseInicialPartida;

public class BotonIniciarPartidaEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Stage escenarioPrincipal;

    public BotonIniciarPartidaEventHandler(Juego juego, Stage escenarioPrincipal) {

        this.juego = juego;
        this.escenarioPrincipal = escenarioPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        juego.arrancarPartida();

        ContenedorFaseInicialPartida contenedorFaseInicialPartida = new ContenedorFaseInicialPartida(juego, escenarioPrincipal);
        ScrollPane panelConBarrasDeMovimiento = new ScrollPane();
        panelConBarrasDeMovimiento.setContent(contenedorFaseInicialPartida);
        panelConBarrasDeMovimiento.setPrefSize(1200,900);
        Scene escenaFaseInicial = new Scene (panelConBarrasDeMovimiento, 1200,950);

        escenarioPrincipal.setScene(escenaFaseInicial);

    }

}
