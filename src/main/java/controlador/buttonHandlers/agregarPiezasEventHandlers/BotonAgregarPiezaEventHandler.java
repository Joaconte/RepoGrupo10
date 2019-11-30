package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Infanteria;
import vista.VistaDeTablero;
import vista.VistaDeUnidad;
import vista.faseInicial.EtiquetaPuntosJugador;

public abstract class BotonAgregarPiezaEventHandler implements EventHandler<ActionEvent> {

    private TextField textFieldUno;
    private TextField textFieldDos;
    private Label labelUno;
    private VistaDeTablero vistaDeTablero;
    protected EtiquetaPuntosJugador etiquetaPuntos;

    public void initialize(TextField textoUno, TextField textoDos, Label etiquetaUno, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos) {

        textFieldUno = textoUno;
        textFieldDos = textoDos;
        labelUno = etiquetaUno;
        this.vistaDeTablero = vistaDeTablero;
        this.etiquetaPuntos= etiquetaPuntos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.textFieldUno.getText().trim().equals("") || this.textFieldDos.getText().trim().equals("")) {

            this.labelUno.setText("Debe ingresar ambas coordenadas");
            this.labelUno.setTextFill(Color.web("#FF0000"));

        } else {

            try {
                String sX = this.textFieldUno.getText();
                String sY = this.textFieldDos.getText();
                int x = Integer.parseInt(sX);
                int y = Integer.parseInt(sY);
                crearPiezaYAgregarATablero(x, y, vistaDeTablero);
                etiquetaPuntos.actualizarEtiqueta();
            }

            catch (NumberFormatException e){
                this.labelUno.setText("Debe ingresar numeros");
                this.labelUno.setTextFill(Color.web("#FF0000"));
            }

        }
    }

    public void crearPiezaYAgregarATablero(int x, int y, VistaDeTablero vistaDeTablero){ }

}