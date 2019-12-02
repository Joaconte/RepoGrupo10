package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.scene.control.Label;
import modelo.pieza.Ubicacion;
import vista.VistaDeTablero;
import vista.fases.faseInicial.EtiquetaPuntosJugador;


public class BotonAgregarCuranderoEventHandler extends BotonAgregarPiezaEventHandler {

    public BotonAgregarCuranderoEventHandler(Label etiquetaAlertas, Ubicacion ubicacion, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos) {


        super(etiquetaAlertas, ubicacion, vistaDeTablero, etiquetaPuntos, "Curandero");

    }



}
