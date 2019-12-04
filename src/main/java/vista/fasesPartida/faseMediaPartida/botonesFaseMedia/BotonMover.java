package vista.fasesPartida.faseMediaPartida.botonesFaseMedia;

import controlador.buttonHandlers.BotonMoverEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modelo.Juego;
import modelo.pieza.Ubicacion;
import vista.VistaDeTablero;

public class BotonMover extends Button {

    public BotonMover( Ubicacion ubicacion, Juego juego, Label etiquetaAlerta, VistaDeTablero vistaDeTablero) {
        super("Mover");
        this.setOnAction(new BotonMoverEventHandler(ubicacion, juego, etiquetaAlerta, vistaDeTablero));
    }
}
