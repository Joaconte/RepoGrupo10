package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.scene.control.Label;
import modelo.pieza.Ubicacion;
import vista.VistaDeTablero;
import vista.fases.faseInicial.EtiquetaPuntosJugador;


public class BotonAgregarInfanteriaEventHandler extends BotonAgregarPiezaEventHandler{

    public BotonAgregarInfanteriaEventHandler(Label etiquetaAlertas, Ubicacion ubicacion, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos) {

        super(etiquetaAlertas, ubicacion, vistaDeTablero, etiquetaPuntos, "Infanteria");

    }

}
