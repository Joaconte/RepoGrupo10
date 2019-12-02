package vista.faseJuego;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Juego;
import vista.CamposDeTexto;
import vista.EtiquetaFase;
import vista.VistaDeTablero;
import vista.faseInicial.EtiquetaTurnoJugador;
import vista.faseInicial.botonesMoverEnTablero.BotonMoverAbajo;
import vista.faseInicial.botonesMoverEnTablero.BotonMoverArriba;
import vista.faseInicial.botonesMoverEnTablero.BotonMoverDerecha;
import vista.faseInicial.botonesMoverEnTablero.BotonMoverIzquierda;

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

        CamposDeTexto camposDeTexto = new CamposDeTexto("Ingrese coordenada x", "Ingrese coordenada y");

        panelDeControl.add(new BotonMoverArriba(vistaDeTablero, camposDeTexto),1,0);
        panelDeControl.add(new BotonMoverAbajo(vistaDeTablero, camposDeTexto),1,3);
        panelDeControl.add(new BotonMoverDerecha(vistaDeTablero, camposDeTexto),2,2);
        panelDeControl.add(new BotonMoverIzquierda(vistaDeTablero,camposDeTexto),0,2);

        BotonSeleccionarUnidad botonSeleccionarUnidad = new BotonSeleccionarUnidad(camposDeTexto, juego);

        contenedorVertical.getChildren().addAll(panelDeControl, botonSeleccionarUnidad, camposDeTexto.etiquetaUno);


    }


}
