package vista.fasesPartida.faseMediaPartida.botonesFaseMedia;

import controlador.buttonHandlers.accionDeTurno.BotonPasarTurnoEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modelo.Juego;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.BarraDeJugador;


public class BotonPasarTurno extends Button {

    public BotonPasarTurno(PanelBotonesFaseMedia panelBotonesFaseMedia, Juego juego, Label comunicador, BarraDeJugador barraDeJugador1, BarraDeJugador barraDeJugador2, VistaDeTablero vistaDeTablero) {
        super("Terminar Turno");
        this.setOnAction(new BotonPasarTurnoEventHandler(panelBotonesFaseMedia, juego,comunicador,barraDeJugador1,barraDeJugador2,vistaDeTablero));

    }
}
