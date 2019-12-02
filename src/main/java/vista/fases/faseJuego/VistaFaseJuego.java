package vista.fases.faseJuego;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Juego;
import modelo.pieza.Ubicacion;
import vista.CamposDeTexto;
import vista.EtiquetaFase;
import vista.VistaDeTablero;
import vista.fases.faseInicial.EtiquetaTurnoJugador;
import vista.fases.faseInicial.botonesMoverEnTablero.BotonMoverAbajo;
import vista.fases.faseInicial.botonesMoverEnTablero.BotonMoverArriba;
import vista.fases.faseInicial.botonesMoverEnTablero.BotonMoverDerecha;
import vista.fases.faseInicial.botonesMoverEnTablero.BotonMoverIzquierda;

public class VistaFaseJuego {

    public VistaFaseJuego(Juego juego, HBox contenedorHorizontal, VistaDeTablero vistaDeTablero){

        VBox contenedorVertical = new VBox();
        contenedorVertical.setSpacing(5);

        EtiquetaFase etiquetaFase = new EtiquetaFase("Fase de movimiento");
        EtiquetaTurnoJugador etiquetaTurnoJugador = new EtiquetaTurnoJugador( juego );

        contenedorHorizontal.getChildren().add(contenedorVertical);
        contenedorVertical.getChildren().addAll(etiquetaFase.etiqueta, etiquetaTurnoJugador.etiqueta);

        GridPane panelDeControl = new GridPane();
        panelDeControl.setAlignment(Pos.BOTTOM_CENTER);

        Ubicacion ubicacion = new Ubicacion(9,9);
        Label etiquetaAlertas = new Label();

        panelDeControl.add(new BotonMoverArriba(vistaDeTablero, ubicacion),1,0);
        panelDeControl.add(new BotonMoverAbajo(vistaDeTablero, ubicacion),1,3);
        panelDeControl.add(new BotonMoverDerecha(vistaDeTablero, ubicacion),2,2);
        panelDeControl.add(new BotonMoverIzquierda(vistaDeTablero,ubicacion),0,2);

        BotonSeleccionarUnidad botonSeleccionarUnidad = new BotonSeleccionarUnidad(ubicacion, juego, etiquetaAlertas);

        contenedorVertical.getChildren().addAll(panelDeControl, botonSeleccionarUnidad, etiquetaAlertas);


    }


}
