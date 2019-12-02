package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.scene.control.Label;
import vista.CamposDeTexto;
import vista.VistaDeTablero;

import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;


public class BotonAgregarCuranderoEventHandler extends BotonAgregarPiezaEventHandler {

    public BotonAgregarCuranderoEventHandler(CamposDeTexto camposDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora) {

        super( camposDeTexto, vistaDeTablero, etiquetaPuntos, "Curandero", etiquteComunicadora);

    }



}
