package vista.fases.faseInicial;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Juego;
import modelo.pieza.Ubicacion;
import vista.EtiquetaFase;
import vista.VistaDeTablero;
import vista.fases.faseInicial.botonesAgregarPiezas.ContenedorElegirPieza;
import vista.fases.faseInicial.botonesMoverEnTablero.BotonMoverAbajo;
import vista.fases.faseInicial.botonesMoverEnTablero.BotonMoverArriba;
import vista.fases.faseInicial.botonesMoverEnTablero.BotonMoverDerecha;
import vista.fases.faseInicial.botonesMoverEnTablero.BotonMoverIzquierda;

public class VistaFaseInicial {

    public VistaFaseInicial(Juego juego, VistaDeTablero vistaDeTablero, HBox contenedorHorizontal) {

        VBox contenedorVertical = new VBox();
        contenedorVertical.setSpacing(5);

        contenedorHorizontal.getChildren().add(contenedorVertical);
        contenedorHorizontal.setSpacing(15);

        EtiquetaFase etiquetaFase = new EtiquetaFase("Fase de incorporacion de unidades");
        EtiquetaTurnoJugador etiquetaTurnoJugador = new EtiquetaTurnoJugador( juego );
        EtiquetaPuntosJugador etiquetaPuntos = new EtiquetaPuntosJugador( juego );

        contenedorVertical.getChildren().addAll(etiquetaFase.etiqueta, etiquetaTurnoJugador.etiqueta, etiquetaPuntos.etiqueta);

        Ubicacion ubicacion= new Ubicacion(9,9);

        Label etiquetaAlertas = new Label();

        ContenedorElegirPieza piezas = new ContenedorElegirPieza(etiquetaAlertas, vistaDeTablero, contenedorVertical, ubicacion, etiquetaPuntos);

        GridPane panelDeControl = new GridPane();
        panelDeControl.setAlignment(Pos.BOTTOM_CENTER);

        panelDeControl.add(new BotonMoverArriba(vistaDeTablero, ubicacion),1,0);
        panelDeControl.add(new BotonMoverAbajo(vistaDeTablero, ubicacion),1,3);
        panelDeControl.add(new BotonMoverDerecha(vistaDeTablero, ubicacion),2,2);
        panelDeControl.add(new BotonMoverIzquierda(vistaDeTablero,ubicacion),0,2);

        BotonSiguienteTurno botonSiguienteTurno = new BotonSiguienteTurno(etiquetaTurnoJugador, etiquetaPuntos, juego, etiquetaAlertas, contenedorVertical, contenedorHorizontal, vistaDeTablero);
        botonSiguienteTurno.setAlignment(Pos.BOTTOM_CENTER);

        contenedorVertical.getChildren().addAll(piezas, etiquetaAlertas, panelDeControl, botonSiguienteTurno);


    }
}
