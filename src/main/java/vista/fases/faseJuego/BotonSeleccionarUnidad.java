package vista.fases.faseJuego;

import controlador.buttonHandlers.fase.faseJuego.BotonSeleccionarUnidadEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modelo.Juego;
import modelo.pieza.Ubicacion;

public class BotonSeleccionarUnidad extends Button {

    public BotonSeleccionarUnidad(Ubicacion ubicacionVariable, Ubicacion ubicacionEstatica, Juego juego, Label etiquetaAlerta){
        super("Seleccionar unidad");
        this.setMinHeight(30);
        this.setOnAction(new BotonSeleccionarUnidadEventHandler(ubicacionVariable, ubicacionEstatica, juego, etiquetaAlerta));
    }
}
