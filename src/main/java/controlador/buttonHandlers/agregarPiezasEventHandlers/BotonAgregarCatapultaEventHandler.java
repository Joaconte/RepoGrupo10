package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.scene.control.Label;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Catapulta;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;
import vista.vistaPiezas.VistaUnidadCatapulta;


public class BotonAgregarCatapultaEventHandler extends BotonAgregarPiezaEventHandler {

    public BotonAgregarCatapultaEventHandler( VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora) {
        super(vistaDeTablero, etiquetaPuntos, "Catapulta", etiquteComunicadora);
    }

    @Override
    void agregarPiezaATablero(Pieza pieza) {
        VistaUnidadCatapulta vistaDeUnidad = new VistaUnidadCatapulta((Catapulta) pieza ,vistaDeTablero,"catapulta",etiquetaPuntos.juego);
        vistaDeUnidad.crearVistaEnTablero();
    }
}
