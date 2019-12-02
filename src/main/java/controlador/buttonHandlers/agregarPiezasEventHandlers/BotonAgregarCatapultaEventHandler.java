package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.scene.control.Label;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;


public class BotonAgregarCatapultaEventHandler extends BotonAgregarPiezaEventHandler {

    public BotonAgregarCatapultaEventHandler(CamposDeTexto campoDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora) {
        super( campoDeTexto, vistaDeTablero, etiquetaPuntos, "Catapulta", etiquteComunicadora);
    }

}
