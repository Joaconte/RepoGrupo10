package vista.fasesPartida.faseInicialPartida.botonesAgregarPiezas;

import controlador.buttonHandlers.agregarPiezasEventHandlers.BotonAgregarInfanteriaEventHandler;
import javafx.scene.control.Button;
import modelo.Juego;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.BarraLateralOpciones;

public class BotonAgregarInfanteria extends Button {

    public BotonAgregarInfanteria(VistaDeTablero vistaDeTablero, BarraLateralOpciones vistaLateral, Juego juego) {

        super();
        this.setMinHeight(20);
        this.setMinWidth(140);
        this.setOnAction(new BotonAgregarInfanteriaEventHandler(vistaDeTablero,vistaLateral,juego));
        this.setText("Agregar infanteria");
    }
}
