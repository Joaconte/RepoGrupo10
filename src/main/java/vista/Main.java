package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import modelo.Juego;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage escenarioPrincipal) {
        escenarioPrincipal.setTitle( "Juego AlgoChess" );
        Juego juego = new Juego();
        VBox contenedorVertical = new VBox();
        VistaDeJuego vistaDeJuego = new VistaDeJuego( juego, contenedorVertical, escenarioPrincipal );

        ScrollPane panelConBarrasDeMovimiento = new ScrollPane();
        panelConBarrasDeMovimiento.setContent(contenedorVertical);
        panelConBarrasDeMovimiento.setPrefSize(1200,950);

        Scene escenaDeJuego = new Scene(panelConBarrasDeMovimiento, 1200, 950);
        escenarioPrincipal.setScene(escenaDeJuego);
        escenarioPrincipal.show();

    }

}