package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Curandero;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.VistaDeUnidad;
import vista.faseInicial.EtiquetaPuntosJugador;

public class BotonAgregarCuranderoEventHandler extends BotonAgregarPiezaEventHandler {

    private String nombre = "Curandero";

    public BotonAgregarCuranderoEventHandler(CamposDeTexto camposDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos) {

        super.initialize( camposDeTexto, vistaDeTablero, etiquetaPuntos, nombre);

    }



}
