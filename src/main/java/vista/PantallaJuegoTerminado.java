package vista;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Juego;


public class PantallaJuegoTerminado extends BorderPane {

    public PantallaJuegoTerminado (Juego juego, Stage escenarioPrincipal, String string){
        Text etiquetaGanador = new Text ("¡Juego terminado! " + string + " mira la pantalla en blanco");
        HBox nuevoHBox = new HBox();
        nuevoHBox.setAlignment(Pos.CENTER);
        nuevoHBox.getChildren().add(etiquetaGanador);
        this.setCenter(etiquetaGanador);


    }
}
