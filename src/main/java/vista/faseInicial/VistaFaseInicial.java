package vista.faseInicial;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Juego;
import vista.CamposDeTexto;
import vista.faseInicial.botonesAgregarPiezas.ContenedorBotonesAgregarPieza;
import vista.VistaDeTablero;
import vista.faseInicial.botonesAgregarPiezas.ContenedorElegirPieza;
import vista.faseInicial.botonesMoverEnTablero.BotonMoverAbajo;
import vista.faseInicial.botonesMoverEnTablero.BotonMoverArriba;
import vista.faseInicial.botonesMoverEnTablero.BotonMoverDerecha;
import vista.faseInicial.botonesMoverEnTablero.BotonMoverIzquierda;


public class VistaFaseInicial {

    public VistaFaseInicial(Juego juego, VistaDeTablero vistaDeTablero, HBox contenedorHorizontal) {

        VBox contenedorVertical = new VBox();
        contenedorVertical.setSpacing(15);

        contenedorHorizontal.getChildren().add(contenedorVertical);
        contenedorHorizontal.setSpacing(15);

        EtiquetaTurnoJugador etiquetaTurnoJugador = new EtiquetaTurnoJugador( juego );
        EtiquetaPuntosJugador etiquetaPuntos = new EtiquetaPuntosJugador( juego );


        contenedorVertical.getChildren().addAll(etiquetaTurnoJugador.etiqueta, etiquetaPuntos.etiqueta);

        CamposDeTexto camposDeTexto = new CamposDeTexto("Ingrese coordenada x", "Ingrese coordenada y");

        ContenedorBotonesAgregarPieza contenedorBotones = new ContenedorBotonesAgregarPieza( vistaDeTablero, contenedorVertical, camposDeTexto, etiquetaPuntos);
        ContenedorElegirPieza piezas = new ContenedorElegirPieza(vistaDeTablero, contenedorVertical, camposDeTexto, etiquetaPuntos);

        GridPane panelDeControl = new GridPane();
        panelDeControl.setAlignment(Pos.BOTTOM_CENTER);
        panelDeControl.add(new BotonMoverArriba(vistaDeTablero, camposDeTexto),1,0);
        panelDeControl.add(new BotonMoverAbajo(vistaDeTablero, camposDeTexto),1,3);
        panelDeControl.add(new BotonMoverDerecha(vistaDeTablero, camposDeTexto),2,2);
        panelDeControl.add(new BotonMoverIzquierda(vistaDeTablero,camposDeTexto),0,2);

        BotonSiguienteTurno botonSiguienteTurno = new BotonSiguienteTurno(etiquetaTurnoJugador,etiquetaPuntos,juego,camposDeTexto);
        botonSiguienteTurno.setAlignment(Pos.BOTTOM_CENTER);

        contenedorVertical.getChildren().addAll(panelDeControl, botonSiguienteTurno, piezas );



    }
}
