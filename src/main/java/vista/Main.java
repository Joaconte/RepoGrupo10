package vista;


import controlador.buttonHandlers.TextoEventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
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
        vistaDeJuego = new VistaDeJuego(juego);

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20));

        CamposDeTexto camposDeTexto = new CamposDeTexto();
        BotonAgregarJugadores botonAgregarJugadores = new BotonAgregarJugadores(camposDeTexto , juego );
        ContenedorBotones contenedorBotones = new ContenedorBotones(camposDeTexto, juego );

        vbox.getChildren().add(camposDeTexto.textoUno);
        vbox.getChildren().add(camposDeTexto.textoDos);
        vbox.getChildren().add(contenedorBotones);
        vbox.getChildren().add(camposDeTexto.etiquetaUno);
        vbox.getChildren().add(camposDeTexto.etiquetaDos);

        TextoEventHandler textoEventHandler = new TextoEventHandler(botonAgregarJugadores);
        camposDeTexto.textoUno.setOnKeyPressed(textoEventHandler);
        camposDeTexto.textoDos.setOnKeyPressed(textoEventHandler);

        Scene scene = new Scene(vbox, 400, 250);

        stage.setScene(scene);

        stage.show();

    }

}