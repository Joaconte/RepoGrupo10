package controlador.buttonHandlers.agregarPiezasEventHandlers;

import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.fasePartida.faseInicialPartida.EtiquetaPuntosJugador;

public class BotonAgregarCuranderoEventHandler extends BotonAgregarPiezaEventHandler {

    private String nombre = "Curandero";

    public BotonAgregarCuranderoEventHandler(CamposDeTexto camposDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos) {

        super.initialize( camposDeTexto, vistaDeTablero, etiquetaPuntos, nombre);

    }



}
