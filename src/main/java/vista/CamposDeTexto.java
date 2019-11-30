package vista;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CamposDeTexto {

    public TextField textoUno;
    public TextField textoDos;
    public Label etiquetaUno;
    public Label etiquetaDos;

    public CamposDeTexto(String s1, String s2){

        textoUno = new TextField();
        textoUno.setPromptText(s1);
        textoDos = new TextField();
        textoDos.setPromptText(s2);

        etiquetaUno = new Label();
        etiquetaUno.setText(textoUno.getText());
        etiquetaDos = new Label();
        etiquetaDos.setText(textoDos.getText());

    }

}

