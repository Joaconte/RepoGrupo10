package vista.fases.faseJuego;

import controlador.buttonHandlers.fase.faseJuego.BotonActualizarPosicionesEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modelo.pieza.Ubicacion;

public class BotonActualizarPosiciones extends Button {

    public BotonActualizarPosiciones(Label etiquetaUbicacion1, Label etiquetaUbicacion2, Ubicacion ubicacionInicial, Ubicacion ubicacionFinal){
        super("Actualizar posciones");
        this.setMinHeight(30);
        this.setOnAction(new BotonActualizarPosicionesEventHandler(etiquetaUbicacion1, etiquetaUbicacion2, ubicacionInicial, ubicacionFinal));
    }
}
