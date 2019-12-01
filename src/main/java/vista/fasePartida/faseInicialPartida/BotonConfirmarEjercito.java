package vista.fasePartida.faseInicialPartida;

import controlador.buttonHandlers.BotonConfirmarEjercitoEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Juego;
import vista.CamposDeTexto;
import vista.fasePartida.EtiquetaTurnoJugador;

public class BotonConfirmarEjercito extends Button {
    public BotonConfirmarEjercito(EtiquetaTurnoJugador etiquetaTurnoJugador, EtiquetaPuntosJugador etiquetaPuntosJugador, Juego juego, CamposDeTexto camposDeTexto, Stage escenarioPrincipal) {
        super("Termirnar mi turno");
        this.setMinHeight(30);
        this.setOnAction(new BotonConfirmarEjercitoEventHandler(etiquetaTurnoJugador, etiquetaPuntosJugador, juego, camposDeTexto, escenarioPrincipal));
    }
}
