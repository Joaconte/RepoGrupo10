package controlador.buttonHandlers.agregarPiezasEventHandlers;


import javafx.scene.control.Label;
import modelo.pieza.Ubicacion;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;

public class BotonAgregarInfanteriaEventHandler extends BotonAgregarPiezaEventHandler{

    public BotonAgregarInfanteriaEventHandler(Ubicacion ubicacion, VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora) {

        super(ubicacion, vistaDeTablero, etiquetaPuntos, "Infanteria",etiquteComunicadora);

    }

}
