package vista.vistaPiezas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import modelo.Juego;
import modelo.pieza.Pieza;
import vista.VistaDeTablero;


public class VistaUnidad extends Label{

    protected Pieza pieza;
    protected VistaInformacionDeUnidad vistaDatos;
    protected VistaDeTablero vistaDeTablero;
    protected VBox barraDeOpcionesDeUnidad = new VBox();
    protected Juego juego;
    private String nombre;
    private  ImageView avatar;

    public VistaUnidad(Pieza pieza, VistaDeTablero vistaDeTablero, String nombre, Juego juego){
        this.juego=juego;
        this.vistaDeTablero= vistaDeTablero;
        this.pieza =pieza;
        this.nombre = nombre;
        vistaDatos = new VistaInformacionDeUnidad (nombre, pieza);
        vistaDatos.vistaDeDatosEnPartida();
        vistaDatos.setAlignment(Pos.CENTER);
        vistaDatos.setPadding(new Insets(40,1,1,1));
    }

    public void crearVistaEnTablero(){
        String equipo = String.valueOf(pieza.getEquipo());
        avatar = new ImageView( "resources/texturas/" + nombre + equipo +".png");
        avatar.setScaleX(1);
        avatar.setScaleY(1);
        avatar.setFitHeight(45);
        avatar.setFitWidth(45);
        this.setGraphic(avatar);
        vistaDeTablero.agregarUnidad(this, pieza.getPosicionEnColumnaQueOcupa(), pieza.getPosicionEnFilaQueOcupa() );
    }

    public ImageView getMiniAvatar(){
        avatar.setScaleX(1);
        avatar.setScaleY(1);
        avatar.setFitHeight(27);
        avatar.setFitWidth(27);
        return avatar;}

    public Pieza getPieza() {
        return pieza;
    }

    public Boolean getEstaMuerta() {return pieza.estaMuerta();}

    public String getNombre(){return nombre;}

    public int getEquipo(){ return pieza.getEquipo();}

    public VistaInformacionDeUnidad getVistaInformacion() {
        vistaDatos.actualizarDatosEnPartida();
        return vistaDatos;
    }

    public Juego getJuego (){return juego;}

    public void actualizacionVistaDeOpciones(){
        if (juego.estaEnTurno(pieza.getEquipo()))
        barraDeOpcionesDeUnidad.setVisible(true);
        else barraDeOpcionesDeUnidad.setVisible(false);
    }

    public void barraDeOpciones(){
    }

    public void barraDeOpcionesNoVisible(){
        barraDeOpcionesDeUnidad.setVisible(false);
    }

    public int getPosicionX() { return pieza.getPosicionEnColumnaQueOcupa();
    }

    public int getPosicionY() {return pieza.getPosicionEnFilaQueOcupa();
    }
}
