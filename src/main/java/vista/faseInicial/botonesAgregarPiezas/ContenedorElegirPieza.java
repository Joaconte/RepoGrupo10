package vista.faseInicial.botonesAgregarPiezas;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.faseInicial.EtiquetaPuntosJugador;
import vista.faseInicial.informacionPiezas.*;

public class ContenedorElegirPieza extends HBox {
    public ContenedorElegirPieza(VistaDeTablero vistaDeTablero, VBox contenedorVertical, CamposDeTexto camposDeTexto, EtiquetaPuntosJugador etiquetaPuntos){

        InformacionInfanteria infanteria = new InformacionInfanteria();
        VBox pieza1 = new VBox(5);
        BotonAgregarInfanteria btnInfanteria = new BotonAgregarInfanteria(camposDeTexto, vistaDeTablero, etiquetaPuntos);
        pieza1.getChildren().addAll(infanteria, btnInfanteria);

        InformacionCurandero curandero = new InformacionCurandero();
        VBox pieza2 = new VBox(5);
        BotonAgregarCurandero btnCurandero = new BotonAgregarCurandero(camposDeTexto, vistaDeTablero, etiquetaPuntos);
        pieza2.getChildren().addAll(curandero, btnCurandero);

        InformacionJinete jinete = new InformacionJinete();
        VBox pieza3 = new VBox(5);
        BotonAgregarJinete btnJinete = new BotonAgregarJinete(camposDeTexto, vistaDeTablero, etiquetaPuntos);
        pieza3.getChildren().addAll(jinete, btnJinete);

        InformacionCatapulta catapulta = new InformacionCatapulta();
        VBox pieza4 = new VBox(5);
        BotonAgregarCatapulta botonCatapulta = new BotonAgregarCatapulta(camposDeTexto, vistaDeTablero, etiquetaPuntos);
        pieza4.getChildren().addAll(catapulta, botonCatapulta);

        this.getChildren().addAll(pieza1,pieza2,pieza3,pieza4);
        this.setSpacing(10);
        this.autosize();
    }
}
