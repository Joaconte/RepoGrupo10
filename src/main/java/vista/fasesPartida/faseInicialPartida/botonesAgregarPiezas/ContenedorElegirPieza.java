package vista.fasesPartida.faseInicialPartida.botonesAgregarPiezas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modelo.pieza.Ubicacion;
import modelo.pieza.tipos.Catapulta;
import modelo.pieza.tipos.Curandero;
import modelo.pieza.tipos.Infanteria;
import modelo.pieza.tipos.Jinete;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;
import vista.vistaPiezas.VistaDeUnidad;

public class ContenedorElegirPieza extends GridPane {
    public ContenedorElegirPieza(VistaDeTablero vistaDeTablero, Ubicacion ubicacion, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora){

        VistaDeUnidad infanteria = new VistaDeUnidad("infanteria",new Infanteria(),vistaDeTablero);
        VBox pieza1 = new VBox(5);
        BotonAgregarInfanteria btnInfanteria = new BotonAgregarInfanteria(ubicacion, vistaDeTablero, etiquetaPuntos,etiquteComunicadora);
        pieza1.getChildren().addAll(infanteria, btnInfanteria);

        VistaDeUnidad curandero = new VistaDeUnidad("curandero",new Curandero(),vistaDeTablero);
        VBox pieza2 = new VBox(5);
        BotonAgregarCurandero btnCurandero = new BotonAgregarCurandero(ubicacion, vistaDeTablero, etiquetaPuntos,etiquteComunicadora);
        pieza2.getChildren().addAll(curandero, btnCurandero);

        VistaDeUnidad jinete = new VistaDeUnidad("jinete",new Jinete(),vistaDeTablero);
        VBox pieza3 = new VBox(5);
        BotonAgregarJinete btnJinete = new BotonAgregarJinete(ubicacion, vistaDeTablero, etiquetaPuntos, etiquteComunicadora);
        pieza3.getChildren().addAll(jinete, btnJinete);

        VistaDeUnidad catapulta = new VistaDeUnidad("catapulta",new Catapulta(),vistaDeTablero);
        VBox pieza4 = new VBox(5);
        BotonAgregarCatapulta botonCatapulta = new BotonAgregarCatapulta(ubicacion, vistaDeTablero, etiquetaPuntos,etiquteComunicadora);
        pieza4.getChildren().addAll(catapulta, botonCatapulta);

        pieza1.setSpacing(10);
        pieza2.setSpacing(10);
        pieza3.setSpacing(10);
        pieza4.setSpacing(10);

        this.add(pieza1,0,0);
        this.add(pieza2,0,1);
        this.add(pieza3,1,0);
        this.add(pieza4,1,1);
        this.setAlignment(Pos.CENTER);
        this.autosize();
    }
}
