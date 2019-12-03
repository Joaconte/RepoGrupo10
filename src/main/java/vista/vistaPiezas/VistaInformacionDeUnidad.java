package vista.vistaPiezas;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.pieza.Pieza;


public class VistaInformacionDeUnidad extends VBox {


    private Pieza pieza;
    private String nombre;
    public ImageView imagenDeUnidad;
    private double escalaDeUnidad = 1;
    private ImageView avatar;


    public VistaInformacionDeUnidad(String nombre, Pieza unidad){

        this.pieza = unidad;
        this.nombre = nombre;

        String nombreArch = "resources/texturas/"+nombre+".png";
        Image imagen = new Image(nombreArch);
        this.imagenDeUnidad = new ImageView(imagen);
        this.getChildren().add(imagenDeUnidad);
        this.getChildren().add(new Text(nombre.toUpperCase()));
        this.getChildren().add(new Text("Costo: " + unidad.getCosto()));
        this.getChildren().add(new Text("Vida inicial: " + (int)unidad.getVidaMaxima()));

    }

    public void vistaDeDatosEnPartida(){
        this.getChildren().add(new Label("Unidad de Jugador " + pieza.getEquipo() ));
        this.getChildren().add(new Label("Columna: " + pieza.getUbicacion().getPosicionEnX() ));
        this.getChildren().add(new Label("Fila " +  pieza.getUbicacion().getPosicionEnY() ));
        this.getChildren().add((new Label("Vida restante: " + pieza.getPuntosVida())));
    }

    public void avatarIdentificativo(){
        String equipo = String.valueOf(pieza.getEquipo());
        ImageView avatar = new ImageView( "resources/texturas/" + nombre + equipo +".png");
        avatar.setScaleX(escalaDeUnidad);
        avatar.setScaleY(escalaDeUnidad);
        avatar.setFitHeight(45);
        avatar.setFitWidth(45);
        this.avatar = avatar;
    }

    public ImageView getAvatar(){ return avatar;}


}
