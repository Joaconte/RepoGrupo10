package vista.fases.faseInicial.botonesMoverEnTablero;

import controlador.buttonHandlers.moverEnTablero.BotonMoverIzquierdaEventHandler;
import javafx.scene.control.Button;
import modelo.pieza.Ubicacion;
import vista.CamposDeTexto;
import vista.VistaDeTablero;

public class BotonMoverIzquierda extends Button {

    public BotonMoverIzquierda(VistaDeTablero vistaDeTablero, Ubicacion ubicacion) {
        super("Izquierda");
        this.setMinHeight(10);
        this.setOnAction(new BotonMoverIzquierdaEventHandler(vistaDeTablero, ubicacion));
    }
}
