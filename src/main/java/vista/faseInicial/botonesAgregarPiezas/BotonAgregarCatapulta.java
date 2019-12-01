package vista.faseInicial.botonesAgregarPiezas;

import controlador.buttonHandlers.agregarPiezasEventHandlers.BotonAgregarCatapultaEventHandler;
import javafx.scene.control.Button;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.faseInicial.EtiquetaPuntosJugador;

public class BotonAgregarCatapulta extends Button {

    public BotonAgregarCatapulta(CamposDeTexto camposDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos) {

        super();
        this.setMinHeight(20);
        this.setOnAction(new BotonAgregarCatapultaEventHandler(camposDeTexto, vistaDeTablero, etiquetaPuntos));
        this.setText("Agregar catapulta");
    }
}
