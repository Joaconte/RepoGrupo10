package vista.fasesPartida.faseInicialPartida.botonesAgregarPiezas;

import controlador.buttonHandlers.agregarPiezasEventHandlers.BotonAgregarCuranderoEventHandler;
import javafx.scene.control.Button;
import modelo.Juego;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.BarraLateralOpciones;

public class BotonAgregarCurandero extends Button {

    public BotonAgregarCurandero(VistaDeTablero vistaDeTablero, BarraLateralOpciones vistaLateral, Juego juego) {

        super();
        this.setMinHeight(20);
        this.setMinWidth(140);
        this.setOnAction(new BotonAgregarCuranderoEventHandler(vistaDeTablero,vistaLateral,juego));
        this.setText("Agregar curandero");
    }
}
