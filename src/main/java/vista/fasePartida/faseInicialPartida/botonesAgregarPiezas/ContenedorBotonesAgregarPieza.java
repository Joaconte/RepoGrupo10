package vista.fasePartida.faseInicialPartida.botonesAgregarPiezas;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.fasePartida.faseInicialPartida.EtiquetaPuntosJugador;

public class ContenedorBotonesAgregarPieza extends HBox {

    public ContenedorBotonesAgregarPieza(VistaDeTablero vistaDeTablero, VBox contenedorVertical, CamposDeTexto camposDeTexto, EtiquetaPuntosJugador etiquetaPuntos){

        super();
        setHeight(20);

        BotonAgregarInfanteria botonInfanteria = new BotonAgregarInfanteria(camposDeTexto, vistaDeTablero, etiquetaPuntos);
        BotonAgregarCurandero botonCurandero = new BotonAgregarCurandero(camposDeTexto, vistaDeTablero, etiquetaPuntos );
        BotonAgregarJinete botonJinete = new BotonAgregarJinete(camposDeTexto, vistaDeTablero, etiquetaPuntos);
        BotonAgregarCatapulta botonCatapulta = new BotonAgregarCatapulta(camposDeTexto, vistaDeTablero, etiquetaPuntos);

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
    }

}
