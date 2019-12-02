package vista.fases.faseInicial.botonesAgregarPiezas;

import controlador.buttonHandlers.fase.faseInicial.agregarPiezasEventHandlers.BotonAgregarInfanteriaEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modelo.pieza.Ubicacion;
import vista.VistaDeTablero;
import vista.fases.faseInicial.EtiquetaPuntosJugador;

public class BotonAgregarInfanteria extends Button {

    public BotonAgregarInfanteria(Label etiquetaAlertas, Ubicacion ubicacion, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos) {

        super();
        this.setMinHeight(20);
        this.setOnAction(new BotonAgregarInfanteriaEventHandler(etiquetaAlertas, ubicacion, vistaDeTablero, etiquetaPuntos));
        this.setText("Agregar infanteria");
    }
}
