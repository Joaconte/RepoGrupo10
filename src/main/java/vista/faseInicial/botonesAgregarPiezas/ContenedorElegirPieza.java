package vista.faseInicial.botonesAgregarPiezas;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.faseInicial.EtiquetaPuntosJugador;

import java.awt.*;

public class ContenedorElegirPieza extends HBox {
    public ContenedorElegirPieza(VistaDeTablero vistaDeTablero, VBox contenedorVertical, CamposDeTexto camposDeTexto, EtiquetaPuntosJugador etiquetaPuntos){
        InformacionPieza  catapulta = new InformacionPieza("catapulta");
        VBox pieza1 = new VBox(5);
        BotonAgregarCatapulta botonCatapulta = new BotonAgregarCatapulta(camposDeTexto, vistaDeTablero, etiquetaPuntos);
        pieza1.getChildren().addAll(catapulta, botonCatapulta);

        InformacionPieza  curandero = new InformacionPieza("curandero");
        VBox pieza2 = new VBox(5);
        BotonAgregarCurandero btnCurandero = new BotonAgregarCurandero(camposDeTexto, vistaDeTablero, etiquetaPuntos);
        pieza2.getChildren().addAll(curandero, btnCurandero);

        InformacionPieza  jinete = new InformacionPieza("jinete");
        VBox pieza3 = new VBox(5);
        BotonAgregarJinete btnJinete = new BotonAgregarJinete(camposDeTexto, vistaDeTablero, etiquetaPuntos);
        pieza3.getChildren().addAll(jinete, btnJinete);

        InformacionPieza  infanteria = new InformacionPieza("infanteria");
        VBox pieza4 = new VBox(5);
        BotonAgregarInfanteria btnInfanteria = new BotonAgregarInfanteria(camposDeTexto, vistaDeTablero, etiquetaPuntos);
        pieza4.getChildren().addAll(infanteria, btnInfanteria);

        this.getChildren().addAll(pieza1,pieza2,pieza3,pieza4);
        this.setSpacing(10);
        this.autosize();
    }
}
