package vista;

import controlador.buttonHandlers.TextoEventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import vista.botones.agregarPiezas.BotonAgregarCatapulta;
import vista.botones.agregarPiezas.BotonAgregarCurandero;
import vista.botones.agregarPiezas.BotonAgregarInfanteria;
import vista.botones.agregarPiezas.BotonAgregarJinete;

public class VistaFaseInicial {

    public VistaFaseInicial(VistaDeTablero vistaDeTablero, HBox hbox) {

        VBox vbox = new VBox();

        hbox.getChildren().add(vbox);

        CamposDeTexto camposDeTexto = new CamposDeTexto("Ingrese coordenada x", "Ingrese coordenada y");
        BotonAgregarInfanteria botonInfanteria = new BotonAgregarInfanteria(camposDeTexto, vistaDeTablero);
        BotonAgregarCurandero botonCurandero = new BotonAgregarCurandero(camposDeTexto, vistaDeTablero);
        BotonAgregarJinete botonJinete = new BotonAgregarJinete(camposDeTexto, vistaDeTablero);
        BotonAgregarCatapulta botonCatapulta = new BotonAgregarCatapulta(camposDeTexto, vistaDeTablero);

        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(botonInfanteria, botonCurandero);

        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(botonJinete, botonCatapulta);

        vbox.getChildren().add(camposDeTexto.textoUno);
        vbox.getChildren().add(camposDeTexto.textoDos);
        vbox.getChildren().addAll(hbox1, hbox2);
        vbox.getChildren().add(camposDeTexto.etiquetaUno);

    }
}
