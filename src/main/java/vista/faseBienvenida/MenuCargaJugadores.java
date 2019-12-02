package vista.faseBienvenida;

import controlador.buttonHandlers.TextoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Juego;
import vista.CamposDeTexto;


public class MenuCargaJugadores extends VBox {

    private CamposDeTexto camposDeTexto;

    public MenuCargaJugadores(Juego juego, Stage escenarioPrincipal){


        this.camposDeTexto = new CamposDeTexto("Ingrese un jugador", "Ingrese otro jugador");
        this.setWidth(200);
        this.setSpacing(10);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        this.agregarBotoneria(juego, escenarioPrincipal);
    }

    private void agregarBotoneria(Juego juego, Stage escenarioPrincipal){

        BotonAgregarJugadores botonAgregarJugadores = new BotonAgregarJugadores(camposDeTexto, juego, this, escenarioPrincipal);

        this.getChildren().add(camposDeTexto.textoUno);
        this.getChildren().add(camposDeTexto.textoDos);
        this.getChildren().add(botonAgregarJugadores);
        this.getChildren().add(camposDeTexto.etiquetaUno);
        this.getChildren().add(camposDeTexto.etiquetaDos);

        TextoEventHandler textoEventHandler = new TextoEventHandler(botonAgregarJugadores);
        camposDeTexto.textoUno.setOnKeyPressed(textoEventHandler);
        camposDeTexto.textoDos.setOnKeyPressed(textoEventHandler);
    }
}

