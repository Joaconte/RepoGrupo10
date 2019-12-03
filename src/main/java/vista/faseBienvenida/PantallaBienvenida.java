package vista.faseBienvenida;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.Juego;
import resources.sonidos.Audio;


public class PantallaBienvenida extends BorderPane {

    public PantallaBienvenida(Stage escenarioPrincipal, Juego juego) {
        this.setCentro(juego, escenarioPrincipal);
        this.setArriba();

    }

    private void setCentro(Juego juego, Stage escenarioPrincipal) {
        VBox menuVerticalDeInicio = new MenuCargaJugadores(juego, escenarioPrincipal);
        this.setCenter(menuVerticalDeInicio);
    }

    private void setArriba(){
        StackPane barraArriba = new StackPane();
        Rectangle rectangle = new Rectangle(400,100, Color.rgb(37,21,226,0.1));
        barraArriba.setAlignment(Pos.CENTER);

        barraArriba.getChildren().add(rectangle);
        Label etiqueta = new Label("Bienvenido a AlgoChess");
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 28));
        etiqueta.setAlignment(Pos.CENTER);
        barraArriba.getChildren().add(etiqueta);
        this.setTop(barraArriba);


    }
}