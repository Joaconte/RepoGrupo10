package vista.fasesPartida.faseInicialPartida;

import controlador.buttonHandlers.BotonConfirmarEjercitoEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import modelo.Juego;
import vista.VistaDeTablero;
import vista.fasesPartida.EtiquetaTurnoJugador;

public class BotonConfirmarEjercito extends Button {
    public BotonConfirmarEjercito(EtiquetaTurnoJugador etiquetaTurnoJugador, EtiquetaPresupuestoJugador etiquetaPresupuestoJugador, Juego juego, Label etiquetaComunicacion, Stage escenarioPrincipal, VistaDeTablero vistaDeTablero) {
        super("Termirnar mi turno");
        this.setMinHeight(30);
        this.setOnAction(new BotonConfirmarEjercitoEventHandler(etiquetaTurnoJugador, etiquetaPresupuestoJugador, juego, etiquetaComunicacion, escenarioPrincipal,  vistaDeTablero));
    }
}
