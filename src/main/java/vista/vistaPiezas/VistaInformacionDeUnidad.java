package vista.vistaPiezas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.pieza.Pieza;


public class VistaInformacionDeUnidad extends VBox {


    private Pieza pieza;
    public ImageView imagenDeUnidad;
    private VBox datosActualizables=new VBox();


    public VistaInformacionDeUnidad(String nombre, Pieza unidad){

        this.pieza = unidad;
        String nombreArch = "resources/texturas/"+nombre+".png";
        Image imagen = new Image(nombreArch);
        this.imagenDeUnidad = new ImageView(imagen);
        this.getChildren().add(imagenDeUnidad);
        this.getChildren().add(new Text(nombre.toUpperCase()));
        this.getChildren().add(new Text("Costo: " + unidad.getCosto()));
        this.getChildren().add(new Text("Vida inicial: " + unidad.getVidaMaxima()));

    }

    public void vistaDeDatosEnPartida(){
        actualizarDatosEnPartida();
        this.getChildren().add(datosActualizables);
    }

    public void actualizarDatosEnPartida(){
        datosActualizables.getChildren().clear();
        datosActualizables.setAlignment(Pos.CENTER);
        datosActualizables.getChildren().add(new Label("Unidad de Jugador " + pieza.getEquipo() ));
        datosActualizables.getChildren().add(new Label("Columna: " + pieza.getPosicionEnColumnaQueOcupa() ));
        datosActualizables.getChildren().add(new Label("Fila " +  pieza.getPosicionEnFilaQueOcupa() ));
        datosActualizables.getChildren().add((new Label("Vida restante: " + pieza.getPuntosVida())));
    }



}
