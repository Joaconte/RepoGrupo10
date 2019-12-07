package vista.fasesPartida.faseInicialPartida.botonesAgregarPiezas;

import controlador.buttonHandlers.agregarPiezasEventHandlers.BotonAgregarJineteEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;

public class BotonAgregarJinete extends Button {

    public BotonAgregarJinete( VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora) {

        super();
        this.setMinHeight(20);
        this.setOnAction(new BotonAgregarJineteEventHandler(vistaDeTablero, etiquetaPuntos, etiquteComunicadora));
        this.setText("Agregar jinete");
    }
}
