package vista.botonesMoverEnTablero;

import controlador.buttonHandlers.moverEnTablero.BotonMoverIzquierdaEventHandler;
import javafx.scene.control.Button;
import vista.CamposDeTexto;
import vista.VistaDeTablero;

public class BotonMoverIzquierda extends Button {

    public BotonMoverIzquierda(VistaDeTablero vistaDeTablero, CamposDeTexto camposDeTexto) {
        super("Izquierda");
        this.setMinHeight(10);
        this.setOnAction(new BotonMoverIzquierdaEventHandler(vistaDeTablero, camposDeTexto));
    }
}
