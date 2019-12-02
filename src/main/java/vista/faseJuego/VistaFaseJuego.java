package vista.faseJuego;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Juego;
import vista.EtiquetaFase;
import vista.faseInicial.EtiquetaTurnoJugador;

public class VistaFaseJuego {

    public VistaFaseJuego(Juego juego, HBox contenedorHorizontal){

        VBox contenedorVertical = new VBox();
        contenedorVertical.setSpacing(5);

        EtiquetaFase etiquetaFase = new EtiquetaFase("Fase de ataques");
        EtiquetaTurnoJugador etiquetaTurnoJugador = new EtiquetaTurnoJugador( juego );

        contenedorHorizontal.getChildren().add(contenedorVertical);
        contenedorVertical.getChildren().addAll(etiquetaFase.etiqueta, etiquetaTurnoJugador.etiqueta);


    }


}
