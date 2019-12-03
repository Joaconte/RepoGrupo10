package vista.vistaPiezas;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import modelo.pieza.Pieza;
import vista.VistaDeTablero;

public class VistaUnidadParaTablero extends Label {

    VistaDeTablero vistaDeTablero;
    VistaUnidad vistaUnidad;
    VBox informacionUnidad;

    public VistaUnidadParaTablero(VistaDeTablero vistaDeTablero){
        super();
        this.vistaDeTablero = vistaDeTablero;
        this.informacionUnidad = new VBox();
    }

    public void crearVistaEnTablero(ImageView imageView, Pieza unidad, VistaUnidad vistaUnidad){
        this.setGraphic(imageView);
        this.vistaUnidad=vistaUnidad;
        vistaDeTablero.agregarUnidad(this, unidad.getUbicacion().getPosicionEnX(), unidad.getUbicacion().getPosicionEnY() );
    }

    public void setVistaUnidadCompleta (VistaUnidad vistaUnidad){this.vistaUnidad = vistaUnidad;}
    public VistaUnidad getVistaUnidadCompleta(){ return vistaUnidad;}

    public void setInformacionUnidad(){
        this.informacionUnidad.getChildren().clear();
        this.informacionUnidad.getChildren().add(vistaUnidad.getVistaInformacion());
    }
    public VBox getVistaInformacion(){ return informacionUnidad;}


}
