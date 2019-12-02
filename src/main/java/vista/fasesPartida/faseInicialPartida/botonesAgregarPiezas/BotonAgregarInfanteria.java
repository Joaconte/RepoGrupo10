package vista.fasesPartida.faseInicialPartida.botonesAgregarPiezas;

import controlador.buttonHandlers.agregarPiezasEventHandlers.BotonAgregarInfanteriaEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;

public class BotonAgregarInfanteria extends Button {

    public BotonAgregarInfanteria(CamposDeTexto camposDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, Label etiquteComunicadora) {

        super();
        this.setMinHeight(20);
        this.setOnAction(new BotonAgregarInfanteriaEventHandler(camposDeTexto, vistaDeTablero, etiquetaPuntos, etiquteComunicadora));
        this.setText("Agregar infanteria");
    }
}
