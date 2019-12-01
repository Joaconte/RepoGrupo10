package controlador.buttonHandlers.agregarPiezasEventHandlers;

import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.faseInicial.EtiquetaPuntosJugador;

public class BotonAgregarJineteEventHandler extends BotonAgregarPiezaEventHandler {

    private String nombre = "Jinete";

    public BotonAgregarJineteEventHandler(CamposDeTexto campoDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos) {

        super.initialize( campoDeTexto, vistaDeTablero, etiquetaPuntos, nombre);

    }

}
