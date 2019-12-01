package vista.fasePartida.faseInicialPartida.botonesAgregarPiezas;

import controlador.buttonHandlers.agregarPiezasEventHandlers.BotonAgregarInfanteriaEventHandler;
import javafx.scene.control.Button;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.fasePartida.faseInicialPartida.EtiquetaPuntosJugador;

public class BotonAgregarInfanteria extends Button {

    public BotonAgregarInfanteria(CamposDeTexto camposDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos) {

        super();
        this.setMinHeight(20);
        this.setOnAction(new BotonAgregarInfanteriaEventHandler(camposDeTexto, vistaDeTablero, etiquetaPuntos));
        this.setText("Agregar infanteria");
    }
}
