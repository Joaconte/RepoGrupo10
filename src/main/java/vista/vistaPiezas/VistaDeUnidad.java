package vista.vistaPiezas;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;
import vista.VistaDeTablero;


public class VistaDeUnidad extends VBox {

    private double escalaDeUnidad = 1;
    protected VistaDeTablero vistaDeTablero;
    public ImageView imagenDeUnidad;
    private Pieza unidad;
    private Ubicacion ubicacion;


    public VistaDeUnidad(String nombre, Pieza unidadAUbicar, VistaDeTablero vistaDeTablero){
        this.vistaDeTablero = vistaDeTablero;
        this.unidad = unidadAUbicar;
        ubicacion = unidadAUbicar.getUbicacion();

        String nombreArch = "resources/"+nombre+".png";
        Image imagen = new Image(nombreArch);
        this.getChildren().add(new ImageView(imagen));
        this.getChildren().add(new Text(nombre.toUpperCase()));
        mostrarAtributos(unidadAUbicar);

    }

    public void mostrarAtributos(Pieza pieza){

        String costo = Integer.toString(pieza.getCosto());
        String vida = Integer.toString(pieza.getVidaMaxima());
        this.getChildren().add(new Text("Costo: " + costo));
        this.getChildren().add(new Text("Vida inicial: " + vida));
        }


    protected void vistaParaTablero (String nombreClase){

        imagenDeUnidad = new ImageView();
        imagenDeUnidad.setScaleX(escalaDeUnidad);
        imagenDeUnidad.setScaleY(escalaDeUnidad);
        imagenDeUnidad.setFitHeight(45);
        imagenDeUnidad.setFitWidth(45);
        if (unidad.getEquipo()==1) imagenDeUnidad.setOpacity(0.7);
        else imagenDeUnidad.setOpacity(0.3);

        String equipo = String.valueOf(unidad.getEquipo());
        imagenDeUnidad.setImage(new Image( "resources/" + nombreClase + equipo +".png"));
    }

}
