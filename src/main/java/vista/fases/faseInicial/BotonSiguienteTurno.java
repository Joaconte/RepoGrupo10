package vista.fases.faseInicial;

import controlador.buttonHandlers.fase.faseInicial.BotonSiguienteTurnoEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Juego;
import vista.VistaDeTablero;

public class BotonSiguienteTurno extends Button {
    public  BotonSiguienteTurno(EtiquetaTurnoJugador etiquetaTurnoJugador, EtiquetaPuntosJugador etiquetaPuntosJugador, Juego juego, Label etiquetaAlertas, VBox vbox, HBox hbox, VistaDeTablero vistaDeTablero) {
        super("Termirnar mi turno");
        this.setMinHeight(30);
        this.setOnAction(new BotonSiguienteTurnoEventHandler(etiquetaTurnoJugador, etiquetaPuntosJugador, juego, etiquetaAlertas, vbox, hbox, vistaDeTablero));
    }
}
