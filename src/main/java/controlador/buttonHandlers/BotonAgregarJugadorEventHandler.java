package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modelo.Juego;
import vista.faseBienvenida.BotonIniciarPartida;

public class BotonAgregarJugadorEventHandler implements EventHandler<ActionEvent> {

    private TextField textFieldUno;
    private TextField textFieldDos;
    private Label labelUno;
    private Label labelDos;
    private Juego juego;
    private VBox vbox;
    private Stage stage;
    private boolean primeraVez;

    public BotonAgregarJugadorEventHandler(TextField textoUno, TextField textoDos, Label etiquetaUno, Label etiquetaDos, Juego juego, VBox vbox, Stage stage) {
        textFieldUno = textoUno ;
        textFieldDos = textoDos;
        labelUno = etiquetaUno;
        labelDos = etiquetaDos;
        this.juego = juego;
        this.vbox = vbox;
        this.stage = stage;
        primeraVez=true;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (this.textFieldUno.getText().trim().equals("") || this.textFieldDos.getText().trim().equals("")) {

            this.labelUno.setText("Debe ingresar un texto");
            this.labelUno.setTextFill(Color.web("#FF0000"));

        } else {

            String jugadorUno = this.textFieldUno.getText();
            String jugadorDos = this.textFieldDos.getText();
            this.labelUno.setText("El jugador "+ jugadorUno + " se agrego correctamente.");
            this.labelUno.setTextFill(Color.web("#336600"));
            this.labelDos.setText("El jugador "+ jugadorDos + " tambien se agrego correctamente.");
            this.labelDos.setTextFill(Color.web("#336600"));
            juego.agregarJugadores(jugadorUno, jugadorDos);

            if (primeraVez){
                vbox.getChildren().add(new BotonIniciarPartida(juego, stage));
                primeraVez = false;
            }
        }
    }
}
