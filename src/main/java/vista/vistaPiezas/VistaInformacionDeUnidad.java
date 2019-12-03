package vista.vistaPiezas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;


public class VistaInformacionDeUnidad extends VBox {


    private Pieza unidad;


    public VistaInformacionDeUnidad(String nombre, Pieza unidadAUbicar){

        this.unidad = unidadAUbicar;

        String nombreArch = "resources/"+nombre+".png";
        Image imagen = new Image(nombreArch);

        this.getChildren().add(new ImageView(imagen));
        this.getChildren().add(new Text(nombre.toUpperCase()));
        this.getChildren().add(new Text("Costo: " + unidad.getCosto()));
        this.getChildren().add(new Text("Vida inicial: " + (int)unidad.getVidaMaxima()));

    }




}
