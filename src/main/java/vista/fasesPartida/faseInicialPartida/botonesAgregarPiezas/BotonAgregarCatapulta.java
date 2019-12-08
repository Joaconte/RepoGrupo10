package vista.fasesPartida.faseInicialPartida.botonesAgregarPiezas;

import controlador.buttonHandlers.agregarPiezasEventHandlers.BotonAgregarCatapultaEventHandler;
import javafx.scene.control.Button;
import modelo.Juego;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.BarraLateralOpciones;

public class BotonAgregarCatapulta extends Button {

    public BotonAgregarCatapulta(VistaDeTablero vistaDeTablero, BarraLateralOpciones vistaLateral, Juego juego) {

        super();
        this.setMinHeight(20);
        this.setMinWidth(140);
        this.setOnAction(new BotonAgregarCatapultaEventHandler(vistaDeTablero,  vistaLateral,juego));
        this.setText("Agregar catapulta");
    }
}
