package vista.faseInicial.informacionPiezas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.pieza.Pieza;


public abstract class InformacionPieza extends VBox {

    public InformacionPieza(String nombre){
        String nombreArch = "resources/"+nombre+".png";
        Image imagen = new Image(nombreArch);
        this.getChildren().add(new ImageView(imagen));
        this.getChildren().add(new Text(nombre.toUpperCase()));
    }

    public void mostrarAtributos(Pieza pieza){
        String costo = Integer.toString(pieza.getCosto());
        String vida = Integer.toString(pieza.getVidaMaxima());
        this.getChildren().add(new Text("Costo: " + costo));
        this.getChildren().add(new Text("Puntos de vida: " + vida));
    }

}
