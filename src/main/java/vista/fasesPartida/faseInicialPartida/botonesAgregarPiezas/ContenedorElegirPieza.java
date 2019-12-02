package vista.fasesPartida.faseInicialPartida.botonesAgregarPiezas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;
import vista.fasesPartida.informacionPiezas.InformacionCatapulta;
import vista.fasesPartida.informacionPiezas.InformacionCurandero;
import vista.fasesPartida.informacionPiezas.InformacionInfanteria;
import vista.fasesPartida.informacionPiezas.InformacionJinete;

public class ContenedorElegirPieza extends GridPane {
    public ContenedorElegirPieza(VistaDeTablero vistaDeTablero, CamposDeTexto camposDeTexto, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora){

        InformacionInfanteria infanteria = new InformacionInfanteria();
        VBox pieza1 = new VBox(5);
        BotonAgregarInfanteria btnInfanteria = new BotonAgregarInfanteria(camposDeTexto, vistaDeTablero, etiquetaPuntos,etiquteComunicadora);
        pieza1.getChildren().addAll(infanteria, btnInfanteria);

        InformacionCurandero curandero = new InformacionCurandero();
        VBox pieza2 = new VBox(5);
        BotonAgregarCurandero btnCurandero = new BotonAgregarCurandero(camposDeTexto, vistaDeTablero, etiquetaPuntos,etiquteComunicadora);
        pieza2.getChildren().addAll(curandero, btnCurandero);

        InformacionJinete jinete = new InformacionJinete();
        VBox pieza3 = new VBox(5);
        BotonAgregarJinete btnJinete = new BotonAgregarJinete(camposDeTexto, vistaDeTablero, etiquetaPuntos, etiquteComunicadora);
        pieza3.getChildren().addAll(jinete, btnJinete);

        InformacionCatapulta catapulta = new InformacionCatapulta();
        VBox pieza4 = new VBox(5);
        BotonAgregarCatapulta botonCatapulta = new BotonAgregarCatapulta(camposDeTexto, vistaDeTablero, etiquetaPuntos,etiquteComunicadora);
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
