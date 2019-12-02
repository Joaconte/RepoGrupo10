package vista.fases.faseInicial.botonesMoverEnTablero;

import controlador.buttonHandlers.moverEnTablero.BotonMoverAbajoEventHandler;
import javafx.scene.control.Button;
import modelo.pieza.Ubicacion;
import vista.CamposDeTexto;
import vista.VistaDeTablero;

public class BotonMoverAbajo extends Button {

        public BotonMoverAbajo(VistaDeTablero vistaDeTablero, Ubicacion ubicacion) {
            super("Abajo");
            this.setMinHeight(10);
            this.setOnAction(new BotonMoverAbajoEventHandler(vistaDeTablero, ubicacion));
        }
}