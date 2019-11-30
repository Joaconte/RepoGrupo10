package vista.botonesMoverEnTablero;

import controlador.buttonHandlers.moverEnTablero.BotonMoverDerechaEventHandler;
import javafx.scene.control.Button;
import vista.CamposDeTexto;
import vista.VistaDeTablero;

public class BotonMoverDerecha extends Button {

    public BotonMoverDerecha(VistaDeTablero vistaDeTablero, CamposDeTexto camposDeTexto) {
        super("Derecha");
        this.setMinHeight(10);
        this.setOnAction(new BotonMoverDerechaEventHandler(vistaDeTablero, camposDeTexto));
    }
}