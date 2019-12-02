package vista.fases.faseInicial.botonesMoverEnTablero;

import controlador.buttonHandlers.moverEnTablero.BotonMoverDerechaEventHandler;
import javafx.scene.control.Button;
import modelo.pieza.Ubicacion;
import vista.CamposDeTexto;
import vista.VistaDeTablero;

public class BotonMoverDerecha extends Button {

    public BotonMoverDerecha(VistaDeTablero vistaDeTablero, Ubicacion ubicacion) {
        super("Derecha");
        this.setMinHeight(10);
        this.setOnAction(new BotonMoverDerechaEventHandler(vistaDeTablero, ubicacion));
        this.getBackground();
    }
}