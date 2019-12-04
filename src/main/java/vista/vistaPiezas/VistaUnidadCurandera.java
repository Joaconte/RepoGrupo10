package vista.vistaPiezas;

import javafx.geometry.Pos;
import modelo.Juego;
import modelo.pieza.Pieza;
import vista.VistaDeTablero;

public class VistaUnidadCurandera extends VistaUnidad {
    public VistaUnidadCurandera(Pieza pieza, VistaDeTablero vistaDeTablero, String nombre, Juego juego) {
        super(pieza, vistaDeTablero, nombre, juego);
        barraDeOpcionesDeUnidad.setAlignment(Pos.CENTER);
        vistaDatos.getChildren().add(etiquetaDeTexto);
        vistaDatos.getChildren().add(barraDeOpcionesDeUnidad);
    }


}
