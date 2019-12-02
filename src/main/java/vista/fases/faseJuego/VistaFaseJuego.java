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


        Ubicacion ubicacionVariable = new Ubicacion(9, 9);
        Ubicacion ubicacionEstatica = new Ubicacion(ubicacionVariable.getPosicionEnX(), ubicacionVariable.getPosicionEnY());

        panelDeControl.add(new BotonMoverArriba(vistaDeTablero, ubicacionVariable),1,0);
        panelDeControl.add(new BotonMoverAbajo(vistaDeTablero, ubicacionVariable),1,3);
        panelDeControl.add(new BotonMoverDerecha(vistaDeTablero, ubicacionVariable),2,2);
        panelDeControl.add(new BotonMoverIzquierda(vistaDeTablero,ubicacionVariable),0,2);

        Label etiquetaAlerta1 = new Label();
        Label etiquetaAlerta2 = new Label();

        Label etiquetaUbicacion1 = new Label();
        Label etiquetaUbicacion2 = new Label();

        BotonSeleccionarUnidad botonSeleccionarUnidad = new BotonSeleccionarUnidad(ubicacionVariable, ubicacionEstatica, juego, etiquetaAlerta1);
        BotonMoverUnidad botonMoverUnidad = new BotonMoverUnidad(ubicacionEstatica, ubicacionVariable, juego, etiquetaAlerta2, vistaDeTablero);
        BotonActualizarPosiciones botonActualizarPosiciones = new BotonActualizarPosiciones(etiquetaUbicacion1, etiquetaUbicacion2, ubicacionEstatica, ubicacionVariable);

        contenedorVertical.getChildren().addAll(panelDeControl, botonSeleccionarUnidad, etiquetaAlerta1, botonMoverUnidad, botonActualizarPosiciones, etiquetaAlerta2, etiquetaUbicacion1 );


    }


}
