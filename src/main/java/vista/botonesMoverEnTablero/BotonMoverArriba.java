package vista.botonesMoverEnTablero;

import controlador.buttonHandlers.moverEnTablero.BotonMoverArribaEventHandler;
import javafx.scene.control.Button;
import vista.CamposDeTexto;
import vista.VistaDeTablero;

public class BotonMoverArriba extends Button {

        public BotonMoverArriba(VistaDeTablero vistaDeTablero, CamposDeTexto camposDeTexto) {
            super("Arriba");
            this.setMinHeight(10);
            this.setOnAction(new BotonMoverArribaEventHandler(vistaDeTablero, camposDeTexto));
        }
}
