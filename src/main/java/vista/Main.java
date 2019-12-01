package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import modelo.Juego;
import vista.faseBienvenida.ContenedorBienvenida;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage escenarioPrincipal) {

        escenarioPrincipal.setTitle( "Juego AlgoChess" );
        Juego juego = new Juego();

        ContenedorBienvenida contenedorBienvenida = new ContenedorBienvenida(escenarioPrincipal, juego);

        ScrollPane panelConBarrasDeMovimiento = new ScrollPane();
        panelConBarrasDeMovimiento.setContent(contenedorBienvenida);
        panelConBarrasDeMovimiento.setPrefSize(1200,900);

        Scene escenaDeJuego = new Scene(panelConBarrasDeMovimiento, 1200, 950);

        escenarioPrincipal.setScene(escenaDeJuego);
        escenarioPrincipal.show();

    }

}