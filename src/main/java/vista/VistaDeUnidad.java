package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;


public class VistaDeUnidad {

    private double escalaDeUnidad = 1;
    private VistaDeTablero stage;
    public ImageView imagenDeUnidad;

    private Pieza unidad;
    private Ubicacion ubicacion;

    private int ultimaPosicionX;


    public VistaDeUnidad(VistaDeTablero stage, Pieza unidad, String nombreClase) {

        this.stage = stage;
        this.unidad = unidad;
        ubicacion = unidad.getUbicacion();

        this.ultimaPosicionX = unidad.getUbicacion().getPosicionEnX();

        //NO ME FUNCA unidad.addObserver( this);

        imagenDeUnidad = new ImageView();
        imagenDeUnidad.setScaleX(escalaDeUnidad);
        imagenDeUnidad.setScaleY(escalaDeUnidad);
        imagenDeUnidad.setFitHeight(45);
        imagenDeUnidad.setFitWidth(45);

        imagenDeUnidad.setImage(new Image(nombreClase +".png"));
        stage.agregarUnidad(imagenDeUnidad, ubicacion.getPosicionEnX(), ubicacion.getPosicionEnY() );
        //draw();
    }

}
