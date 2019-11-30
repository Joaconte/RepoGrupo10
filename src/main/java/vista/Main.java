package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import modelo.Juego;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle( "Juego X" );

        Juego juego = new Juego();
        VBox vbox = new VBox();

        VistaDeJuego vistaDeJuego = new VistaDeJuego( juego, vbox, stage );

        Scene scene = new Scene(vbox, 1200, 950);
        stage.setScene(scene);
        stage.show();

    }

}