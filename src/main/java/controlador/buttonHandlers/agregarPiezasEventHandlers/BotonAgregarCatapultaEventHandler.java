package controlador.buttonHandlers.agregarPiezasEventHandlers;


import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.fasePartida.faseInicialPartida.EtiquetaPuntosJugador;

public class BotonAgregarCatapultaEventHandler extends BotonAgregarPiezaEventHandler {
    private String nombre = "Catapulta";

    public BotonAgregarCatapultaEventHandler(CamposDeTexto campoDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos) {

        super.initialize( campoDeTexto, vistaDeTablero, etiquetaPuntos, nombre);

    }

}
