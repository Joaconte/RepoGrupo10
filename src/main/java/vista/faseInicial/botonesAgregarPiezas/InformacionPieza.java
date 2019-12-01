package vista.faseInicial.botonesAgregarPiezas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.File;

public class InformacionPieza extends VBox {
    public InformacionPieza(String nombre){
        String nombreArch = "resources/"+nombre+".png";
        //File imageFile = new File(nombreArch);
        Image imagen = new Image(nombreArch);
        this.getChildren().add(new ImageView(imagen));
        this.getChildren().add(new Text(nombre.toUpperCase()));
        this.getChildren().add(new Text("Costo: 10"));
    }
}
