package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Infanteria;
import vista.VistaDeTablero;
import vista.VistaDeUnidad;

public abstract class BotonAgregarPiezaEventHandler implements EventHandler<ActionEvent> {

    private TextField textFieldUno;
    private TextField textFieldDos;
    private Label labelUno;
    private VistaDeTablero vistaDeTablero;

    public void initialize(TextField textoUno, TextField textoDos, Label etiquetaUno, VistaDeTablero vistaDeTablero) {

        textFieldUno = textoUno;
        textFieldDos = textoDos;
        labelUno = etiquetaUno;
        this.vistaDeTablero = vistaDeTablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.textFieldUno.getText().trim().equals("") || this.textFieldDos.getText().trim().equals("")) {

            this.labelUno.setText("Debe ingresar ambas coordenadas");
            this.labelUno.setTextFill(Color.web("#FF0000"));

        } else {

            String sX = this.textFieldUno.getText();
            String sY = this.textFieldDos.getText();
            int x = Integer.parseInt(sX);
            int y = Integer.parseInt(sY);
            crearPiezaYAgregarATablero(x, y, vistaDeTablero);

        }
    }

    public void crearPiezaYAgregarATablero(int x, int y, VistaDeTablero vistaDeTablero){ }

}