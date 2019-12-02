package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.scene.control.Label;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;


public class BotonAgregarJineteEventHandler extends BotonAgregarPiezaEventHandler {

    public BotonAgregarJineteEventHandler(CamposDeTexto campoDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora) {

        super( campoDeTexto, vistaDeTablero, etiquetaPuntos, "Jinete",etiquteComunicadora);
    }

}
