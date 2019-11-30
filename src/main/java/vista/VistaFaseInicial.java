package vista;

import controlador.buttonHandlers.TextoEventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import vista.botones.agregarPiezas.BotonAgregarCatapulta;
import vista.botones.agregarPiezas.BotonAgregarCurandero;
import vista.botones.agregarPiezas.BotonAgregarInfanteria;
import vista.botones.agregarPiezas.BotonAgregarJinete;
import vista.botonesMoverEnTablero.BotonMoverAbajo;
import vista.botonesMoverEnTablero.BotonMoverArriba;
import vista.botonesMoverEnTablero.BotonMoverDerecha;
import vista.botonesMoverEnTablero.BotonMoverIzquierda;

public class VistaFaseInicial {

    public VistaFaseInicial(VistaDeTablero vistaDeTablero, HBox contenedorHorizontal) {

        VBox contenedorVertical = new VBox();

        contenedorHorizontal.getChildren().add(contenedorVertical);
        contenedorHorizontal.setSpacing(10);

        CamposDeTexto camposDeTexto = new CamposDeTexto("Ingrese coordenada x", "Ingrese coordenada y");

        BotonAgregarInfanteria botonInfanteria = new BotonAgregarInfanteria(camposDeTexto, vistaDeTablero);
        BotonAgregarCurandero botonCurandero = new BotonAgregarCurandero(camposDeTexto, vistaDeTablero);
        BotonAgregarJinete botonJinete = new BotonAgregarJinete(camposDeTexto, vistaDeTablero);
        BotonAgregarCatapulta botonCatapulta = new BotonAgregarCatapulta(camposDeTexto, vistaDeTablero);

        HBox hbox1 = new HBox();
        hbox1.setSpacing(5);
        hbox1.getChildren().addAll(botonInfanteria, botonCurandero);

        HBox hbox2 = new HBox();
        hbox2.setSpacing(5);
        hbox2.getChildren().addAll(botonJinete, botonCatapulta);

        contenedorVertical.getChildren().add(camposDeTexto.textoUno);
        contenedorVertical.getChildren().add(camposDeTexto.textoDos);
        contenedorVertical.getChildren().addAll(hbox1, hbox2);
        contenedorVertical.getChildren().add(camposDeTexto.etiquetaUno);

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
