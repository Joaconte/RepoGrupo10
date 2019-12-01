package controlador.buttonHandlers.agregarPiezasEventHandlers;


import modelo.pieza.Pieza;
import modelo.pieza.tipos.Catapulta;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.VistaDeUnidad;
import vista.faseInicial.EtiquetaPuntosJugador;

public class BotonAgregarCatapultaEventHandler extends BotonAgregarPiezaEventHandler {
    private String nombre = "Catapulta";

    public BotonAgregarCatapultaEventHandler(CamposDeTexto campoDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos) {

        super.initialize( campoDeTexto, vistaDeTablero, etiquetaPuntos, nombre);

    }

}
