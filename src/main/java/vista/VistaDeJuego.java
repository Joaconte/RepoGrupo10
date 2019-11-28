package vista;

import controlador.buttonHandlers.TextoEventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import modelo.Juego;

public class VistaDeJuego {

    public VistaDeJuego( Juego juego, VBox vbox){

        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20));

        CamposDeTexto camposDeTexto = new CamposDeTexto();
        BotonAgregarJugadores botonAgregarJugadores = new BotonAgregarJugadores(camposDeTexto , juego, vbox );
        ContenedorBotones contenedorBotones = new ContenedorBotones(camposDeTexto, juego, vbox );

        vbox.getChildren().add(camposDeTexto.textoUno);
        vbox.getChildren().add(camposDeTexto.textoDos);
        vbox.getChildren().add(contenedorBotones);
        vbox.getChildren().add(camposDeTexto.etiquetaUno);
        vbox.getChildren().add(camposDeTexto.etiquetaDos);

        TextoEventHandler textoEventHandler = new TextoEventHandler(botonAgregarJugadores);
        camposDeTexto.textoUno.setOnKeyPressed(textoEventHandler);
        camposDeTexto.textoDos.setOnKeyPressed(textoEventHandler);

    }
}

