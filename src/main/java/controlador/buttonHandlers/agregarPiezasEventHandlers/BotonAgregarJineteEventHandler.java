package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.scene.layout.VBox;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.faseInicial.EtiquetaPuntosJugador;
import vista.faseInicial.EtiquetaTurnoJugador;

public class BotonAgregarJineteEventHandler extends BotonAgregarPiezaEventHandler {

    private String nombre = "Jinete";

    public BotonAgregarJineteEventHandler(CamposDeTexto campoDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos) {

        super.initialize( campoDeTexto, vistaDeTablero, etiquetaPuntos, nombre);

    }

}
