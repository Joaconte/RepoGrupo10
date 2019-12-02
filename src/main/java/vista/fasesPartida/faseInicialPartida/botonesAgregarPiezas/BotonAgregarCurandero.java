package vista.fasesPartida.faseInicialPartida.botonesAgregarPiezas;

import controlador.buttonHandlers.agregarPiezasEventHandlers.BotonAgregarCuranderoEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;

public class BotonAgregarCurandero extends Button {

    public BotonAgregarCurandero(CamposDeTexto camposDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora) {

        super();
        this.setMinHeight(20);
        this.setOnAction(new BotonAgregarCuranderoEventHandler(camposDeTexto, vistaDeTablero, etiquetaPuntos, etiquteComunicadora));
        this.setText("Agregar curandero");
    }
}
