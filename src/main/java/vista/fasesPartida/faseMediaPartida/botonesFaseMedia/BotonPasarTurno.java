package vista.fasesPartida.faseMediaPartida.botonesFaseMedia;

import controlador.buttonHandlers.accionDeTurno.BotonPasarTurnoEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modelo.Juego;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.BarraDeJugador;
import vista.fasesPartida.faseMediaPartida.PantallaFaseMediaPartida;


public class BotonPasarTurno extends Button {

    public BotonPasarTurno(Juego juego, PantallaFaseMediaPartida vistaFaseMedia , VistaDeTablero vistaDeTablero) {
        super("Terminar Turno");
        this.setOnAction(new BotonPasarTurnoEventHandler(juego,vistaFaseMedia,vistaDeTablero));

    }
}
