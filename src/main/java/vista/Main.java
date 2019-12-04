package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import modelo.Juego;
import resources.sonidos.Audio;
import vista.faseBienvenida.PantallaBienvenida;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage escenarioPrincipal) {

        escenarioPrincipal.setTitle( "Juego AlgoChess" );
        Juego juego = new Juego();

        PantallaBienvenida pantallaBienvenida = new PantallaBienvenida(escenarioPrincipal, juego);

        //Audio.reproducirIntro();
        Audio.reproducirMusica("intro");

        Scene escenaDeJuego = new Scene(pantallaBienvenida, 500, 500);
        escenarioPrincipal.setScene(escenaDeJuego);
        escenarioPrincipal.show();

    }

}