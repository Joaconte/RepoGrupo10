package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.scene.control.Label;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Jinete;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;
import vista.vistaPiezas.VistaUnidadAtacante;


public class BotonAgregarJineteEventHandler extends BotonAgregarPiezaEventHandler {

    public BotonAgregarJineteEventHandler( VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora) {

        super( vistaDeTablero, etiquetaPuntos, "Jinete",etiquteComunicadora);
    }

    @Override
    void agregarPiezaATablero(Pieza pieza) {
        VistaUnidadAtacante vistaDeUnidad = new VistaUnidadAtacante((Jinete) pieza ,vistaDeTablero,"jinete",etiquetaPuntos.juego);
        vistaDeUnidad.crearVistaEnTablero();
    }
}

