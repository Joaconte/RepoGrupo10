package vista.fases.faseJuego;

import controlador.buttonHandlers.fase.faseJuego.BotonMoverUnidadEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modelo.Juego;
import modelo.pieza.Ubicacion;
import vista.VistaDeTablero;

public class BotonMoverUnidad extends Button {

    public BotonMoverUnidad(Ubicacion ubicacionInicial, Ubicacion ubicacionFinal, Juego juego, Label etiquetaAlerta, VistaDeTablero vistaDeTablero) {
        super("Mover unidad");
        this.setMinHeight(30);
        this.setOnAction(new BotonMoverUnidadEventHandler(ubicacionInicial, ubicacionFinal, juego, etiquetaAlerta, vistaDeTablero));
    }
}
