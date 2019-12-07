package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.scene.control.Label;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Curandero;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;
import vista.vistaPiezas.VistaUnidadCurandera;


public class BotonAgregarCuranderoEventHandler extends BotonAgregarPiezaEventHandler {

    public BotonAgregarCuranderoEventHandler( VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora) {

        super( vistaDeTablero, etiquetaPuntos, "Curandero", etiquteComunicadora);

    }


    @Override
    void agregarPiezaATablero(Pieza pieza) {
        VistaUnidadCurandera vistaDeUnidad = new VistaUnidadCurandera((Curandero) pieza ,vistaDeTablero,"curandero",etiquetaPuntos.juego);
        vistaDeUnidad.crearVistaEnTablero();

    }
}
