package vista.fases.faseInicial.botonesAgregarPiezas;

import controlador.buttonHandlers.fase.faseInicial.agregarPiezasEventHandlers.BotonAgregarCatapultaEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modelo.pieza.Ubicacion;
import vista.VistaDeTablero;
import vista.fases.faseInicial.EtiquetaPuntosJugador;

public class BotonAgregarCatapulta extends Button {

    public BotonAgregarCatapulta(Label etiquetaAlertas, Ubicacion ubicacion, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos) {

        super();
        this.setMinHeight(20);
        this.setOnAction(new BotonAgregarCatapultaEventHandler(etiquetaAlertas, ubicacion, vistaDeTablero, etiquetaPuntos));
        this.setText("Agregar catapulta");
    }
}
