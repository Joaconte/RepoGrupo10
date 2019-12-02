package vista;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modelo.Juego;

public class EtiquetaFase {

    public Label etiqueta;

    public EtiquetaFase(String texto){

        etiqueta = new Label();
        etiqueta.setFont(new Font( "Arial", 25));
        etiqueta.setTextFill(Color.web("0A8200"));
        etiqueta.setText(texto);

    }

}