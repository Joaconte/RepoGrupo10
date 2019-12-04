package vista.vistaPiezas;

import javafx.geometry.Pos;
import modelo.Juego;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Curandero;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.botonesFaseMedia.BotonCurar;
import vista.fasesPartida.faseMediaPartida.botonesFaseMedia.BotonMover;

public class VistaUnidadCurandera extends VistaUnidad {
    private Curandero curandero;

    public VistaUnidadCurandera(Curandero pieza, VistaDeTablero vistaDeTablero, String nombre, Juego juego) {
        super(pieza, vistaDeTablero, nombre, juego);
        curandero = pieza;
        barraDeOpcionesDeUnidad.setAlignment(Pos.CENTER);
        vistaDatos.getChildren().add(etiquetaDeTexto);
        vistaDatos.getChildren().add(barraDeOpcionesDeUnidad);
    }

    public void barraDeOpciones() {
        barraDeOpcionesDeUnidad.getChildren().clear();
        etiquetaDeTexto.setText("");
        barraDeOpcionesDeUnidad.getChildren().add(new BotonCurar(curandero, juego, etiquetaDeTexto, vistaDeTablero, barraDeOpcionesDeUnidad));
        barraDeOpcionesDeUnidad.getChildren().add(new BotonMover(curandero.getUbicacion(),juego,etiquetaDeTexto,vistaDeTablero));

    }

    public Curandero getPieza(){
        return curandero;
    }
}
