package vista.fasesPartida.faseInicialPartida.botonesAgregarPiezas;

import controlador.buttonHandlers.agregarPiezasEventHandlers.BotonAgregarCatapultaEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;

public class BotonAgregarCatapulta extends Button {

    public BotonAgregarCatapulta(CamposDeTexto camposDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora) {

        super();
        this.setMinHeight(20);
        this.setOnAction(new BotonAgregarCatapultaEventHandler(camposDeTexto, vistaDeTablero, etiquetaPuntos, etiquteComunicadora));
        this.setText("Agregar catapulta");
    }
}
