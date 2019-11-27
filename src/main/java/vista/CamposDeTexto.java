package vista;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CamposDeTexto {

    TextField textoUno;
    TextField textoDos;
    Label etiquetaUno;
    Label etiquetaDos;

    public CamposDeTexto(){

        textoUno = new TextField();
        textoUno.setPromptText("Ingrese un jugador");
        textoDos = new TextField();
        textoDos.setPromptText("Ingrese otro jugador");

        etiquetaUno = new Label();
        etiquetaUno.setText(textoUno.getText());
        etiquetaDos = new Label();
        etiquetaDos.setText(textoDos.getText());

    }

}
