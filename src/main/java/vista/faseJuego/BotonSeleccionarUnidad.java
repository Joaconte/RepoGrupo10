package vista.faseJuego;

import controlador.buttonHandlers.BotonSeleccionarUnidadEventHandler;
import javafx.scene.control.Button;
import modelo.Juego;
import vista.CamposDeTexto;

public class BotonSeleccionarUnidad extends Button {

    public BotonSeleccionarUnidad(CamposDeTexto camposDeTexto, Juego juego){
        super("Seleccionar unidad");
        this.setMinHeight(30);
        this.setOnAction(new BotonSeleccionarUnidadEventHandler(camposDeTexto, juego));
    }
}
