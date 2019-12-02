package vista.fases.faseInicial.botonesMoverEnTablero;

import controlador.buttonHandlers.moverEnTablero.BotonMoverArribaEventHandler;
import javafx.scene.control.Button;
import modelo.pieza.Ubicacion;
import vista.CamposDeTexto;
import vista.VistaDeTablero;

public class BotonMoverArriba extends Button {

        public BotonMoverArriba(VistaDeTablero vistaDeTablero, Ubicacion ubicacion) {
            super("Arriba");
            this.setMinHeight(10);
            this.setOnAction(new BotonMoverArribaEventHandler(vistaDeTablero, ubicacion));
        }
}
