package vista.fasesPartida.faseMediaPartida;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import vista.CamposDeTexto;
import vista.VistaDeTablero;


public class BarraDeJugador extends VBox {

    private Rectangle fondoDeNombreJugador = new Rectangle(300,45,Color.rgb(0,0,0,0.1));

    public BarraDeJugador(String nombreDeJugador) {

        this.setSpacing(15);
        grabarNombre(nombreDeJugador);

    }

    public void grabarNombre (String nombreDeJugador){
        Label etiqueta = new Label();
        etiqueta.setFont(new Font( "Arial", 15));
        etiqueta.setTextFill(Color.web("FF821F"));
        etiqueta.setText(" Jugador: " + nombreDeJugador);
        etiqueta.setAlignment(Pos.CENTER);

        StackPane panelNombre = new StackPane();
        panelNombre.getChildren().add(fondoDeNombreJugador);
        panelNombre.getChildren().add(etiqueta);
        this.getChildren().add(panelNombre);

    }

    public void invertirEstadoDeshabilitado(){
        if (this.isDisable()) this.setDisable(false);
        else this.setDisable(true);
    }


}
