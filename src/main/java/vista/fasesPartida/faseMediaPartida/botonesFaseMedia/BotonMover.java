package vista.fasesPartida.faseMediaPartida.botonesFaseMedia;

import controlador.buttonHandlers.fase.faseJuego.BotonMoverEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modelo.Juego;
import modelo.pieza.Ubicacion;
import vista.VistaDeTablero;

public class BotonMover extends Button {

    public BotonMover(Ubicacion ubicacionInicial, Ubicacion ubicacionFinal, Juego juego, Label etiquetaAlerta, VistaDeTablero vistaDeTablero) {
        super("Mover");
        this.setMinHeight(30);
        this.setOnAction(new BotonMoverEventHandler(ubicacionInicial, ubicacionFinal, juego, etiquetaAlerta, vistaDeTablero));
    }
}
