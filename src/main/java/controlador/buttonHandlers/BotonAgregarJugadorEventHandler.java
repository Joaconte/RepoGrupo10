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

        this.labelUno.setTextFill(Color.web("#FF0000"));
        String jugadorUno = lectorDeNombres(textFieldUno);
        String jugadorDos = lectorDeNombres(textFieldDos);

        if (jugadorUno.isEmpty() || jugadorDos.isEmpty()) {
            labelUno.setText("Debe ingresar un texto");

        } else if (jugadorUno.equals(jugadorDos)) {
            labelUno.setText("Los jugadores no pueden tener el mismo nombre");

        } else if (jugadorUno.length() > 9 || jugadorDos.length() > 9 ) {
            labelUno.setText("Los nombres de los jugadores no pueden ser mayores a 10 caracteres");

        } else {

            labelUno.setText("El jugador "+ jugadorUno + " se agrego correctamente.");
            labelUno.setTextFill(Color.web("#336600"));
            labelDos.setText("El jugador "+ jugadorDos + " tambien se agrego correctamente.");
            labelDos.setTextFill(Color.web("#336600"));
            juego.agregarJugadores(jugadorUno, jugadorDos);

            if (primeraVez){
                vbox.getChildren().add(new BotonIniciarPartida(juego, stage));
                primeraVez = false;
            }
        }
    }

    public String lectorDeNombres(TextField textField){
        String jugador = textField.getText();
        String primerCaracter = jugador.substring(0,1).toUpperCase();
        String restoCaracteres = jugador.substring(1).toLowerCase();
        return primerCaracter + restoCaracteres;
    }
}
