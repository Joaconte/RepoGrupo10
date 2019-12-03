package vista.vistaPiezas;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import modelo.pieza.Pieza;
import vista.VistaDeTablero;

public class VistaUnidad {

    private Pieza pieza;
    VistaInformacionDeUnidad vistaDatos;
    VistaDeTablero vistaDeTablero;

    public VistaUnidad(Pieza pieza, VistaDeTablero vistaDeTablero, String nombre){
        this.vistaDeTablero= vistaDeTablero;
        this.pieza =pieza;
        vistaDatos = new VistaInformacionDeUnidad (nombre, pieza);
        vistaDatos.avatarIdentificativo();
        vistaDatos.vistaDeDatosEnPartida();
        vistaDatos.setAlignment(Pos.CENTER);
        VistaUnidadParaTablero vistaEnTablero = new VistaUnidadParaTablero(vistaDeTablero);
        vistaEnTablero.crearVistaEnTablero(vistaDatos.getAvatar(),pieza,this);
    }

    public Pieza getPieza() {
        return pieza;
    }
    public VBox getVistaInformacion() {
        return vistaDatos;
    }
}
