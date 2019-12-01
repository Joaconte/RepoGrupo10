package controlador.buttonHandlers.agregarPiezasEventHandlers;


import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.faseInicial.EtiquetaPuntosJugador;

public class BotonAgregarInfanteriaEventHandler extends BotonAgregarPiezaEventHandler{

    private String nombre = "Infanteria";

    public BotonAgregarInfanteriaEventHandler(CamposDeTexto campoDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos) {

        super.initialize(campoDeTexto, vistaDeTablero, etiquetaPuntos, nombre);

    }

}
