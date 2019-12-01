package vista.faseBienvenida;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.Juego;


public class ContenedorBienvenida extends BorderPane {

    public ContenedorBienvenida(Stage escenarioPrincipal, Juego juego) {

        this.setCentro(juego, escenarioPrincipal);
        this.setArriba();

    }

    private void setCentro(Juego juego, Stage escenarioPrincipal) {
        VBox menuVerticalDeInicio = new MenuCargaJugadores(juego, escenarioPrincipal);
        this.setCenter(menuVerticalDeInicio);
    }

    private void setArriba(){
        Label etiqueta = new Label("Bienvenido a AlgoChess");
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 28));
        etiqueta.textAlignmentProperty();
        this.setTop(etiqueta);


    }
}