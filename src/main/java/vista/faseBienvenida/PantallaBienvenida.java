package vista.faseBienvenida;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.Juego;


public class PantallaBienvenida extends BorderPane {

    public PantallaBienvenida(Stage escenarioPrincipal, Juego juego) {
        escenarioPrincipal.setResizable(false);
        this.setCentro(juego, escenarioPrincipal);
        this.setArriba();
        Image imangenMuro = new Image("resources/texturas/muro.png");
        Background fondoDeContenedor = new Background(new BackgroundImage(imangenMuro,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(90, 90, false, false, false, false)));
        this.setBackground(fondoDeContenedor);

    }

    private void setCentro(Juego juego, Stage escenarioPrincipal) {
        VBox menuVerticalDeInicio = new MenuCargaJugadores(juego, escenarioPrincipal);
        menuVerticalDeInicio.setMaxWidth(440);
        this.setCenter(menuVerticalDeInicio);
    }

    private void setArriba(){
        StackPane barraArriba = new StackPane();
        Rectangle rectangle = new Rectangle(500,150, Color.rgb(20,4,247,0.01));
        barraArriba.setAlignment(Pos.CENTER);
        barraArriba.setMaxHeight(300);

        Label etiqueta = new Label ("AlgoChess");
        etiqueta.setAlignment(Pos.CENTER);
        etiqueta.setFont(Font.font("tahoma", FontWeight.EXTRA_BOLD, 48));
        etiqueta.setTextFill(Color.rgb(255,255,255,0.8));

        barraArriba.getChildren().add(rectangle);
        barraArriba.getChildren().add(etiqueta);

        this.setTop(barraArriba);
        this.getTop().setScaleY(2);


    }
}