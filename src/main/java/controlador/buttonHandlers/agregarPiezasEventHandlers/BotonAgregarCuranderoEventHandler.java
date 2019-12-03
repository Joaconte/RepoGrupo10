package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.scene.control.Label;
import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;
import modelo.pieza.tipos.Curandero;
import vista.VistaDeTablero;

import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;
import vista.vistaPiezas.VistaUnidad;


public class BotonAgregarCuranderoEventHandler extends BotonAgregarPiezaEventHandler {

    public BotonAgregarCuranderoEventHandler(Ubicacion ubicacion, VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora) {

        super( ubicacion, vistaDeTablero, etiquetaPuntos, "Curandero", etiquteComunicadora);

    }


    @Override
    void agregarPiezaATablero(Pieza pieza) {
        VistaUnidad VistaDeUnidad = new VistaUnidad((Curandero) pieza ,vistaDeTablero,"curandero");

    }
}
