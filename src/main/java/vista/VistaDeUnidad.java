package vista;


import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;


public class VistaDeUnidad extends VBox {

    private double escalaDeUnidad = 1;
    private VistaDeTablero vistaDeTablero;
    public ImageView imagenDeUnidad;
    private Pieza unidad;
    private Ubicacion ubicacion;



    public VistaDeUnidad(VistaDeTablero vistaDeTablero, Pieza unidadAUbicar, String nombreClase) {

        this.vistaDeTablero = vistaDeTablero;
        this.unidad = unidadAUbicar;
        ubicacion = unidadAUbicar.getUbicacion();
        crearVistaParaTablero(nombreClase);

        //this.getChildren().add(imagenDeUnidad);
        this.getChildren().add(new Label("Unidad de Jugador " + unidad.getEquipo() ));
        this.getChildren().add(new Label("Columna: " + unidad.getUbicacion().getPosicionEnX() ));
        this.getChildren().add(new Label("Fila " + unidad.getUbicacion().getPosicionEnY() ));
        this.getChildren().add((new Label("Vida restante: " + unidad.getPuntosVida())));

        //unidad.addObserver( this );
        //draw();
    }

    private Pieza getUnidad(){ return unidad; }

    private void crearVistaParaTablero (String nombreClase){

        imagenDeUnidad = new ImageView();
        imagenDeUnidad.setScaleX(escalaDeUnidad);
        imagenDeUnidad.setScaleY(escalaDeUnidad);
        imagenDeUnidad.setFitHeight(45);
        imagenDeUnidad.setFitWidth(45);
        if (unidad.getEquipo()==1) imagenDeUnidad.setOpacity(0.7);
        else imagenDeUnidad.setOpacity(0.3);

        String equipo = String.valueOf(unidad.getEquipo());
        imagenDeUnidad.setImage(new Image( "resources/" + nombreClase + equipo +".png"));

        vistaDeTablero.agregarUnidad(imagenDeUnidad, this, ubicacion.getPosicionEnX(), ubicacion.getPosicionEnY() );
    }

}
