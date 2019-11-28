package vista;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;



public class VistaDeTablero extends Group {

    public VistaDeTablero(Stage stage, VBox vbox){

        Image image = new Image("tablero.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        vbox.getChildren().add(imageView);

        stage.sizeToScene();
    }
}
