package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.pieza.Pieza;
import modelo.pieza.observer.Observer;

public class VistaDeUnidad implements Observer, Drawable {

    private double escalaDeUnidad = 1;
    private VistaDeTablero stage;
    ImageView imagenDeUnidad;

    private Pieza unidad;

    private int ultimaPosicionX;


    public VistaDeUnidad(VistaDeTablero stage, Pieza unidad) {

        this.stage = stage;
        this.unidad = unidad;

        this.ultimaPosicionX = unidad.getUbicacion().getPosicionEnX();
        unidad.addObserver((java.util.Observer) this);

        imagenDeUnidad = new ImageView();
        imagenDeUnidad.setScaleX(escalaDeUnidad);
        imagenDeUnidad.setScaleY(escalaDeUnidad);
        imagenDeUnidad.setFitHeight(45);
        imagenDeUnidad.setFitWidth(45);

        imagenDeUnidad.setImage(new Image("unidad.png"));
        stage.addViewOnMap(imagenDeUnidad, unidad.getUbicacion().getPosicionEnX(), unidad.getUbicacion().getPosicionEnY());
        draw();
    }

    @Override
    public void draw() {
        imagenDeUnidad.setTranslateX(0);
        imagenDeUnidad.setTranslateY(0);
        stage.updateView(imagenDeUnidad);
    }

    @Override
    public void change() {

        int actualX = unidad.getUbicacion().getPosicionEnX();
        int actualY = unidad.getUbicacion().getPosicionEnY();
        if (ultimaPosicionX > actualX) {
            this.imagenDeUnidad.setScaleX( -
                    Math.abs(imagenDeUnidad.getScaleX()));
        }

        else if (ultimaPosicionX < actualX) {
            this.imagenDeUnidad.setScaleX(
                    Math.abs(imagenDeUnidad.getScaleX()));
        }
        this.ultimaPosicionX =unidad.getUbicacion().getPosicionEnX();
        stage.addViewOnMap(this.imagenDeUnidad, actualX, actualY);
    }

}
