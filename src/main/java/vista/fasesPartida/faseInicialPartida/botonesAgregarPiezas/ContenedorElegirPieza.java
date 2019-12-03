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
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;
import vista.vistaPiezas.VistaInformacionDeUnidad;

public class ContenedorElegirPieza extends GridPane {
    public ContenedorElegirPieza(VistaDeTablero vistaDeTablero, Ubicacion ubicacion, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora){

        VistaInformacionDeUnidad infanteria = new VistaInformacionDeUnidad("infanteria",new Infanteria());
        VBox pieza1 = new VBox(5);
        BotonAgregarInfanteria btnInfanteria = new BotonAgregarInfanteria(ubicacion, vistaDeTablero, etiquetaPuntos,etiquteComunicadora);
        pieza1.getChildren().addAll(infanteria, btnInfanteria);

        VistaInformacionDeUnidad curandero = new VistaInformacionDeUnidad("curandero",new Curandero());
        VBox pieza2 = new VBox(5);
        BotonAgregarCurandero btnCurandero = new BotonAgregarCurandero(ubicacion, vistaDeTablero, etiquetaPuntos,etiquteComunicadora);
        pieza2.getChildren().addAll(curandero, btnCurandero);

        VistaInformacionDeUnidad jinete = new VistaInformacionDeUnidad("jinete",new Jinete());
        VBox pieza3 = new VBox(5);
        BotonAgregarJinete btnJinete = new BotonAgregarJinete(ubicacion, vistaDeTablero, etiquetaPuntos, etiquteComunicadora);
        pieza3.getChildren().addAll(jinete, btnJinete);

        VistaInformacionDeUnidad catapulta = new VistaInformacionDeUnidad("catapulta",new Catapulta());
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
