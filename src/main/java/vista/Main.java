package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import modelo.Juego;

public class Main extends Application {


    private VistaDeJuego vistaDeJuego;

    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle( "Juego X" );

        Juego juego = new Juego();
        VBox vbox = new VBox();

        vistaDeJuego = new VistaDeJuego( juego, vbox, stage );

        Scene scene = new Scene(vbox, 925, 785);

        stage.setScene(scene);

        stage.show();

    }

}