package vista.faseBienvenida;

import controlador.buttonHandlers.TextoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.Juego;


public class MenuCargaJugadores extends VBox {

    private TextField textoUno;
    private TextField textoDos;
    private Label etiquetaUno;
    private Label etiquetaDos;

    public MenuCargaJugadores(Juego juego, Stage escenarioPrincipal){

        textoUno = new TextField();
        textoDos = new TextField();
        etiquetaUno = new Label();
        etiquetaDos = new Label();


        this.setSpacing(10);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        this.agregarBotoneria(juego, escenarioPrincipal);
    }



    private void agregarBotoneria(Juego juego, Stage escenarioPrincipal){
        textoUno.setPromptText("Ingrese un jugador");
        textoDos.setPromptText("Ingrese otro jugador");
        etiquetaUno.setText(textoUno.getText());
        etiquetaDos.setText(textoDos.getText());
        BotonAgregarJugadores botonAgregarJugadores = new BotonAgregarJugadores(juego, this, escenarioPrincipal);

        this.getChildren().addAll(textoUno, textoDos, botonAgregarJugadores, etiquetaUno, etiquetaDos);
        TextoEventHandler textoEventHandler = new TextoEventHandler(botonAgregarJugadores);
        textoUno.setOnKeyPressed(textoEventHandler);
        textoDos.setOnKeyPressed(textoEventHandler);
    }

    public void vistaComunicadorUno(String texto, String color){
        etiquetaUno.setTextFill(Paint.valueOf(color));
        etiquetaUno.setText(texto);
        etiquetaUno.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD,15));
    }

    public void vistaComunicadorDos(String texto, String color){
        etiquetaDos.setTextFill(Paint.valueOf(color));
        etiquetaDos.setText(texto);
        etiquetaDos.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD,15));
    }

    public String getCargadoEnTextoUno(){
        return textoUno.getText();
    }

    public String getCargadoEnTextoDos() {
        return textoDos.getText();
    }
}

