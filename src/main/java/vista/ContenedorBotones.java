package vista;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Juego;


public class ContenedorBotones extends HBox {

    public ContenedorBotones(CamposDeTexto camposDeTexto, Juego juego, VBox vbox, Stage stage){

        super();
        setHeight(20);
        this.getChildren().add( new BotonAgregarJugadores(camposDeTexto, juego, vbox, stage ) );
    }

}
