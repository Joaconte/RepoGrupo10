package vista.fases.faseInicial.botonesAgregarPiezas;

import controlador.buttonHandlers.fase.faseInicial.agregarPiezasEventHandlers.BotonAgregarJineteEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modelo.pieza.Ubicacion;
import vista.VistaDeTablero;
import vista.fases.faseInicial.EtiquetaPuntosJugador;

public class BotonAgregarJinete extends Button {

    public BotonAgregarJinete(Label etiquetaAlertas, Ubicacion ubicacion, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos) {

        super();
        this.setMinHeight(20);
        this.setOnAction(new BotonAgregarJineteEventHandler(etiquetaAlertas, ubicacion, vistaDeTablero, etiquetaPuntos));
        this.setText("Agregar jinete");
    }
}
