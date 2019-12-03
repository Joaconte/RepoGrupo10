package vista.vistaPiezas;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import modelo.pieza.Pieza;
import vista.VistaDeTablero;

public class VistaUnidadParaTablero extends Label {

    VistaDeTablero vistaDeTablero;
    VistaUnidad vistaUnidad;

    public VistaUnidadParaTablero(VistaDeTablero vistaDeTablero){
        super();
        this.vistaDeTablero = vistaDeTablero;
    }

    public void crearVistaEnTablero(ImageView imageView, Pieza unidad, VistaUnidad vistaUnidad){
        this.setGraphic(imageView);
        vistaDeTablero.agregarUnidad(this, vistaUnidad, unidad.getUbicacion().getPosicionEnX(), unidad.getUbicacion().getPosicionEnY() );
    }

    public void setVistaUnidadCompleta (VistaUnidad vistaUnidad){this.vistaUnidad = vistaUnidad;}
    public VistaUnidad getVistaUnidadCompleta(){ return vistaUnidad;}


}
