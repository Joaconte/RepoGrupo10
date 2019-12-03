package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.scene.control.Label;
import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;
import modelo.pieza.tipos.Jinete;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;
import vista.vistaPiezas.VistaJinete;


public class BotonAgregarJineteEventHandler extends BotonAgregarPiezaEventHandler {

    public BotonAgregarJineteEventHandler(Ubicacion ubicacion, VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora) {

        super( ubicacion, vistaDeTablero, etiquetaPuntos, "Jinete",etiquteComunicadora);
    }

    @Override
    void agregarPiezaATablero(Pieza pieza) {
        VistaJinete VistaDeUnidad = new VistaJinete((Jinete) pieza ,vistaDeTablero);
    }
}

