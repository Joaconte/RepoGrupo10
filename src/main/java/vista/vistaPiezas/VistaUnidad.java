package vista.vistaPiezas;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import modelo.pieza.Pieza;

public class VistaUnidad extends Label {

    private double escalaDeUnidad = 1;
    public ImageView imagenDeUnidad;
    Pieza pieza;
    VBox info = new VBox();

    public VistaUnidad(){
        super();
        imagenDeUnidad = new ImageView();
        imagenDeUnidad.setScaleX(escalaDeUnidad);
        imagenDeUnidad.setScaleY(escalaDeUnidad);
        imagenDeUnidad.setFitHeight(45);
        imagenDeUnidad.setFitWidth(45);
    }

    public void crearImagenPersonalizada(String nombreClase, Pieza pieza){

        String equipo = String.valueOf(pieza.getEquipo());
        imagenDeUnidad.setImage(new Image( "resources/" + nombreClase + equipo +".png"));
        this.setGraphic(imagenDeUnidad);
    }

     public void setPieza (Pieza pieza){this.pieza = pieza;}
     public Pieza getPieza(){ return pieza;}
     public VBox getVistaInformacion(){return info;}

}
