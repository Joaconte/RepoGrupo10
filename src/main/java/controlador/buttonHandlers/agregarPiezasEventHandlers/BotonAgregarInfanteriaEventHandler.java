package controlador.buttonHandlers.agregarPiezasEventHandlers;


import javafx.scene.control.Label;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;

public class BotonAgregarInfanteriaEventHandler extends BotonAgregarPiezaEventHandler{

    public BotonAgregarInfanteriaEventHandler(CamposDeTexto campoDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora) {

        super(campoDeTexto, vistaDeTablero, etiquetaPuntos, "Infanteria",etiquteComunicadora);

    }

}
