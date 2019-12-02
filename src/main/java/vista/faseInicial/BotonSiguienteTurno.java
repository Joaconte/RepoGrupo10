package vista.faseInicial;

import controlador.buttonHandlers.BotonSiguienteTurnoEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Juego;
import vista.CamposDeTexto;
import vista.EtiquetaFase;
import vista.VistaDeTablero;

public class BotonSiguienteTurno extends Button {
    public  BotonSiguienteTurno(EtiquetaTurnoJugador etiquetaTurnoJugador, EtiquetaPuntosJugador etiquetaPuntosJugador, Juego juego, CamposDeTexto camposDeTexto, VBox vbox, HBox hbox, VistaDeTablero vistaDeTablero) {
        super("Termirnar mi turno");
        this.setMinHeight(30);
        this.setOnAction(new BotonSiguienteTurnoEventHandler(etiquetaTurnoJugador, etiquetaPuntosJugador, juego, camposDeTexto, vbox, hbox, vistaDeTablero));
    }
}
