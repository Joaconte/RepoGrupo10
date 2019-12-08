package vista.fasesPartida.faseInicialPartida;

import controlador.buttonHandlers.BotonConfirmarEjercitoEventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modelo.Juego;
import vista.VistaDeTablero;

public class BotonConfirmarEjercito extends Button {
    public BotonConfirmarEjercito(Juego juego, Stage escenarioPrincipal, VistaDeTablero vistaDeTablero, BarraLateralOpciones vistaLateral) {
        super("Termirnar mi turno");
        this.setMinHeight(30);
        this.setOnAction(new BotonConfirmarEjercitoEventHandler(juego, escenarioPrincipal, vistaDeTablero,vistaLateral));
    }
}
