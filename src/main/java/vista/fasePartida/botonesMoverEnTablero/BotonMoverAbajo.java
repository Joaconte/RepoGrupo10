package vista.fasePartida.botonesMoverEnTablero;

import controlador.buttonHandlers.moverEnTablero.BotonMoverAbajoEventHandler;
import javafx.scene.control.Button;
import vista.CamposDeTexto;
import vista.VistaDeTablero;

public class BotonMoverAbajo extends Button {

        public BotonMoverAbajo(VistaDeTablero vistaDeTablero, CamposDeTexto camposDeTexto) {
            super("Abajo");
            this.setMinHeight(10);
            this.setOnAction(new BotonMoverAbajoEventHandler(vistaDeTablero, camposDeTexto));
        }
}