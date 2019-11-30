package vista.faseInicial;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modelo.Juego;
import vista.CamposDeTexto;
import vista.faseInicial.botonesAgregarPiezas.ContenedorBotonesAgregarPieza;
import vista.VistaDeTablero;
import vista.faseInicial.botonesMoverEnTablero.BotonMoverAbajo;
import vista.faseInicial.botonesMoverEnTablero.BotonMoverArriba;
import vista.faseInicial.botonesMoverEnTablero.BotonMoverDerecha;
import vista.faseInicial.botonesMoverEnTablero.BotonMoverIzquierda;


public class VistaFaseInicial {

    public VistaFaseInicial(Juego juego, VistaDeTablero vistaDeTablero, HBox contenedorHorizontal) {

        VBox contenedorVertical = new VBox();

        contenedorHorizontal.getChildren().add(contenedorVertical);
        contenedorHorizontal.setSpacing(10);

        EtiquetaTurnoJugador etiqueta1 = new EtiquetaTurnoJugador( juego );
        EtiquetaPuntosJugador etiquetaPuntos = new EtiquetaPuntosJugador( juego );

        contenedorVertical.getChildren().addAll(etiqueta1.etiqueta, etiquetaPuntos.etiqueta);

        CamposDeTexto camposDeTexto = new CamposDeTexto("Ingrese coordenada x", "Ingrese coordenada y");

        ContenedorBotonesAgregarPieza contenedorBotones = new ContenedorBotonesAgregarPieza( vistaDeTablero, contenedorVertical, camposDeTexto, etiquetaPuntos);

        GridPane panelDeControl = new GridPane();
        contenedorVertical.setSpacing(5);
        panelDeControl.setAlignment(Pos.CENTER);

        panelDeControl.add(new BotonMoverArriba(vistaDeTablero, camposDeTexto),1,0);
        panelDeControl.add(new BotonMoverAbajo(vistaDeTablero, camposDeTexto),1,3);
        panelDeControl.add(new BotonMoverDerecha(vistaDeTablero, camposDeTexto),2,2);
        panelDeControl.add(new BotonMoverIzquierda(vistaDeTablero,camposDeTexto),0,2);

        contenedorVertical.getChildren().add(panelDeControl);


    }
}
