package vista.vistaPiezas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import modelo.Juego;
import modelo.pieza.Pieza;
import vista.VistaDeTablero;


public class VistaUnidad extends Label{

    private Pieza pieza;
    protected VistaInformacionDeUnidad vistaDatos;
    protected VistaDeTablero vistaDeTablero;
    protected HBox barraDeOpcionesDeUnidad = new HBox();
    protected Label etiquetaDeTexto = new Label();
    protected Juego juego;
    private  String nombre;

    public VistaUnidad(Pieza pieza, VistaDeTablero vistaDeTablero, String nombre, Juego juego){
        this.juego=juego;
        this.vistaDeTablero= vistaDeTablero;
        this.pieza =pieza;
        this.nombre = nombre;
        vistaDatos = new VistaInformacionDeUnidad (nombre, pieza);
        vistaDatos.vistaDeDatosEnPartida();
        vistaDatos.setAlignment(Pos.CENTER);
    }

    public void crearVistaEnTablero(){
        String equipo = String.valueOf(pieza.getEquipo());
        ImageView avatar = new ImageView( "resources/texturas/" + nombre + equipo +".png");
        avatar.setScaleX(1);
        avatar.setScaleY(1);
        avatar.setFitHeight(45);
        avatar.setFitWidth(45);
        this.setGraphic(avatar);
        vistaDeTablero.agregarUnidad(this, pieza.getUbicacion().getPosicionEnX(), pieza.getUbicacion().getPosicionEnY() );
    }


    public Pieza getPieza() {
        return pieza;
    }

    public VistaInformacionDeUnidad getVistaInformacion() {
        vistaDatos.actualizarDatosEnPartida();
        return vistaDatos;
    }


    public Juego getJuego (){return juego;}

    public void visibilidadDeOpcionesPorTurno(){
        if (juego.estaEnTurno(pieza.getEquipo()))
        barraDeOpcionesDeUnidad.setVisible(true);
        else barraDeOpcionesDeUnidad.setVisible(false);
    }

    public void barraDeOpciones(){
    }
    public void setEtiquetaDeTexto(String mensaje){ etiquetaDeTexto.setText(mensaje);}

}
