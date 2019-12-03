package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.scene.control.Label;
import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;
import modelo.pieza.tipos.Catapulta;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;
import vista.vistaPiezas.VistaCatapulta;


public class BotonAgregarCatapultaEventHandler extends BotonAgregarPiezaEventHandler {

    public BotonAgregarCatapultaEventHandler(Ubicacion ubicacion, VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora) {
        super( ubicacion, vistaDeTablero, etiquetaPuntos, "Catapulta", etiquteComunicadora);
    }

    @Override
    void agregarPiezaATablero(Pieza pieza) {
        VistaCatapulta VistaDeUnidad = new VistaCatapulta((Catapulta) pieza ,vistaDeTablero);

    }
}
