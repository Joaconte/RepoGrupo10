package vista.fasesPartida.faseInicialPartida.botonesAgregarPiezas;

import controlador.buttonHandlers.agregarPiezasEventHandlers.BotonAgregarJineteEventHandler;
import javafx.scene.control.Button;
import modelo.Juego;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.BarraLateralOpciones;

public class BotonAgregarJinete extends Button {

    public BotonAgregarJinete(VistaDeTablero vistaDeTablero, BarraLateralOpciones vistaLateral, Juego juego) {

        super();
        this.setMinHeight(20);
        this.setMinWidth(140);
        this.setOnAction(new BotonAgregarJineteEventHandler(vistaDeTablero,vistaLateral,juego));
        this.setText("Agregar jinete");
    }
}
