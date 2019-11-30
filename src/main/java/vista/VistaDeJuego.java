package vista;

import controlador.buttonHandlers.TextoEventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Juego;

public class VistaDeJuego {

    public VistaDeJuego( Juego juego, VBox contenedorVertical, Stage escenarioPrincipal){

        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(20));

        CamposDeTexto camposDeTexto = new CamposDeTexto("Ingrese un jugador", "Ingrese otro jugador");
        BotonAgregarJugadores botonAgregarJugadores = new BotonAgregarJugadores(camposDeTexto , juego, contenedorVertical, escenarioPrincipal );
        ContenedorBotones contenedorBotones = new ContenedorBotones(camposDeTexto, juego, contenedorVertical, escenarioPrincipal );

        contenedorVertical.getChildren().add(camposDeTexto.textoUno);
        contenedorVertical.getChildren().add(camposDeTexto.textoDos);
        contenedorVertical.getChildren().add(contenedorBotones);
        contenedorVertical.getChildren().add(camposDeTexto.etiquetaUno);
        contenedorVertical.getChildren().add(camposDeTexto.etiquetaDos);

        TextoEventHandler textoEventHandler = new TextoEventHandler(botonAgregarJugadores);
        camposDeTexto.textoUno.setOnKeyPressed(textoEventHandler);
        camposDeTexto.textoDos.setOnKeyPressed(textoEventHandler);


    }
}

