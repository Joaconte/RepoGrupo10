package vista.fases.faseInicial.botonesAgregarPiezas;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.pieza.Ubicacion;
import vista.VistaDeTablero;
import vista.fases.faseInicial.EtiquetaPuntosJugador;
import vista.fases.faseInicial.informacionPiezas.InformacionCatapulta;
import vista.fases.faseInicial.informacionPiezas.InformacionCurandero;
import vista.fases.faseInicial.informacionPiezas.InformacionInfanteria;
import vista.fases.faseInicial.informacionPiezas.InformacionJinete;


public class ContenedorElegirPieza extends HBox {
    public ContenedorElegirPieza(Label etiquetaAlertas, VistaDeTablero vistaDeTablero, VBox contenedorVertical, Ubicacion ubicacion, EtiquetaPuntosJugador etiquetaPuntos){

        InformacionInfanteria infanteria = new InformacionInfanteria();
        VBox pieza1 = new VBox(5);
        BotonAgregarInfanteria btnInfanteria = new BotonAgregarInfanteria(etiquetaAlertas, ubicacion, vistaDeTablero, etiquetaPuntos);
        pieza1.getChildren().addAll(infanteria, btnInfanteria);

        InformacionCurandero curandero = new InformacionCurandero();
        VBox pieza2 = new VBox(5);
        BotonAgregarCurandero btnCurandero = new BotonAgregarCurandero(etiquetaAlertas, ubicacion, vistaDeTablero, etiquetaPuntos);
        pieza2.getChildren().addAll(curandero, btnCurandero);

        InformacionJinete jinete = new InformacionJinete();
        VBox pieza3 = new VBox(5);
        BotonAgregarJinete btnJinete = new BotonAgregarJinete(etiquetaAlertas, ubicacion, vistaDeTablero, etiquetaPuntos);
        pieza3.getChildren().addAll(jinete, btnJinete);

        InformacionCatapulta catapulta = new InformacionCatapulta();
        VBox pieza4 = new VBox(5);
        BotonAgregarCatapulta botonCatapulta = new BotonAgregarCatapulta(etiquetaAlertas, ubicacion, vistaDeTablero, etiquetaPuntos);
        pieza4.getChildren().addAll(catapulta, botonCatapulta);

        this.getChildren().addAll(pieza1,pieza2,pieza3,pieza4);
        this.setSpacing(10);
        this.autosize();
    }
}
